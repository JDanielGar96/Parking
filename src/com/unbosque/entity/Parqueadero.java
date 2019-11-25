package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the parqueadero database table.
 * 
 */
@Entity
@NamedQuery(name = "Parqueadero.findAll", query = "SELECT p FROM Parqueadero p")
public class Parqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "propietario", nullable = false, length = 5)
	private int propietario;
	@Column(name = "nombreParqueadero", nullable = false, length = 30)
	private String nombreParqueadero;
	@Column(name = "ciudad", nullable = false, length = 30)
	private String ciudad;
	@Column(name = "correo", nullable = false, length = 45)
	private String correo;
	@Column(name = "disponibilidad", nullable = false, length = 2)
	private int disponibilidad;
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	@Column(name = "latitud", nullable = false, length = 20)
	private double latitud;
	@Column(name = "longitud", nullable = false, length = 20)
	private double longitud;

	public Parqueadero() {
	}

	public Parqueadero(int id, int propietario, String nombreParqueadero, String ciudad, String correo,
			int disponibilidad, String estado, double latitud, double longitud) {
		super();
		this.id = id;
		this.propietario = propietario;
		this.nombreParqueadero = nombreParqueadero;
		this.ciudad = ciudad;
		this.correo = correo;
		this.disponibilidad = disponibilidad;
		this.estado = estado;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPropietario() {
		return propietario;
	}

	public void setPropietario(int propietario) {
		this.propietario = propietario;
	}

	public String getNombreParqueadero() {
		return nombreParqueadero;
	}

	public void setNombreParqueadero(String nombreParqueadero) {
		this.nombreParqueadero = nombreParqueadero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}