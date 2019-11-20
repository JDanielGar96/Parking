package com.unbosque.dao.impl;

import com.unbosque.dao.Dao;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Usuario;

import java.util.List;

import org.hibernate.Query;
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
			session.close();
			return object;
		} catch (Exception e) {
			return null;
		}
	}

	public Object getByEmail(String email) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Usuario object = (Usuario) session.load(Usuario.class, email);
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
}
