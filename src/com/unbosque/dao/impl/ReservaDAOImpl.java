package com.unbosque.dao.impl;

import com.unbosque.dao.DaoGeneral;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Reserva;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservaDAOImpl implements DaoGeneral {

	@Override
	public boolean save(Object object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Reserva savedObject = (Reserva) object;
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
			Reserva object = (Reserva) session.load(Reserva.class, id);
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
			List list = session.createQuery("from Reserva").list();
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
			Reserva removedObject = (Reserva) object;
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
			Reserva updatedObject = (Reserva) object;
			session.update(updatedObject);
			transaction.commit();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
