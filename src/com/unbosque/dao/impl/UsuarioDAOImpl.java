package com.unbosque.dao.impl;

import com.unbosque.dao.DaoUser;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	public Object get(long id) {
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
	public boolean login(String login, String password) {
        Transaction transaction = null;
        Usuario user = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Object userObject = (Object) session.createQuery("FROM Usuario WHERE login = :login")
					.setString("login", login)
					.uniqueResult();
			user = (Usuario) userObject;
			if(user.getClave().equals(password)) {
				return true;
			}
			transaction.commit();
		} catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            e.printStackTrace();
		}
		return false;
	}
}
