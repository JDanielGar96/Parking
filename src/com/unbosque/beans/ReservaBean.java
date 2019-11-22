package com.unbosque.beans;

import com.unbosque.dao.impl.ReservaDAOImpl;
import com.unbosque.entity.Reserva;
import com.unbosque.dao.DaoGeneral;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ReservaBean {
	private Reserva reserva;
	private DataModel listaReserva;

	public String prepararAdicionarReserva() {
		reserva = new Reserva();
		reserva.setActivo("A");
		return "/admin/reserva/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarReserva() {
		reserva = (Reserva) (listaReserva.getRowData());
		return "/admin/reserva/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarReserva() {
		Reserva reservaTemp = (Reserva) (listaReserva.getRowData());
		DaoGeneral dao = new ReservaDAOImpl();
		reservaTemp.setActivo("I");
		dao.update(reservaTemp);
		// dao.remove(usuarioTemp);
		return "/admin/reserva/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarReserva() {
		DaoGeneral dao = new ReservaDAOImpl();
		dao.save(reserva);
		return "/admin/reserva/consulta.xhtml?faces-redirect=true";
	}

	public String modificarReserva() {
		DaoGeneral dao = new ReservaDAOImpl();
		dao.update(reserva);
		return "/admin/reserva/consulta.xhtml?faces-redirect=true";
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public DataModel getListarReserva() {
		List<Object> lista = new ReservaDAOImpl().list();
		listaReserva = new ListDataModel(lista);
		return listaReserva;
	}
}
