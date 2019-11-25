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

	String opcion;
	private Calendar calendar;
	private String tiempo;
	private String fecha;
	private String horaFecha;

	public AdminBean() {
	}

	@PostConstruct
	public void init() {

		this.fechaHora();
		opcion = "";

	}

	public String direccionar() {
		System.out.println("Redireccionando administrador...");

		if (opcion != null) {

			switch (opcion) {

			case "1":
				return "/admin/auditoria/adicion.xhtml?faces-redirect=true";
			case "2":
				return "/admin/auditoria/consulta.xhtml?faces-redirect=true";
			case "3":
				return "/admin/auditoria/edicion.xhtml?faces-redirect=true";

			case "4":
				return "/admin/empresa/adicion.xhtml?faces-redirect=true";
			case "5":
				return "/admin/empresa/consulta.xhtml?faces-redirect=true";
			case "6":
				return "/admin/empresa/edicion.xhtml?faces-redirect=true";

			case "7":
				return "/admin/movimiento/adicion.xhtml?faces-redirect=true";
			case "8":
				return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
			case "9":
				return "/admin/movimiento/edicion.xhtml?faces-redirect=true";

			case "10":
				return "/admin/parametro/adicion.xhtml?faces-redirect=true";
			case "11":
				return "/admin/parametro/consulta.xhtml?faces-redirect=true";
			case "12":
				return "/admin/parametro/edicion.xhtml?faces-redirect=true";

			case "13":
				return "/admin/parqueadero/adicion.xhtml?faces-redirect=true";
			case "14":
				return "/admin/parqueadero/consulta.xhtml?faces-redirect=true";
			case "15":
				return "/admin/parqueadero/edicion.xhtml?faces-redirect=true";

			case "16":
				return "/admin/reserva/adicion.xhtml?faces-redirect=true";
			case "17":
				return "/admin/reserva/consulta.xhtml?faces-redirect=true";
			case "18":
				return "/admin/reserva/edicion.xhtml?faces-redirect=true";

			case "19":
				return "/admin/tarifa/adicion.xhtml?faces-redirect=true";
			case "20":
				return "/admin/tarifa/consulta.xhtml?faces-redirect=true";
			case "21":
				return "/admin/tarifa/edicion.xhtml?faces-redirect=true";

			case "22":
				return "/admin/usuario/adicion.xhtml?faces-redirect=true";
			case "23":
				return "/admin/usuario/consulta.xhtml?faces-redirect=true";
			case "24":
				return "/admin/usuario/edicion.xhtml?faces-redirect=true";

			case "25":
				return "/admin/vehiculo/adicion.xhtml?faces-redirect=true";
			case "26":
				return "/admin/vehiculo/consulta.xhtml?faces-redirect=true";
			case "27":
				return "/admin/vehiculo/edicion.xhtml?faces-redirect=true";
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
		horaFecha = tiempo + " " + fecha;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
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
