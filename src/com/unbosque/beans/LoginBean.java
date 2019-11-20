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
	}

	public String loginUser() {
		System.out.println("Realizando el logueo...");
		UsuarioDAOImpl implementation = new UsuarioDAOImpl();
		String userName = user.getLogin();
		String password = user.getClave();
        boolean result = implementation.login(userName, password);
        if (result) {
            // Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("userName", userName);
            return "home";
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login no valido",
                    "Porfavor, intenta de nuevo"));
            return "login";
        }
	}
	
	
    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "index";
     }


	public Usuario getUser() {
		return this.user;
	}
}
