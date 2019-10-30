package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parqueadero database table.
 * 
 */
@Entity
@NamedQuery(name="Parqueadero.findAll", query="SELECT p FROM Parqueadero p")
public class Parqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ciudad;

	private String correo;

	private int disponibilidad;

	private String estado;

	private String fidelizacion;

	private int idEmpresa;

	private String nombreParqueadero;

	private String servicio;

	public Parqueadero() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFidelizacion() {
		return this.fidelizacion;
	}

	public void setFidelizacion(String fidelizacion) {
		this.fidelizacion = fidelizacion;
	}

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreParqueadero() {
		return this.nombreParqueadero;
	}

	public void setNombreParqueadero(String nombreParqueadero) {
		this.nombreParqueadero = nombreParqueadero;
	}

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

}