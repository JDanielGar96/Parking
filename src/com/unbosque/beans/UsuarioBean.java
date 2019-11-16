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

@ManagedBean(name = "userBean")
@SessionScoped
public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario user;
	
	public UsuarioBean() {
		this.user = new Usuario();
	}

	public UsuarioBean(Usuario user) {
		this.user = user;
	}
	
	public String registerUser() {
		System.out.println("Chegei");
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		user.setActivo("A");
		user.setFechaUltimoPassword(new Date());
		user.setIntentos(0);
		dao.save(user);
		System.out.println("Salvado");
		return "/index.xhtml?faces-redirect=true";
	}

	public String getUserAdditionReady() {
		user = new Usuario();
		user.setActivo("A");
		user.setFechaUltimoPassword(new Date());
		user.setIntentos(0);
		/* Here goes the register user web page in the WebContent File */
		return "/user/register.xhtml?faces-redirect=true";
	}



	public String updateUser() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		dao.update(user);
		/*
		 * Here goes the redirection web page after user selects update info option in
		 * the WebContent File
		 */
		return "/index.xhtml?faces-redirect=true";
	}

	public ActionListener registerActionListener() {
		return new ActionListener() {
			@Override
			public void processAction(ActionEvent event) throws AbortProcessingException {
				displayMessage();
				registerUser();

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
