package com.unbosque.beans;

import java.util.Date;

//import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.unbosque.entity.Movimiento;
import com.unbosque.dao.DaoGeneral;
import com.unbosque.dao.impl.MovimientoDAOImpl;

@ManagedBean(name = "ownerBean")
@SessionScoped
public class OwnerBean {
	String opcion;
	MovimientoDAOImpl movimientodao;
	Movimiento movimiento;

	public OwnerBean() {
	}

//	@PostConstruct
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
	
	public String ingresoVehiculo(int idreserva) {
		System.out.println("Ingreso Vehículo..." + idreserva);
		movimiento = new Movimiento();
		movimientodao = new MovimientoDAOImpl();
		movimiento = (Movimiento) (movimientodao.get(idreserva));
		movimiento.setFechaHoraLlegada(new Date());
		modificarMovimiento();
		return null;
	}
	
	public String modificarMovimiento() {
		DaoGeneral dao = new MovimientoDAOImpl();
		dao.update(movimiento);
		return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
	}
	
	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	
	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
}
