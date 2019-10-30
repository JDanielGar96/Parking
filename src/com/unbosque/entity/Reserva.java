package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	private String activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraLlegada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraReserva;

	private int id;

	private Time tiempoEstimado;

	private int tipoCobro;

	private String tipoServicio;

	private int valorCobro;

	public Reserva() {
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Date getFechaHoraLlegada() {
		return this.fechaHoraLlegada;
	}

	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}

	public Date getFechaHoraReserva() {
		return this.fechaHoraReserva;
	}

	public void setFechaHoraReserva(Date fechaHoraReserva) {
		this.fechaHoraReserva = fechaHoraReserva;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getTiempoEstimado() {
		return this.tiempoEstimado;
	}

	public void setTiempoEstimado(Time tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public int getTipoCobro() {
		return this.tipoCobro;
	}

	public void setTipoCobro(int tipoCobro) {
		this.tipoCobro = tipoCobro;
	}

	public String getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public int getValorCobro() {
		return this.valorCobro;
	}

	public void setValorCobro(int valorCobro) {
		this.valorCobro = valorCobro;
	}

}