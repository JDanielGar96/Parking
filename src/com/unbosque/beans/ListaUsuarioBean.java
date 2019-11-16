package com.unbosque.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;

@ManagedBean(name = "userListBean", eager = true)
@SessionScoped
public class ListaUsuarioBean implements Serializable {
	
	private Usuario user; 
	private DataModel userList;
	
	public DataModel getUsersList() {
		List<Object> list = new UsuarioDAOImpl().list();
		userList = new ListDataModel(list);
		return (DataModel<Usuario>) userList;
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

}
