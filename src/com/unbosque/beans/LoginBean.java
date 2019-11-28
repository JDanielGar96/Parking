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
		UsuarioDAOImpl implementation = new UsuarioDAOImpl();
		String userName = user.getLogin();
		String password = user.getClave();
        String response = implementation.login(userName, password);
        if (response != null) {

            if(response.equalsIgnoreCase("ADMIN") || 
            		response.equalsIgnoreCase("OWNER") || 
            		response.equalsIgnoreCase("CLIENT")) {
                // Http Session and store username
                HttpSession session = Util.getSession();
                session.setAttribute("userName", userName);
                session.setAttribute("userType", response);
            	return "/"+ response.toLowerCase() +"/home.xhtml?faces-redirect=true";
            } else if(response.equalsIgnoreCase("PASSWORD")) {
            	FacesContext.getCurrentInstance().addMessage(
        			null,
        			new FacesMessage(FacesMessage.SEVERITY_WARN,
            					"Credenciales no validos",
            					"Porfavor, intenta de nuevo")
    			);
            } else {
        		FacesContext.getCurrentInstance().addMessage(
    				null,
    				new FacesMessage(FacesMessage.SEVERITY_WARN,
        						"Excedio el numero de intentos",
        						"Porfavor, contacte a un administrador")
    			);   	
            }
        } else {
    		FacesContext.getCurrentInstance().addMessage(
    				null,
    				new FacesMessage(FacesMessage.SEVERITY_WARN,
    						"Error",
    						"Ocurrio un error inesperado")
			);
        }
        return "/";
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
