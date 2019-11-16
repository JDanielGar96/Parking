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

@ManagedBean(name = "userBean", eager = true)
@SessionScoped
public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario user;
	private DataModel userList;
	
	public UsuarioBean() {
	}

	public UsuarioBean(Usuario user, DataModel userList) {
		this.user = user;
		this.userList = userList;
	}
	
	public DataModel getUsersList() {
		List<Object> list = new UsuarioDAOImpl().list();
		userList = new ListDataModel(list);
		return (DataModel<Usuario>) userList;
	}

	public String getUserAdditionReady() {
		user = new Usuario();
		user.setActivo("A");
		user.setFechaUltimoPassword(new Date());
		user.setIntentos(0);
		/* Here goes the register user web page in the WebContent File */
		return "/user/register.xhtml?faces-redirect=true";
	}

	public String addUser() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		dao.save(user);
		/*
		 * Here goes the redirection web page after user gets registered in the
		 * WebContent File
		 */
		return "/user/index.xhtml?faces-redirect=true";
	}

	public String getUserUpdateReady() {
		user = (Usuario) (userList.getRowData());
		/*
		 * Here goes the redirection web page after user selects the edit info option in
		 * the WebContent File
		 */
		return "/user/edit.xhtml?faces-redirect=true";
	}

	public String updateUser() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		dao.update(user);
		/*
		 * Here goes the redirection web page after user selects update info option in
		 * the WebContent File
		 */
		return "/user/myAccount.xhtml?faces-redirect=true";
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

	public ActionListener registerActionListener() {
		return new ActionListener() {
			@Override
			public void processAction(ActionEvent event) throws AbortProcessingException {
				displayMessage();
				addUser();
			}
		};
	}

	public void displayMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Inicio de sesión exitoso", "Bienvenido: " + user.getApellidosNombres()));
	}

	public Usuario getUsuario() {
		return user;
	}

	public void setUsuario(Usuario usuario) {
		this.user = usuario;
	}

}
