package com.unbosque.beans;

import com.unbosque.dao.impl.EmpresaDAOImpl;
import com.unbosque.entity.Empresa;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class EmpresaBean {
	private Empresa empresa;
	private DataModel listaEmpresa;
	
	public EmpresaBean() {
		empresa = new Empresa();
	}

	public String prepararAdicionarEmpresa() {
		return "/admin/empresa/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarEmpresa() {
		empresa = (Empresa) (listaEmpresa.getRowData());
		return "/admin/empresa/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarEmpresa() {
		Empresa empresaTemp = (Empresa) (listaEmpresa.getRowData());
		EmpresaDAOImpl dao = new EmpresaDAOImpl();
		empresaTemp.setEstadoEmpresa("I");
		dao.update(empresaTemp);
		// dao.remove(usuarioTemp);
		return "/admin/empresa/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarEmpresa() {
		EmpresaDAOImpl dao = new EmpresaDAOImpl();
		dao.save(empresa);
		return "/admin/empresa/consulta.xhtml?faces-redirect=true";
	}

	public String modificarEmpresa() {
		EmpresaDAOImpl dao = new EmpresaDAOImpl();
		dao.update(empresa);
		return "/admin/empresa/consulta.xhtml?faces-redirect=true";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public DataModel getListarEmpresa() {
		List<Object> lista = new EmpresaDAOImpl().list();
		listaEmpresa = new ListDataModel(lista);
		return listaEmpresa;
	}
}
