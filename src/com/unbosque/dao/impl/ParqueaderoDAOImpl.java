package com.unbosque.dao.impl;
import com.unbosque.dao.Dao;
import com.unbosque.entity.Parqueadero;
import com.unbosque.util.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParqueaderoDAOImpl implements Dao {
	
	@Override
	public boolean save(Object paqueadero) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {			
			session.save(paqueadero);
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
			Parqueadero parqueadero = (Parqueadero) session.load(Parqueadero.class, id);
			return parqueadero;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Object> list() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			List list = session.createQuery("from Parqueadero").list();
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
			session.delete(object);
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
			Parqueadero parqueadero = (Parqueadero) object;
			session.update(parqueadero);
			transaction.commit();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
