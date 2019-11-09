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
	@Column(name = "idEmpresa", nullable = false, length = 5)
	private int idEmpresa;
	@Column(name = "nombreParqueadero", nullable = false, length = 30)
	private String nombreParqueadero;
	@Column(name = "ciudad", nullable = false, length = 30)
	private String ciudad;
	@Column(name = "correo", nullable = false, length = 45)
	private String correo;
	@Column(name = "disponibilidad", nullable = false, length = 2)
	private int disponibilidad;
	@Column(name = "servicio", nullable = false, length = 45)
	private String servicio;
	@Column(name = "fidelizacion", nullable = false, length = 1)
	private String fidelizacion;
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	public Parqueadero() {
	}

	public Parqueadero(int id, int idEmpresa, String nombreParqueadero, String ciudad, String correo,
			int disponibilidad, String servicio, String fidelizacion, String estado) {
		super();
		this.id = id;
		this.idEmpresa = idEmpresa;
		this.nombreParqueadero = nombreParqueadero;
		this.ciudad = ciudad;
		this.correo = correo;
		this.disponibilidad = disponibilidad;
		this.servicio = servicio;
		this.fidelizacion = fidelizacion;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getFidelizacion() {
		return fidelizacion;
	}

	public void setFidelizacion(String fidelizacion) {
		this.fidelizacion = fidelizacion;
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