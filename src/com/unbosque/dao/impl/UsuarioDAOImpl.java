package com.unbosque.dao.impl;

import com.unbosque.dao.Dao;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Usuario;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAOImpl implements Dao {
    	
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
			return object;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Object> list() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			List list = session.createQuery("from Usuario").list();
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
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Usuario usuario = new Usuario(
				2, "Wsp", "Amiva", "021312312", "Garcia Davila Jose Daniel", "Josedgarciad@unbosque.edu.co", 
				"3123026202", "Cra 17a # 175 - 82", new Date(), "Activo", 3, "Admin"
		);
		UsuarioDAOImpl implementation = new UsuarioDAOImpl();
		implementation.save(usuario);
		System.out.println("Error");
	}
}
