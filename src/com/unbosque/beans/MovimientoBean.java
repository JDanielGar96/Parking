package com.unbosque.beans;

import com.unbosque.dao.impl.MovimientoDAOImpl;
import com.unbosque.entity.Movimiento;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class MovimientoBean {
	private Movimiento movimiento;
	private DataModel listaMovimiento;
	
	public MovimientoBean() {
		movimiento = new Movimiento();
	}
	
	public String crearMovimientoUsuario() {
		MovimientoDAOImpl dao = new MovimientoDAOImpl();
		this.movimiento.setActivo("Activo");
		this.movimiento.setFechaHoraReserva(new Date());
		dao.save(this.movimiento);
		return "/cliente/home.xhtml?faces-redirect=true";
	}
	
	public String prepararAdicionarMovimiento() {
		this.movimiento = new Movimiento();
		movimiento.setActivo("A");
		return "/admin/movimiento/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarMovimiento() {
		movimiento = (Movimiento) (listaMovimiento.getRowData());
		return "/admin/movimiento/edicion.xhtml?faces-redirect=true";
	}

	public String adicionarMovimiento() {
		MovimientoDAOImpl dao = new MovimientoDAOImpl();
		dao.save(movimiento);
		return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
	}

	public String modificarMovimiento() {
		MovimientoDAOImpl dao = new MovimientoDAOImpl();
		dao.update(movimiento);
		return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
	}

	public DataModel getListarMovimiento() {
		List<Object> lista = new MovimientoDAOImpl().list();
		listaMovimiento = new ListDataModel(lista);
		return listaMovimiento;
	}
	
//	ERM
	
	public Movimiento getMovimiento(int id) {
		MovimientoDAOImpl dao = new MovimientoDAOImpl();
		Movimiento movimientoTemp = (Movimiento) dao.get(id);
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
}
