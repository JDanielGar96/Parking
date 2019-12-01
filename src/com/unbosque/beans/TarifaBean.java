package com.unbosque.beans;

import com.unbosque.dao.impl.TarifaDAOImpl;
import com.unbosque.entity.Tarifa;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class TarifaBean {
	private Tarifa tarifa;
	private DataModel listaTarifa;
	
	public TarifaBean() {
		tarifa = new Tarifa();
	}
	
	public String prepararAdicionarTarifa() {
		tarifa = new Tarifa();
		tarifa.setEstado("A");
		return "/admin/tarifa/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarTarifa() {
		tarifa = (Tarifa) (listaTarifa.getRowData());
		return "/admin/tarifa/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarTarifa() {
		Tarifa tarifaTemp = (Tarifa) (listaTarifa.getRowData());
		TarifaDAOImpl dao = new TarifaDAOImpl();
		tarifaTemp.setEstado("I");
		dao.update(tarifaTemp);
		// dao.remove(usuarioTemp);
		return "/admin/tarifa/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarTarifa() {
		TarifaDAOImpl dao = new TarifaDAOImpl();
		dao.save(tarifa);
		return "/admin/tarifa/consulta.xhtml?faces-redirect=true";
	}

	public String modificarTarifa() {
		TarifaDAOImpl dao = new TarifaDAOImpl();
		dao.update(tarifa);
		return "/admin/tarifa/consulta.xhtml?faces-redirect=true";
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public DataModel getListarTarifa() {
		List<Object> lista = new TarifaDAOImpl().list();
		listaTarifa = new ListDataModel(lista);
		return listaTarifa;
	}
}
