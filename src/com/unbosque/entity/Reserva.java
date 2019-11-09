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
@NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "tipoServicio", nullable = false, length = 20)
	private String tipoServicio;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraReserva", nullable = false)
	private Date fechaHoraReserva;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraLlegada", nullable = false)
	private Date fechaHoraLlegada;
	@Temporal(TemporalType.TIME)
	@Column(name = "tiempoEstimado", nullable = false)
	private Time tiempoEstimado;
	@Column(name = "valorCobro", nullable = false, length = 8)
	private int valorCobro;
	@Column(name = "tipoCobro", nullable = false, length = 5)
	private int tipoCobro;
	@Column(name = "activo", nullable = false, length = 1)
	private String activo;

	public Reserva() {
	}

	public Reserva(int id, String tipoServicio, Date fechaHoraReserva, Date fechaHoraLlegada, Time tiempoEstimado,
			int valorCobro, int tipoCobro, String activo) {
		super();
		this.id = id;
		this.tipoServicio = tipoServicio;
		this.fechaHoraReserva = fechaHoraReserva;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.tiempoEstimado = tiempoEstimado;
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

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
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

	public Time getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(Time tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
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