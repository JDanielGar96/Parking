package com.unbosque.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.component.chart.ChartRenderer;

import com.unbosque.dao.impl.MovimientoDAOImpl;
import com.unbosque.dao.impl.UsuarioDAOImpl;
import com.unbosque.entity.Movimiento;
import com.unbosque.entity.Usuario;

@ManagedBean(name = "graficaBean")
@ApplicationScoped
public class GraficaBean {

	private BarChartModel grafModeloBarMov;
	private BarChartModel grafModeloBarUsu;
	private ChartSeries serieCart;
	private BarChartSeries serieBar;
	private List<Movimiento> mLista;
	private List<Usuario> uLista;
	private MovimientoDAOImpl movimiento;
	private UsuarioDAOImpl usuario;

	public GraficaBean() {
		System.out.println("Holaaaaa");
		grafModeloBarMov = new BarChartModel();
		grafModeloBarUsu = new BarChartModel();
		inicializarSerieCart();
		inicializarSerieBar();
		inicializarModeloCartDeMovimiento();
		inicializarModeloBarDeUsuario();
	}

	@SuppressWarnings("unchecked")
	private void inicializarSerieCart() {
		serieCart = new ChartSeries();
		movimiento = new MovimientoDAOImpl();
		mLista = (List<Movimiento>) (Object) movimiento.list();
		Map<Object, Number> mapaCart = new HashMap<>();
		for (Movimiento m : mLista) {
			mapaCart.put(m.getLoginCliente(), m.getValorCobro());
			serieCart.setData(mapaCart);
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
		grafModeloBarMov.addSeries(serieCart);
	}

	@SuppressWarnings("unchecked")
	private void inicializarSerieBar() {
		serieBar = new BarChartSeries();
		usuario = new UsuarioDAOImpl();
		uLista = (List<Usuario>) (Object) usuario.list();
		Map<Object, Number> mapaBar = new HashMap<>();

		for (Usuario u : uLista) {
			mapaBar.put(u.getApellidosNombres(), u.getIntentos());
			serieBar.setData(mapaBar);
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
		grafModeloBarUsu.addSeries(serieBar);
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

	
	
}
