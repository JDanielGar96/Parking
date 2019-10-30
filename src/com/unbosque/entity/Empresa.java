package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	private String correoEmpresa;

	private String direccionEmpresa;

	private String estadoEmpresa;

	private String nitEmpresa;

	private String razonSocialEmpresa;

	private String telefonosEmpresa;

	public Empresa() {
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getCorreoEmpresa() {
		return this.correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getDireccionEmpresa() {
		return this.direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getEstadoEmpresa() {
		return this.estadoEmpresa;
	}

	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}

	public String getNitEmpresa() {
		return this.nitEmpresa;
	}

	public void setNitEmpresa(String nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}

	public String getRazonSocialEmpresa() {
		return this.razonSocialEmpresa;
	}

	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}

	public String getTelefonosEmpresa() {
		return this.telefonosEmpresa;
	}

	public void setTelefonosEmpresa(String telefonosEmpresa) {
		this.telefonosEmpresa = telefonosEmpresa;
	}

}