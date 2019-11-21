package com.unbosque.beans;

import com.unbosque.dao.impl.ParqueaderoDAOImpl;
import com.unbosque.entity.Parqueadero;
import com.unbosque.dao.Dao;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ParqueaderoBean {
	private Parqueadero parqueadero;
	private DataModel listaParqueadero;

	public String prepararAdicionarParqueadero() {
		parqueadero = new Parqueadero();
		parqueadero.setEstado("A");
		return "/parqueadero/registroNuevo.xhtml?faces-redirect=true";
	}

	public String prepararModificarParqueadero() {
		parqueadero = (Parqueadero) (listaParqueadero.getRowData());
		return "/parqueadero/modificarRegistro.xhtml?faces-redirect=true";
	}

	public String eliminarParqueadero() {
		Parqueadero parqueaderoTemp = (Parqueadero) (listaParqueadero.getRowData());
		Dao dao = new ParqueaderoDAOImpl();
		parqueaderoTemp.setEstado("I");
		dao.update(parqueaderoTemp);
		// dao.remove(usuarioTemp);
		return "/parqueadero/nuevaConsultaRich.xhtml?faces-redirect=true";
	}

	public String adicionarParqueadero() {
		Dao dao = new ParqueaderoDAOImpl();
		dao.save(parqueadero);
		return "/parqueadero/nuevaConsultaRich.xhtml?faces-redirect=true";
	}

	public String modificarParqueadero() {
		Dao dao = new ParqueaderoDAOImpl();
		dao.update(parqueadero);
		return "/parqueadero/nuevaConsultaRich.xhtml?faces-redirect=true";
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public DataModel getListarParqueadero() {
		System.out.println("Prueba");
		List<Object> lista = new ParqueaderoDAOImpl().list();
		listaParqueadero = new ListDataModel(lista);
		return listaParqueadero;
	}
}