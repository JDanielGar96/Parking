package com.unbosque.dao.impl;

import com.unbosque.dao.DaoMovimiento;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovimientoDAOImpl implements DaoMovimiento {
    	
	@Override
	public boolean save(Object object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Movimiento savedObject = (Movimiento) object;
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
			Movimiento object = (Movimiento) session.load(Movimiento.class, id);
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
			List list = session.createQuery("from Movimiento").list();
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
			Movimiento removedObject = (Movimiento) object;
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
			Movimiento updatedObject = (Movimiento) object;
			session.update(updatedObject);
			transaction.commit();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Object> listByClient(String login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createSQLQuery(
				"SELECT * FROM Movimiento"
				+ " WHERE loginCliente = :login").addEntity(Movimiento.class);
		List result = query.setString("login", login).list();
		
		transaction.commit();
		return result;
	}
}
