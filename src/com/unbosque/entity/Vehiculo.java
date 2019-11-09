package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "placa", nullable = false, length = 6)
	private String placa;
	@Column(name = "tipo", nullable = false, length = 6)
	private String tipo;
	@Column(name = "marca", nullable = false, length = 12)
	private String marca;
	@Column(name = "modelo", nullable = false, length = 4)
	private int modelo;
	@Column(name = "color", nullable = false, length = 10)
	private String color;
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	public Vehiculo() {
	}

	public Vehiculo(int id, String placa, String tipo, String marca, int modelo, String color, String estado) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.estado = estado;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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