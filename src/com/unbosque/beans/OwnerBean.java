package com.unbosque.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ownerBean")
@SessionScoped
public class OwnerBean {
	String opcion;

	public OwnerBean() {
	}

	@PostConstruct
	public void init() {
		opcion = "";

	}

	public String direccionar() {
		System.out.println("Redireccionando dueño...");

		if (opcion != null) {

			switch (opcion) {

			case "1":
				return "/owner/parqueadero/edicion.xhtml?faces-redirect=true";
			case "2":
				return "/owner/movimiento/consulta.xhtml?faces-redirect=true";
			case "3":
				return "/owner/reserva/consulta.xhtml?faces-redirect=true";

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Ops.", "Por favor, intenta de nuevo."));
		}
		return null;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

}
