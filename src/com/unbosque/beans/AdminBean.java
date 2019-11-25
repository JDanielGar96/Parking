package com.unbosque.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminBean {

	String[] opciones;
	private Calendar calendar;
	private String tiempo;
	private String fecha;
	private String horaFecha;

	public AdminBean() {
	}

	@PostConstruct
	public void init() {

		this.fechaHora();

		// lista de opciones utilizando Arrays
		opciones = new String[5];
		opciones[0] = "1. Auditoria - adicion";
		opciones[1] = "2. Auditoria - consulta";
		opciones[2] = "3. Auditoria - edicion";

	}

	public String direccionar() {
		System.out.println("Redireccionando administrador...");

		if (opciones != null) {
			for (int i = 0; i <= opciones.length; i++) {

				switch (opciones[i]) {

				case "0":
					return "/admin/auditoria/adicion.xhtml?faces-redirect=true";
				case "1":
					return "/admin/auditoria/consulta.xhtml?faces-redirect=true";
				case "3":
					return "/admin/auditoria/edicion.xhtml?faces-redirect=true";

//				case "EmpresaUno":
//					return "/admin/empresa/adicion.xhtml?faces-redirect=true";
//				case "EmpresaDos":
//					return "/admin/empresa/consulta.xhtml?faces-redirect=true";
//				case "EmpresaTres":
//					return "/admin/empresa/edicion.xhtml?faces-redirect=true";
//
//				case "MovimientoUno":
//					return "/admin/movimiento/adicion.xhtml?faces-redirect=true";
//				case "MovimientoDos":
//					return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
//				case "MovimientoTres":
//					return "/admin/movimiento/edicion.xhtml?faces-redirect=true";
//
//				case "ParametroUno":
//					return "/admin/parametro/adicion.xhtml?faces-redirect=true";
//				case "ParametroDos":
//					return "/admin/parametro/consulta.xhtml?faces-redirect=true";
//				case "ParametroTres":
//					return "/admin/parametro/edicion.xhtml?faces-redirect=true";
//
//				case "ParqueaderoUno":
//					return "/admin/parqueadero/adicion.xhtml?faces-redirect=true";
//				case "ParqueaderoDos":
//					return "/admin/parqueadero/consulta.xhtml?faces-redirect=true";
//				case "ParqueaderoTres":
//					return "/admin/parqueadero/edicion.xhtml?faces-redirect=true";
//
//				case "ReservaUno":
//					return "/admin/reserva/adicion.xhtml?faces-redirect=true";
//				case "ReservaDos":
//					return "/admin/reserva/consulta.xhtml?faces-redirect=true";
//				case "ReservaTres":
//					return "/admin/reserva/edicion.xhtml?faces-redirect=true";
//
//				case "TarifaUno":
//					return "/admin/tarifa/adicion.xhtml?faces-redirect=true";
//				case "TarifaDos":
//					return "/admin/tarifa/consulta.xhtml?faces-redirect=true";
//				case "TarifaTres":
//					return "/admin/tarifa/edicion.xhtml?faces-redirect=true";
//
//				case "UsuarioUno":
//					return "/admin/usuario/adicion.xhtml?faces-redirect=true";
//				case "UsuarioDos":
//					return "/admin/usuario/consulta.xhtml?faces-redirect=true";
//				case "UsuarioTres":
//					return "/admin/usuario/edicion.xhtml?faces-redirect=true";
//
//				case "VehiculoUno":
//					return "/admin/vehiculo/adicion.xhtml?faces-redirect=true";
//				case "VehiculoDos":
//					return "/admin/vehiculo/consulta.xhtml?faces-redirect=true";
//				case "VehiculoTres":
//					return "/admin/vehiculo/edicion.xhtml?faces-redirect=true";
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Ops.", "Por favor, intenta de nuevo."));
		}
		return null;
	}

	/**
	 * Devuelve la fecha y hora actual
	 * 
	 */
	public void fechaHora() {
		calendar = new GregorianCalendar();
		tiempo = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
				+ calendar.get(Calendar.SECOND);
		fecha = calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ calendar.get(Calendar.YEAR);
		horaFecha = tiempo + fecha;
	}

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraFecha() {
		return horaFecha;
	}

	public void setHoraFecha(String horaFecha) {
		this.horaFecha = horaFecha;
	}

}
