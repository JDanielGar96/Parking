package com.unbosque.beans;

import com.unbosque.dao.impl.MovimientoDAOImpl;
import com.unbosque.dao.impl.ParqueaderoDAOImpl;
import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Parqueadero;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class MovimientoBean {
	private Movimiento movimiento;
	private Parqueadero parqueadero;
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
	
	public String ingresoVehiculo() {		
		Movimiento movimientoTemp = (Movimiento) (listaMovimiento.getRowData());
		MovimientoDAOImpl dao = new MovimientoDAOImpl();
		if(movimientoTemp.getFechaHoraLlegada()== null) {
			movimientoTemp.setFechaHoraLlegada(new Date());
			movimientoTemp.setActivo("E");
			dao.update(movimientoTemp);
		}
		return null;
	}
	
	public String salidaVehiculo() {		
		Movimiento movimientoTemp = (Movimiento) (listaMovimiento.getRowData());
		MovimientoDAOImpl dao = new MovimientoDAOImpl();
		if(movimientoTemp.getFechaHoraSalida()== null) {
			movimientoTemp.setFechaHoraSalida(new Date());
			movimientoTemp.setActivo("I");
			long sal=movimientoTemp.getFechaHoraSalida().getTime();
			long res=movimientoTemp.getFechaHoraReserva().getTime();
			long resta= (sal-res);
			int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(resta);
			movimientoTemp.setValorCobro(minutes*60);
			movimientoTemp.setTiempo(minutes);
			dao.update(movimientoTemp);
			System.out.println("Hola mundo PPPPPP");
			
			ParqueaderoDAOImpl implementacionParq = new ParqueaderoDAOImpl();
			Object parqueaderoObj = new ParqueaderoDAOImpl().get(movimientoTemp.getParqueaderoId());
			parqueadero=(Parqueadero) parqueaderoObj;
			parqueadero.sumarDisponibilidad();
			implementacionParq.updateAvaliability(parqueadero.getId(), parqueadero.getDisponibilidad());
		}
		return null;
	}
	
	public Movimiento getMovimiento(int id) {
		MovimientoDAOImpl dao = new MovimientoDAOImpl();
		Movimiento movimientoTemp = (Movimiento) dao.get(id);
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
}
