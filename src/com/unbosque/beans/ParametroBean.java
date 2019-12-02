package com.unbosque.beans;

import com.unbosque.dao.impl.ParametroDAOImpl;
import com.unbosque.entity.Parametro;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ParametroBean {
	private Parametro parametro;
	private DataModel listaParametro;
	
	public ParametroBean() {
		parametro = new Parametro();
	}
	
	public String prepararAdicionarParametro() {
		parametro = new Parametro();
		parametro.setEstado("A");
		return "/admin/parametro/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarParametro() {
		parametro = (Parametro) (listaParametro.getRowData());
		return "/admin/parametro/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarParametro() {
		Parametro parametroTemp = (Parametro) (listaParametro.getRowData());
		ParametroDAOImpl dao = new ParametroDAOImpl();
		parametroTemp.setEstado("I");
		dao.update(parametroTemp);
		// dao.remove(usuarioTemp);
		return "/admin/parametro/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarParametro() {
		ParametroDAOImpl dao = new ParametroDAOImpl();
		dao.save(parametro);
		return "/admin/parametro/consulta.xhtml?faces-redirect=true";
	}

	public String modificarParametro() {
		ParametroDAOImpl dao = new ParametroDAOImpl();
		dao.update(parametro);
		return "/admin/parametro/consulta.xhtml?faces-redirect=true";
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public DataModel getListarParametro() {
		List<Object> lista = new ParametroDAOImpl().list();
		listaParametro = new ListDataModel(lista);
		return listaParametro;
	}
}
