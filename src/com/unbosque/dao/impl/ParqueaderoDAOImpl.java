package com.unbosque.dao.impl;

import com.unbosque.dao.DaoParqueadero;
import com.unbosque.util.HibernateUtil;
import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Parqueadero;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParqueaderoDAOImpl implements DaoParqueadero {
    	
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
	public Object get(int id) {
		try {			
			Object obj = new Object();
			Session session = HibernateUtil.getSessionFactory().openSession();
			Parqueadero object = (Parqueadero) session.load(Parqueadero.class, id);
			System.out.println(object == null);
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
		transaction.commit();
		return list;
	}
	
	@Override
	public List<Object> listAvaliables() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		List list = session
				.createQuery("FROM Parqueadero WHERE disponibilidad > 0").list();
		
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
	
	@Override
	public boolean updateAvaliability(int id, int disponibilidad) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createSQLQuery("SELECT * FROM Parqueadero "
							+ "WHERE id = :id").addEntity(Parqueadero.class);
			Parqueadero parqueadero = (Parqueadero) query.setInteger("id", id)
					.uniqueResult();
			
			parqueadero.setDisponibilidad(disponibilidad);
			
			session.update(parqueadero);
			
			transaction.commit();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
