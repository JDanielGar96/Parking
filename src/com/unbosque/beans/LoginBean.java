package com.unbosque.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	


	
	// public String updateUser() {
	// 	UsuarioDAOImpl dao = new UsuarioDAOImpl();
	// 	dao.update(user);
	// 	/*
	// 	 * Here goes the redirection web page after user selects update info option in
	// 	 * the WebContent File
	// 	 */
	// 	return "/index.xhtml?faces-redirect=true";
	// }

	// public ActionListener registerActionListener() {
	// 	return new ActionListener() {
	// 		@Override
	// 		public void processAction(ActionEvent event) throws AbortProcessingException {
	// 			displayMessage();
	// 			registerUser();

	// 		}
	// 	};
	// }

	// public void displayMessage() {
	// 	FacesContext context = FacesContext.getCurrentInstance();
	// 	context.addMessage(null, new FacesMessage("Inicio de sesión exitoso", "Bienvenido: " + user.getApellidosNombres()));
	// }

	// public Usuario getUsuario() {
	// 	return user;
	// }

	// public void setUsuario(Usuario usuario) {
	// 	this.user = usuario;
	// }

}
