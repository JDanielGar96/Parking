package com.unbosque.beans;

import com.unbosque.dao.impl.UserDAOImpl;
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
public class ClienteBean {
	private Usuario usuario;
	
	private double latitud = 4.570868;
	private double longitud = -74.297333;
	private double zoom = 5;
	
	private DataModel listaUsuario;

	public ClienteBean() { }

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
		DaoGeneral dao = new UserDAOImpl();
		usuarioTemp.setActivo("I");
		dao.update(usuarioTemp);
		// dao.remove(usuarioTemp);
		return "/admin/usuario/consulta.xhtml?faces-redirect=true";
	}

	public String adicionarUsuario() {
		DaoGeneral dao = new UserDAOImpl();
		dao.save(usuario);
		return "/admin/usuario/consulta.xhtml?faces-redirect=true";
	}

	public String modificarUsuario() {
		DaoGeneral dao = new UserDAOImpl();
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
		List<Object> lista = new UserDAOImpl().list();
		listaUsuario = new ListDataModel(lista);
		return listaUsuario;
	}

	public double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public void mostrarUbicacion() {
		System.out.println("Longitud " + this.longitud);
		System.out.println("Latitud " + this.latitud);
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
}
