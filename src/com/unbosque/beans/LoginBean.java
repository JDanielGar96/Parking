package com.unbosque.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
		System.out.println("Hola");
	}

	public String loginUser() {
		System.out.println("Realizando el logueo...");
		UsuarioDAOImpl implementation = new UsuarioDAOImpl();
		String userName = user.getLogin();
		String password = user.getClave();
        String result = implementation.login(userName, password);
        if (result != null) {
            // Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute("userType", result);
            switch(result) {
            case "ADMIN":
            	return "/admin/home.xhtml?faces-redirect=true";
            case "OWNER":
            	return "/owner/home.xhtml?faces-redirect=true";
            case "CLIENT":
            	return "/client/home.xhtml?faces-redirect=true";
            }           
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Credenciales no validos",
                    "Porfavor, intenta de nuevo"));
        }
        return null;
	}
	
	
    public String logOutUser() {
    	System.out.println("LogOut...");
        HttpSession session = Util.getSession();
        session.invalidate();
        return "/index.xhtml?faces-redirect=true";
     }


	public Usuario getUser() {
		return this.user;
	}
}
