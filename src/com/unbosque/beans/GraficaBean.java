package com.unbosque.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.unbosque.dao.impl.ReservaDAOImpl;
import com.unbosque.dao.impl.UsuarioDAOImpl;
import com.unbosque.entity.Reserva;
import com.unbosque.entity.Usuario;

@ManagedBean(name = "grafBean")
@RequestScoped
public class GraficaBean {

	private CartesianChartModel grafModeloCart;
	private BarChartModel grafModeloBar;
	private ChartSeries aparejar;
	private List<Reserva> rLista;
	private List<Usuario> uLista;
	private ReservaDAOImpl reserva;
	private UsuarioDAOImpl usuario;
	private DataModel listaReserva;
	private DataModel listaUsuario;
	private HashMap<Object, Number> rigMap;
	private Axis xAxis;
	private Axis yAxis;

	@PostConstruct
	public void init() {
		getListarReserva();
		getListarUsuario();
		crearModeloCartDeReserva();
		crearModeloBarDeUsuario();
	}

	public DataModel getListarReserva() {
		List<Object> listaR = new ReservaDAOImpl().list();
		listaReserva = new ListDataModel(listaR);
		return listaReserva;
	}

	public DataModel getListarUsuario() {
		List<Object> listaU = new UsuarioDAOImpl().list();
		listaReserva = new ListDataModel(listaU);
		return listaUsuario;
	}

	public CartesianChartModel crearModeloCartDeReserva() {
		aparejar = new ChartSeries();
		rLista = (List<Reserva>) this.getListarReserva();
//		rList = (List<Reserva>) (Object) reserva.list();
		Map<Object, Number> rigMap = new HashMap<>();

		for (Reserva r : rLista) {
			rigMap.put(r.getTipoServicio().toString(), r.getFechaHoraReserva().getMinutes());
			grafModeloCart = new CartesianChartModel();
			aparejar.setData(rigMap);
			grafModeloCart.addSeries(aparejar);

		}
		return grafModeloCart;
	}

	public BarChartModel crearModeloBarDeUsuario() {

		aparejar = new ChartSeries();
		uLista = (List<Usuario>) this.getListarReserva();
//		List<Usuario> uLista = rigFacade.findAll(); Funciona con Spring usando el método findAll();
		Map<Object, Number> MapaBar = new HashMap<>();

		for (Usuario u : uLista) {
			MapaBar.put(u.getApellidosNombres(), u.getIntentos());

			grafModeloBar = new BarChartModel();

			aparejar.setData(MapaBar);
			grafModeloBar.addSeries(aparejar);
			grafModeloBar.setSeriesColors("FF0000");
			grafModeloBar.setShowPointLabels(true);
			Axis xAxis = grafModeloBar.getAxis(AxisType.X);
		}
		return grafModeloBar;
	}

	public CartesianChartModel getGrafModeloCart() {
		return grafModeloCart;
	}

	public void setGrafModeloCart(CartesianChartModel grafModeloCart) {
		this.grafModeloCart = grafModeloCart;
	}

	public BarChartModel getGrafModeloBar() {
		return grafModeloBar;
	}

	public void setGrafModeloBar(BarChartModel grafModeloBar) {
		this.grafModeloBar = grafModeloBar;
	}

	public ChartSeries getAparejar() {
		return aparejar;
	}

	public void setAparejar(ChartSeries aparejar) {
		this.aparejar = aparejar;
	}

	public List<Reserva> getrLista() {
		return rLista;
	}

	public void setrLista(List<Reserva> rLista) {
		this.rLista = rLista;
	}

	public List<Usuario> getuLista() {
		return uLista;
	}

	public void setuLista(List<Usuario> uLista) {
		this.uLista = uLista;
	}

	public ReservaDAOImpl getReserva() {
		return reserva;
	}

	public void setReserva(ReservaDAOImpl reserva) {
		this.reserva = reserva;
	}

	public UsuarioDAOImpl getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDAOImpl usuario) {
		this.usuario = usuario;
	}

	public DataModel getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(DataModel listaReserva) {
		this.listaReserva = listaReserva;
	}

	public DataModel getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(DataModel listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public HashMap<Object, Number> getRigMap() {
		return rigMap;
	}

	public void setRigMap(HashMap<Object, Number> rigMap) {
		this.rigMap = rigMap;
	}

	public Axis getxAxis() {
		return xAxis;
	}

	public void setxAxis(Axis xAxis) {
		this.xAxis = xAxis;
	}

	public Axis getyAxis() {
		return yAxis;
	}

	public void setyAxis(Axis yAxis) {
		this.yAxis = yAxis;
	}

}
