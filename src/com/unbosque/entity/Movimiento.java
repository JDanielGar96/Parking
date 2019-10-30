package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the movimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Movimiento.findAll", query="SELECT m FROM Movimiento m")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraLlegada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraReserva;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraSalida;

	private String placa;

	private Time tiempo;

	private int tipoCobro;

	private String tipoParqueadero;

	private int valorCobro;

	public Movimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getFechaHoraSalida() {
		return this.fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Time getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

	public int getTipoCobro() {
		return this.tipoCobro;
	}

	public void setTipoCobro(int tipoCobro) {
		this.tipoCobro = tipoCobro;
	}

	public String getTipoParqueadero() {
		return this.tipoParqueadero;
	}

	public void setTipoParqueadero(String tipoParqueadero) {
		this.tipoParqueadero = tipoParqueadero;
	}

	public int getValorCobro() {
		return this.valorCobro;
	}

	public void setValorCobro(int valorCobro) {
		this.valorCobro = valorCobro;
	}

}