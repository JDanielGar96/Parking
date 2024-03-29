package com.unbosque.beans;

import com.unbosque.dao.impl.ParqueaderoDAOImpl;
import com.unbosque.entity.Empresa;
import com.unbosque.entity.Parqueadero;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;

@ManagedBean
@SessionScoped
public class ParqueaderoBean {
	private Parqueadero parqueadero;
	private DataModel listaParqueadero;
	private MapModel modeloMapa;
	
	public ParqueaderoBean() {
		parqueadero = new Parqueadero();
	}
	
	public String prepararAdicionarParqueadero() {
		parqueadero = new Parqueadero();
		parqueadero.setEstado("A");
		return "/admin/parqueadero/adicion.xhtml?faces-redirect=true";
	}
	
	public String prepararModificarParqueadero() {
		parqueadero = (Parqueadero) (listaParqueadero.getRowData());
		return "/admin/parqueadero/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarParqueadero() {
		Parqueadero parqueaderoTemp = (Parqueadero) (listaParqueadero.getRowData());
		ParqueaderoDAOImpl dao = new ParqueaderoDAOImpl();
		parqueaderoTemp.setEstado("I");
		dao.update(parqueaderoTemp);
		// dao.remove(usuarioTemp);
		return "/admin/parqueadero/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarParqueadero() {
		ParqueaderoDAOImpl dao = new ParqueaderoDAOImpl();
		dao.save(parqueadero);
		return "/admin/parqueadero/consulta.xhtml?faces-redirect=true";
	}

	public String modificarParqueadero() {
		ParqueaderoDAOImpl dao = new ParqueaderoDAOImpl();
		dao.update(parqueadero);
		return "/admin/parqueadero/consulta.xhtml?faces-redirect=true";
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public DataModel getListarParqueadero() {
		List<Object> lista = new ParqueaderoDAOImpl().list();
		listaParqueadero = new ListDataModel(lista);
		return listaParqueadero;
	}
}
