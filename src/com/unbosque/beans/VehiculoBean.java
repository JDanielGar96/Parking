package com.unbosque.beans;

import com.unbosque.dao.impl.VehiculoDAOImpl;
import com.unbosque.entity.Empresa;
import com.unbosque.entity.Vehiculo;
import com.unbosque.dao.DaoGeneral;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class VehiculoBean {
	private Vehiculo vehiculo;
	private DataModel listaVehiculo;
	
	public VehiculoBean() {
		vehiculo = new Vehiculo();
	}
	
	public String prepararAdicionarVehiculo() {
		vehiculo.setEstado("A");
		return "/admin/vehiculo/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarVehiculo() {
		vehiculo = (Vehiculo) (listaVehiculo.getRowData());
		return "/admin/vehiculo/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarVehiculo() {
		Vehiculo vehiculoTemp = (Vehiculo) (listaVehiculo.getRowData());
		VehiculoDAOImpl dao = new VehiculoDAOImpl();
		vehiculoTemp.setEstado("I");
		dao.update(vehiculoTemp);
		// dao.remove(usuarioTemp);
		return "/admin/vehiculo/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarVehiculo() {
		VehiculoDAOImpl dao = new VehiculoDAOImpl();
		dao.save(vehiculo);
		return "/admin/vehiculo/consulta.xhtml?faces-redirect=true";
	}

	public String modificarVehiculo() {
		VehiculoDAOImpl dao = new VehiculoDAOImpl();
		dao.update(vehiculo);
		return "/admin/vehiculo/consulta.xhtml?faces-redirect=true";
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public DataModel getListarVehiculo() {
		List<Object> lista = new VehiculoDAOImpl().list();
		listaVehiculo = new ListDataModel(lista);
		return listaVehiculo;
	}
}
