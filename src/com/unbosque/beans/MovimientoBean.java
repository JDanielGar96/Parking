package com.unbosque.beans;

import com.unbosque.dao.impl.MovimientoDAOImpl;
import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Parqueadero;
import com.unbosque.entity.Usuario;
import com.unbosque.dao.DaoGeneral;

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
	
	public String crearMovimientoUsuario() {
		this.movimiento = new Movimiento();
		DaoGeneral dao = new MovimientoDAOImpl();
		this.movimiento.setActivo("Activo");
		this.movimiento.setFechaHoraReserva(new Date());
		dao.save(this.movimiento);
		return "/cliente/home.xhtml?faces-redirect=true";
	}
	
	
	
	public String prepararAdicionarMovimiento() {
		movimiento = new Movimiento();
		movimiento.setActivo("A");
		return "/admin/movimiento/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarMovimiento() {
		movimiento = (Movimiento) (listaMovimiento.getRowData());
		return "/admin/movimiento/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarMovimiento() {
		Movimiento movimientoTemp = (Movimiento) (listaMovimiento.getRowData());
		DaoGeneral dao = new MovimientoDAOImpl();
		movimientoTemp.setActivo("I");
		dao.update(movimientoTemp);
		// dao.remove(usuarioTemp);
		return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarMovimiento() {
		DaoGeneral dao = new MovimientoDAOImpl();
		dao.save(movimiento);
		return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
	}

	public String modificarMovimiento() {
		DaoGeneral dao = new MovimientoDAOImpl();
		dao.update(movimiento);
		return "/admin/movimiento/consulta.xhtml?faces-redirect=true";
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public DataModel getListarMovimiento() {
		List<Object> lista = new MovimientoDAOImpl().list();
		listaMovimiento = new ListDataModel(lista);
		return listaMovimiento;
	}
}
