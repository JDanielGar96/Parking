package com.unbosque.validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;


@FacesValidator("com.unbosque.validators.LoginNameValidator")
public class LoginNameValidator implements Validator {
	
	private static int minLenght = 5; // OPTION
	private static int maxLenght = 8; // OPTION
	
	public LoginNameValidator() {}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String nameValue = value.toString();
		if(nameValue.length() <= LoginNameValidator.minLenght && nameValue.length() >= LoginNameValidator.maxLenght) {
			FacesMessage msg = 
				new FacesMessage(null, "El usuario debe contener entre 5 y 8 caracteres.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		UsuarioDAOImpl implementation = new UsuarioDAOImpl();
		List<Object> userList = implementation.list();
		for(Object userObject: userList) { // TODO WARN
			Usuario user = (Usuario) userObject;
			System.out.println("Validando Email...");
			if(user.getLogin().equalsIgnoreCase(nameValue)) {
				FacesMessage msg = 
					new FacesMessage(null, "El login solicitado ya existe.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}
	}
	

}
