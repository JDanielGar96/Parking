package com.unbosque.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {
	/*
	 * Communicate with view to validate login of user
	 */
	
	private static final long serialVersionUID = 1L;
	
	private Usuario user;
	
	public LoginBean() { 
		/*
		 * Create new user to validate parameters in the database
		 */
		this.user = new Usuario();
	}

	public void loginUser() {
		UsuarioDAOImpl implementation = new UsuarioDAOImpl();
	}


	public Usuario getUser() {
		return this.user;
	}
}
