package com.unbosque.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.unbosque.entity.*;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				@SuppressWarnings("deprecation")
				AnnotationConfiguration ac = new AnnotationConfiguration();
				ac.addAnnotatedClass(Auditoria.class);
				ac.addAnnotatedClass(Movimiento.class);
				ac.addAnnotatedClass(Parametro.class);
				ac.addAnnotatedClass(Parqueadero.class);
				ac.addAnnotatedClass(Tarifa.class);
				ac.addAnnotatedClass(Usuario.class);
				ac.addAnnotatedClass(Vehiculo.class);
				ac.addAnnotatedClass(Empresa.class);
				sessionFactory = ac.configure().buildSessionFactory();

			} catch (Throwable ex) {
				// Log the exception.
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}