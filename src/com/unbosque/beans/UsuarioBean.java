package com.unbosque.beans;

import com.unbosque.dao.impl.UsuarioDAOImpl;
import com.unbosque.entity.Usuario;
import com.unbosque.dao.DaoGeneral;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private Usuario usuario;
	private DataModel listaUsuario;

	public String prepararAdicionarUsuario() {
		usuario = new Usuario();
		usuario.setActivo("A");
		return "/admin/usuario/adicion.xhtml?faces-redirect=true";
	}

	public String prepararModificarUsuario() {
		usuario = (Usuario) (listaUsuario.getRowData());
		return "/admin/usuario/edicion.xhtml?faces-redirect=true";
	}

	public String eliminarUsuario() {
		Usuario usuarioTemp = (Usuario) (listaUsuario.getRowData());
		DaoGeneral dao = new UsuarioDAOImpl();
		usuarioTemp.setActivo("I");
		dao.update(usuarioTemp);
		// dao.remove(usuarioTemp);
		return "/admin/usuario/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarUsuario() {
		DaoGeneral dao = new UsuarioDAOImpl();
		dao.save(usuario);
		return "/admin/usuario/consulta.xhtml?faces-redirect=true";
	}

	public String modificarUsuario() {
		DaoGeneral dao = new UsuarioDAOImpl();
		dao.update(usuario);
		return "/admin/usuario/consulta.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario= usuario;
	}

	public DataModel getListarUsuario() {
		List<Object> lista = new UsuarioDAOImpl().list();
		listaUsuario = new ListDataModel(lista);
		return listaUsuario;
	}
}
