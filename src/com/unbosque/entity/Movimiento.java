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
@NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "placa", nullable = false, length = 6)
	private String placa;
	@Column(name = "tipoParqueadero", nullable = false, length = 20)
	private String tipoParqueadero;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraReserva", nullable = false)
	private Date fechaHoraReserva;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraLlegada", nullable = false)
	private Date fechaHoraLlegada;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraSalida", nullable = false)
	private Date fechaHoraSalida;
	@Column(name = "tiempo", nullable = false)
	private Time tiempo;
	@Column(name = "valorCobro", nullable = false, length = 8)
	private int valorCobro;
	@Column(name = "tipoCobro", nullable = false, length = 5)
	private int tipoCobro;
	@Column(name = "activo", nullable = false, length = 1)
	private String activo;

	public Movimiento() {
	}

	public Movimiento(int id, String placa, String tipoParqueadero, Date fechaHoraReserva, Date fechaHoraLlegada,
			Date fechaHoraSalida, Time tiempo, int valorCobro, int tipoCobro, String activo) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipoParqueadero = tipoParqueadero;
		this.fechaHoraReserva = fechaHoraReserva;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tiempo = tiempo;
		this.valorCobro = valorCobro;
		this.tipoCobro = tipoCobro;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoParqueadero() {
		return tipoParqueadero;
	}

	public void setTipoParqueadero(String tipoParqueadero) {
		this.tipoParqueadero = tipoParqueadero;
	}

	public Date getFechaHoraReserva() {
		return fechaHoraReserva;
	}

	public void setFechaHoraReserva(Date fechaHoraReserva) {
		this.fechaHoraReserva = fechaHoraReserva;
	}

	public Date getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}

	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}

	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Time getTiempo() {
		return tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

	public int getValorCobro() {
		return valorCobro;
	}

	public void setValorCobro(int valorCobro) {
		this.valorCobro = valorCobro;
	}

	public int getTipoCobro() {
		return tipoCobro;
	}

	public void setTipoCobro(int tipoCobro) {
		this.tipoCobro = tipoCobro;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}