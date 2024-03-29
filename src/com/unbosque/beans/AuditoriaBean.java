package com.unbosque.beans;

import com.unbosque.dao.impl.AuditoriaDAOImpl;
import com.unbosque.entity.Auditoria;
import com.unbosque.entity.Empresa;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class AuditoriaBean {
	private Auditoria auditoria;
	private DataModel listaAuditoria;

	public AuditoriaBean() {
		auditoria = new Auditoria();
	}
	
	public String prepararAdicionarAuditoria() {
		return "/admin/auditoria/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarAuditoria() {
		auditoria = (Auditoria) (listaAuditoria.getRowData());
		return "/admin/auditoria/edicion.xhtml?faces-redirect=true";
	}

	public String adicionarAuditoria() {
		AuditoriaDAOImpl dao = new AuditoriaDAOImpl();
		dao.save(auditoria);
		return "/admin/auditoria/consulta.xhtml?faces-redirect=true";
	}

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria= auditoria;
	}

	public DataModel getListarAuditoria() {
		List<Object> lista = new AuditoriaDAOImpl().list();
		listaAuditoria = new ListDataModel(lista);
		return listaAuditoria;
	}
}
