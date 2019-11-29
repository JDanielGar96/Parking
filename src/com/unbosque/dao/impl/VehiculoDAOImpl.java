package com.unbosque.dao.impl;

import com.unbosque.dao.DaoGeneral;
import com.unbosque.util.HibernateUtil;

import com.unbosque.entity.Vehiculo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VehiculoDAOImpl implements DaoGeneral {
    	
	@Override
	public boolean save(Object object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Vehiculo savedObject = (Vehiculo) object;
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
			Vehiculo object = (Vehiculo) session.load(Vehiculo.class, id);
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
			List list = session.createQuery("from Vehiculo").list();
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
			Vehiculo removedObject = (Vehiculo) object;
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
			Vehiculo updatedObject = (Vehiculo) object;
			session.update(updatedObject);
			transaction.commit();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
