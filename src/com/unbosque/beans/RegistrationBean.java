package com.unbosque.beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.unbosque.util.Encriptacion;
import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;
import java.util.concurrent.TimeUnit;


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
		Encriptacion enc = new Encriptacion();
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		user.setClave(enc.encriptar(user.getClave()));
		user.setActivo("A");
		user.setFechaUltimoPassword(new Date());
		user.setIntentos(0);
		dao.save(user);
        try {
			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/index.xhtml?faces-redirect=true";
	}
	
	public Usuario getUser() {
		return this.user;
	}
}
