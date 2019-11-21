package com.unbosque.dao.impl;

import com.unbosque.dao.DaoGeneral;
import com.unbosque.util.HibernateUtil;
import com.unbosque.entity.Parqueadero;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParqueaderoDAOImpl implements DaoGeneral {
    	
	@Override
	public boolean save(Object object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Parqueadero savedObject = (Parqueadero) object;
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
			Parqueadero object = (Parqueadero) session.load(Parqueadero.class, id);
			return object;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Object> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List list = session.createQuery("from Parqueadero").list();
		System.out.println(list);
		transaction.commit();
		return list;
	}


	@Override
	public boolean remove(Object object) {
		try {			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Parqueadero removedObject = (Parqueadero) object;
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
			Parqueadero updatedObject = (Parqueadero) object;
			session.update(updatedObject);
			transaction.commit();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
