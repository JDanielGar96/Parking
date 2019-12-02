package com.unbosque.dao.impl;

import com.unbosque.dao.DaoUser;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.unbosque.util.Email;
import com.unbosque.util.Encriptacion;

public class UsuarioDAOImpl implements DaoUser {
	
	@Override
	public boolean save(Object object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Usuario savedObject = (Usuario) object;
			session.save(savedObject);
			t.commit();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Object get(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Usuario object = (Usuario) session.load(Usuario.class, id);
			session.close();
			return object;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Usuario");
			List<Object> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean remove(Object object) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Usuario removedObject = (Usuario) object;
			session.delete(removedObject);
			t.commit();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Object object) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Usuario updatedObject = (Usuario) object;
			session.update(updatedObject);
			transaction.commit();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Object getByLogin(String login) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createSQLQuery("from usuario where login = :login").addEntity(Usuario.class);
			List result = query.setString("login", login).list();
			return (Object) result.get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Object getByEmail(String email) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createSQLQuery("from usuario where email = :email").addEntity(Usuario.class);
			List result = query.setString("email", email).list();
			return (Object) result.get(0);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public String login(String login, String password) {
		/*
		 *  Retorna el tipo de usuario si el password es correcto
		 *  si no es correcto retorna un error dependiendo de los intentos
		 *  realizados por el usuario.
		 */	
        Transaction transaction = null;
        Encriptacion enc = new Encriptacion();
        Usuario user = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Object userObject = (Object) session.createQuery("FROM Usuario WHERE login = :login")
					.setString("login", login)
					.uniqueResult();
			
			user = (Usuario) userObject;
			
			transaction.commit();
			if(user.getIntentos() < 3) {
				if(user.getClave().equals(enc.encriptar(password))) {
					if(user.getIntentos() != 0) {
						user.restablecerIntentos();
						this.update(user);
					}
					System.out.println("Logeo correcto");
					return user.getTipoUsuario();
				}
				user.aumentarIntentos();
				this.update(user);
				System.out.println("Logeo incorrecto");
				return "PASSWORD";
			} else {
				if(user.getIntentos() == 3) {

	        		Email email = new Email();
	        		ArrayList<String> recipesList = new ArrayList<String>();
	        		recipesList.add(user.getCorreo());
	        		
	        		// Send User!! 
	        		String content = "<!DOCTYPE html><html><body>"
	        				+ "<h1>Cliente de Sophyparking:</h1>"
	        				+ "<p>Tu cuenta se bloqueo por razones de seguridad, razon: <b> Contrase�a incorrecta multiples veces </b>"
	        				+ "</body></html>";
	        		email.sendEmail(recipesList, "Alerta de seguridad SophyParking", content);
	        		
	        		// Send Email!! 
	        		recipesList = new ArrayList<String>();
	        		recipesList.add(email.getEmail());
	        		
	        		content = "<!DOCTYPE html><html><body>"
	        				+ "<h1>Admin de Sophyparking:</h1>"
	        				+ "<p>La cuenta del cliente con usuario " + user.getLogin() + " se bloqueo por razones de seguridad, razon: <b> Contrase�a incorrecta multiples veces </b>"
	        				+ "</body></html>";
	        		email.sendEmail(recipesList, "Alerta de seguridad SophyParking", content);
				}
				user.aumentarIntentos();
				this.update(user);
				System.out.println("Se excedieron los intentos");
				return "INTENTOS";		
			}
			
		} catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            e.printStackTrace();
		}
		return null;
	}
}
