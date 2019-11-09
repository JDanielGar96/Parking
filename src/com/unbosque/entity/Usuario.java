package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "login", nullable = false, length = 8)
	private String login;
	@Column(name = "clave", nullable = false, length = 256)
	private String clave;
	@Column(name = "tcredito", nullable = false, length = 30)
	private String tcredito;
	@Column(name = "apellidosNombres", nullable = false, length = 80)
	private String apellidosNombres;
	@Column(name = "correo", nullable = false, length = 75)
	private String correo;
	@Column(name = "celular", nullable = false, length = 15)
	private String celular;
	@Column(name = "direccion", nullable = false, length = 45)
	private String direccion;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaUltimoPassword", nullable = false, length = 19)
	private Date fechaUltimoPassword;
	@Column(name = "activo", nullable = false, length = 1)
	private String activo;
	@Column(name = "intentos", nullable = false, length = 2)
	private int intentos;
	@Column(name = "tipoUsuario", nullable = false, length = 7)
	private String tipoUsuario;

	public Usuario() {
	}

	public Usuario(int id, String login, String clave, String tcredito, String apellidosNombres, String correo,
			String celular, String direccion, Date fechaUltimoPassword, String activo, int intentos,
			String tipoUsuario) {
		super();
		this.id = id;
		this.login = login;
		this.clave = clave;
		this.tcredito = tcredito;
		this.apellidosNombres = apellidosNombres;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
		this.fechaUltimoPassword = fechaUltimoPassword;
		this.activo = activo;
		this.intentos = intentos;
		this.tipoUsuario = tipoUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTcredito() {
		return tcredito;
	}

	public void setTcredito(String tcredito) {
		this.tcredito = tcredito;
	}

	public String getApellidosNombres() {
		return apellidosNombres;
	}

	public void setApellidosNombres(String apellidosNombres) {
		this.apellidosNombres = apellidosNombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaUltimoPassword() {
		return fechaUltimoPassword;
	}

	public void setFechaUltimoPassword(Date fechaUltimoPassword) {
		this.fechaUltimoPassword = fechaUltimoPassword;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}