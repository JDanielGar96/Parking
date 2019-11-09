package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "descripcionTipoCobro", nullable = false, length = 30)
	private String descripcionTipoCobro;
	@Column(name = "valorTarifa", nullable = false, length = 11)
	private int valorTarifa;
	@Column(name = "descuento", nullable = false, length = 2)
	private int descuento;
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	public Tarifa() {
	}

	public Tarifa(int id, String descripcionTipoCobro, int valorTarifa, int descuento, String estado) {
		super();
		this.id = id;
		this.descripcionTipoCobro = descripcionTipoCobro;
		this.valorTarifa = valorTarifa;
		this.descuento = descuento;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcionTipoCobro() {
		return descripcionTipoCobro;
	}

	public void setDescripcionTipoCobro(String descripcionTipoCobro) {
		this.descripcionTipoCobro = descripcionTipoCobro;
	}

	public int getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(int valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
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