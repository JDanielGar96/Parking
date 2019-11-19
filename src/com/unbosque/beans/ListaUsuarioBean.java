package com.unbosque.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;

@ManagedBean(name = "userListBean")
@SessionScoped
public class ListaUsuarioBean {

	private Usuario user;
	@SuppressWarnings("rawtypes")
	private DataModel userList;

	public ListaUsuarioBean() {
		this.user = new Usuario();
	}

	public String getUserUpdateReady() {
		user = (Usuario) (userList.getRowData());
		/*
		 * Here goes the redirection web page after user selects the edit info option in
		 * the WebContent File
		 */
		return "/user/edit.xhtml?faces-redirect=true";
	}

	public String deleteUser() {
		Usuario tempUser = (Usuario) (userList.getRowData());
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		tempUser.setActivo("I");
		dao.update(tempUser);
		// dao.remove(usuarioTemp);
		/*
		 * Here goes the redirection web page after user selects delete option in the
		 * WebContent File
		 */
		return "/user/index.xhtml?faces-redirect=true";
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataModel getUsersList() {
		List<Object> list = new UsuarioDAOImpl().list();
		userList = new ListDataModel(list);
		return userList;
	}

}
