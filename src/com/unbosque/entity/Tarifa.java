package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcionTipoCobro;

	private int descuento;

	private String estado;

	private int valorTarifa;

	public Tarifa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcionTipoCobro() {
		return this.descripcionTipoCobro;
	}

	public void setDescripcionTipoCobro(String descripcionTipoCobro) {
		this.descripcionTipoCobro = descripcionTipoCobro;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getValorTarifa() {
		return this.valorTarifa;
	}

	public void setValorTarifa(int valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

}