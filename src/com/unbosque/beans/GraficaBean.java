package com.unbosque.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import com.unbosque.dao.impl.MovimientoDAOImpl;
import com.unbosque.dao.impl.UsuarioDAOImpl;
import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Usuario;

@ManagedBean(name = "graficaBean")
@RequestScoped
public class GraficaBean {

	private BarChartModel grafModeloBarMov;
	private BarChartModel grafModeloBarUsu;
	private ChartSeries serieBarMovimientos;
	private BarChartSeries serieBarUsuarios;
	private List <Movimiento>mLista;
	private List <Usuario>uLista;
	private MovimientoDAOImpl movimiento;
	private UsuarioDAOImpl usuario;

	public GraficaBean() {
		System.out.println("Holaaaaa");
		grafModeloBarMov = new BarChartModel();
		grafModeloBarUsu = new BarChartModel();
		inicializarSerieBarMov();
		inicializarSerieBarUsu();
		inicializarModeloCartDeMovimiento();
		inicializarModeloBarDeUsuario();
	}

	@SuppressWarnings("unchecked")
	private void inicializarSerieBarMov() {
		serieBarMovimientos = new ChartSeries();
		movimiento = new MovimientoDAOImpl();
		mLista = (List<Movimiento>) (Object) movimiento.list();
		System.out.println(mLista);
		Map<Object, Number> mapaCart = new HashMap<>();
		for (Movimiento m : mLista) {
			mapaCart.put(m.getLoginCliente(), m.getValorCobro());
			serieBarMovimientos.setData(mapaCart);
		}
	}

	private void setAxisCartInfo() {
		grafModeloBarMov.setTitle("Movimientos (Clientes vs Cobros)");
		grafModeloBarMov.setLegendPosition("e");
		Axis xAxis = grafModeloBarMov.getAxis(AxisType.X);
		xAxis.setLabel("Valor cobrado");
	}

	private void inicializarModeloCartDeMovimiento() {
		grafModeloBarMov= new BarChartModel();
		setAxisCartInfo();
		grafModeloBarMov.addSeries(serieBarMovimientos);
	}

	@SuppressWarnings("unchecked")
	private void inicializarSerieBarUsu() {
		serieBarUsuarios = new BarChartSeries();
		usuario = new UsuarioDAOImpl();
		uLista = (List<Usuario>) (Object) usuario.list();
		Map<Object, Number> mapaBar = new HashMap<>();

		for (Usuario u : uLista) {
			mapaBar.put(u.getApellidosNombres(), u.getIntentos());
			serieBarUsuarios.setData(mapaBar);
		}
	}

	private void setAxisBarInfo() {
		grafModeloBarUsu.setTitle("Usuarios (Nombres vs Intentos)");
		grafModeloBarUsu.setLegendPosition("e");
		Axis xAxis = grafModeloBarUsu.getAxis(AxisType.X);
		xAxis.setLabel("Intentos");
	}

	private void inicializarModeloBarDeUsuario() {
		grafModeloBarUsu = new BarChartModel();
		setAxisBarInfo();
		grafModeloBarUsu.addSeries(serieBarUsuarios);
		grafModeloBarUsu.setSeriesColors("FF0000");
		grafModeloBarUsu.setShowPointLabels(true);
	}
	
	public BarChartModel getGrafModeloBarMov() {
		return grafModeloBarMov;
	}

	public void setGrafModeloBarMov(BarChartModel grafModeloBarMov) {
		this.grafModeloBarMov = grafModeloBarMov;
	}

	public BarChartModel getGrafModeloBarUsu() {
		return grafModeloBarUsu;
	}

	public void setGrafModeloBarUsu(BarChartModel grafModeloBarUsu) {
		this.grafModeloBarUsu = grafModeloBarUsu;
	}

	public ChartSeries getSerieBarMovimientos() {
		return serieBarMovimientos;
	}

	public void setSerieBarMovimientos(ChartSeries serieBarMovimientos) {
		this.serieBarMovimientos = serieBarMovimientos;
	}

	public BarChartSeries getSerieBarUsuarios() {
		return serieBarUsuarios;
	}

	public void setSerieBarUsuarios(BarChartSeries serieBarUsuarios) {
		this.serieBarUsuarios = serieBarUsuarios;
	}

	public List<Movimiento> getmLista() {
		return mLista;
	}

	public void setmLista(List<Movimiento> mLista) {
		this.mLista = mLista;
	}

	public List<Usuario> getuLista() {
		return uLista;
	}

	public void setuLista(List<Usuario> uLista) {
		this.uLista = uLista;
	}

	public MovimientoDAOImpl getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(MovimientoDAOImpl movimiento) {
		this.movimiento = movimiento;
	}

	public UsuarioDAOImpl getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDAOImpl usuario) {
		this.usuario = usuario;
	}
	
	
	
}
