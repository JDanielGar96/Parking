package com.unbosque.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;


@ManagedBean
@SessionScoped
public class RegistrationBean {
	/*
	 * Communicate with view to validate and register user
	 */
	
	private static final long serialVersionUID = 1L;
	
	private Usuario user;
	
	public RegistrationBean() {
		/*
		 * Create new user object and push it into DB if fields are valid
		 */
		this.user = new Usuario();
	}
	
	public String createUser() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();		
		user.setActivo("A");
		user.setFechaUltimoPassword(new Date());
		user.setIntentos(0);
		dao.save(user);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public Usuario getUser() {
		return this.user;
	}
}
