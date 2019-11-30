package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 2)
	private short id;
	@Column(name = "nitEmpresa", nullable = false, length = 20)
	private String nitEmpresa;
	@Column(name = "razonSocialEmpresa", nullable = false, length = 40)
	private String razonSocialEmpresa;
	@Column(name = "telefonosEmpresa", nullable = false, length = 60)
	private String telefonosEmpresa;
	@Column(name = "correoEmpresa", nullable = false, length = 60)
	private String correoEmpresa;
	@Column(name = "direccionEmpresa", nullable = false, length = 60)
	private String direccionEmpresa;
	@Column(name = "estadoEmpresa", nullable = false, length = 1)
	private String estadoEmpresa;

	public Empresa() {
	}

	public Empresa(short id, String nitEmpresa, String razonSocialEmpresa, String telefonosEmpresa,
			String correoEmpresa, String direccionEmpresa, String estadoEmpresa) {
		super();
		this.id = id;
		this.nitEmpresa = nitEmpresa;
		this.razonSocialEmpresa = razonSocialEmpresa;
		this.telefonosEmpresa = telefonosEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.estadoEmpresa = estadoEmpresa;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getNitEmpresa() {
		return nitEmpresa;
	}

	public void setNitEmpresa(String nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}

	public String getRazonSocialEmpresa() {
		return razonSocialEmpresa;
	}

	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}

	public String getTelefonosEmpresa() {
		return telefonosEmpresa;
	}

	public void setTelefonosEmpresa(String telefonosEmpresa) {
		this.telefonosEmpresa = telefonosEmpresa;
	}

	public String getCorreoEmpresa() {
		return correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getEstadoEmpresa() {
		return estadoEmpresa;
	}

	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}