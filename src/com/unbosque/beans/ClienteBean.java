package com.unbosque.beans;

import com.unbosque.dao.impl.UserDAOImpl;
import com.unbosque.entity.Usuario;
import com.unbosque.dao.DaoGeneral;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Parqueadero;
import com.unbosque.dao.impl.ParqueaderoDAOImpl;;

@ManagedBean
@SessionScoped
public class ClienteBean {
	private Usuario usuario;
	
	private double latitud = 4.570868;
	private double longitud = -74.297333;
	private double zoom = 5;
	
	private ParqueaderoDAOImpl implementacion;
	private Movimiento movimiento;

	public ClienteBean() { 
		implementacion = new ParqueaderoDAOImpl();
	}
	
	public void crearMovimiento() {
		Date date = new Date();
		this.movimiento = new Movimiento();
		this.movimiento.getParqueaderoId();
		this.movimiento.setFechaHoraReserva(date);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario= usuario;
	}

	public double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public void mostrarUbicacion() {
		System.out.println("Longitud " + this.longitud);
		System.out.println("Latitud " + this.latitud);
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
}
