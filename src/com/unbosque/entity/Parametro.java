package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "nombreParametro", nullable = false, length = 15)
	private String nombreParametro;
	@Column(name = "descripcion", nullable = false, length = 80)
	private String descripcion;
	@Column(name = "valorTexto", nullable = false, length = 20)
	private String valorTexto;
	@Column(name = "valorNumerico", nullable = false, length = 16)
	private int valorNumerico;
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	public Parametro() {
	}

	public Parametro(int id, String nombreParametro, String descripcion, String valorTexto, int valorNumerico,
			String estado) {
		super();
		this.id = id;
		this.nombreParametro = nombreParametro;
		this.descripcion = descripcion;
		this.valorTexto = valorTexto;
		this.valorNumerico = valorNumerico;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreParametro() {
		return nombreParametro;
	}

	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValorTexto() {
		return valorTexto;
	}

	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}

	public int getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(int valorNumerico) {
		this.valorNumerico = valorNumerico;
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