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
	@Column(name = "loginCliente", nullable = false, length = 8)
	private String loginCliente;
	@Column(name = "parqueaderoId", nullable = false, length = 5)
	private int parqueaderoId;
	@Column(name = "placa", nullable = false, length = 6)
	private String placa;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraReserva", nullable = false)
	private Date fechaHoraReserva;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraLlegada", nullable = false)
	private Date fechaHoraLlegada;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHoraSalida", nullable = false)
	private Date fechaHoraSalida;
	@Column(name = "Tiempo", nullable = false, length = 8)
	private int tiempo;
	@Column(name = "valorCobro", nullable = false, length = 8)
	private int valorCobro;
	@Column(name = "activo", nullable = false, length = 1)
	private String activo;

	public Movimiento() {
	}

	public Movimiento(int id, String loginCliente, int parqueaderoId, String placa, Date fechaHoraReserva, Date fechaHoraLlegada,
			Date fechaHoraSalida, int tiempo, int valorCobro, String activo) {
		super();
		this.id = id;
		this.loginCliente = loginCliente;
		this.parqueaderoId = parqueaderoId;
		this.placa = placa;
		this.fechaHoraReserva = fechaHoraReserva;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tiempo = tiempo;
		this.valorCobro = valorCobro;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParqueaderoId() {
		return parqueaderoId;
	}
	
	public void setParqueaderoId(int parqueaderoId) {
		this.parqueaderoId = parqueaderoId;
	}
	
	public String getLoginCliente() {
		return this.loginCliente;
	}
	
	public void setLoginClient(String loginCliente) {
		this.loginCliente = loginCliente;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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
	
	public int getTiempo() {
		return this.tiempo;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getValorCobro() {
		return valorCobro;
	}

	public void setValorCobro(int valorCobro) {
		this.valorCobro = valorCobro;
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