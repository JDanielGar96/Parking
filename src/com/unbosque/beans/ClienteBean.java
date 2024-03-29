package com.unbosque.beans;

import com.unbosque.entity.Usuario;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Parqueadero;
import com.unbosque.dao.impl.MovimientoDAOImpl;
import com.unbosque.dao.impl.ParqueaderoDAOImpl;
import com.unbosque.util.Email;
import com.unbosque.util.Util;

@ManagedBean
@SessionScoped
public class ClienteBean {
	private Usuario usuario;
	
	private double latitud = 4.570868;
	private double longitud = -74.297333;
	private double zoom = 5;
	
	private Parqueadero parqueadero;
	private Movimiento movimiento;

	
	private DataModel<Parqueadero> listaParqueadero;
	private DataModel<Movimiento> listaMovimiento;

	public ClienteBean() { }
	
	public String iniciarMovimiento() {
		parqueadero = (Parqueadero) (listaParqueadero.getRowData());
		movimiento = new Movimiento();
		return "/client/movimiento/crear.xhtml?faces-redirect=true";
	}
	
	public String iniciarMovimientoMapa(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
		System.out.println(this.parqueadero.getCorreo());
		movimiento = new Movimiento();
		return "/client/movimiento/crear.xhtml?faces-redirect=true";
	}
	
	public String crearMovimiento() {
		MovimientoDAOImpl implementacionMov = new MovimientoDAOImpl();
		ParqueaderoDAOImpl implementacionParq = new ParqueaderoDAOImpl();
		
		parqueadero.restarDisponibilidad();
		
		int disponibilidad = parqueadero.getDisponibilidad();
		int idParqueadero = parqueadero.getId();
	
        HttpSession session = Util.getSession();
        
        String login = (String) session.getAttribute("userName");
		
        Date date = new Date();
		
		movimiento.setLoginClient(login);
		movimiento.setTiempo(0);
		movimiento.setParqueaderoId(parqueadero.getId());
		movimiento.setFechaHoraReserva(date);
		movimiento.setActivo("A");
		
		implementacionMov.save(movimiento);
		
		implementacionParq.updateAvaliability(idParqueadero, disponibilidad);
		
		return "/client/home.xhtml?faces-redirect=true";
	}
	
	public String nombreParqueadero(int id) {
		Object parqueaderoObj = new ParqueaderoDAOImpl().get(id);
		return ((Parqueadero) parqueaderoObj).getNombreParqueadero();
		
	}
	
	public DataModel getListaParqueaderos() {
		List<Object> lista = new ParqueaderoDAOImpl().listAvaliables();
		listaParqueadero = new ListDataModel(lista);
		return listaParqueadero;
	}
	
	public DataModel getListaMovimientos() {
		HttpSession session = Util.getSession();
        String login = (String) session.getAttribute("userName");
		List<Object> movimientos = new MovimientoDAOImpl().listByClient(login);
		listaMovimiento = new ListDataModel(movimientos);
		return listaMovimiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario= usuario;
	}

	public double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public void mostrarUbicacion() {
		System.out.println("Longitud " + this.longitud);
		System.out.println("Latitud " + this.latitud);
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	
	public Parqueadero getParqueadero() {
		return this.parqueadero;
	}
	
	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	
	public Movimiento getMovimiento() {
		return movimiento;
	}
	
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
}
