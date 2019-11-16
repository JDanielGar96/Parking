package com.unbosque.dao.impl;

import com.unbosque.dao.Dao;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Parametro;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParametroDAOImpl implements Dao {
    	
	@Override
	public boolean save(Object object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Parametro savedObject = (Parametro) object;
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
			Parametro object = (Parametro) session.load(Parametro.class, id);
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
			List list = session.createQuery("from Parametro").list();
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
			Parametro removedObject = (Parametro) object;
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
			Parametro updatedObject = (Parametro) object;
			session.update(updatedObject);
			transaction.commit();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
