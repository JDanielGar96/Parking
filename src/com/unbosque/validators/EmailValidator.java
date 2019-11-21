package com.unbosque.validators;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.unbosque.entity.Usuario;
import com.unbosque.dao.impl.UsuarioDAOImpl;

@FacesValidator("com.unbosque.validators.EmailValidator")
public class EmailValidator implements Validator {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;
	
	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String emailValue = value.toString();
		matcher = pattern.matcher(emailValue);
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage(null, "Formato de correo no valido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
		UsuarioDAOImpl implementation = new UsuarioDAOImpl();
		List<Object> userList = implementation.list();
		for(Object userObject: userList) {
			Usuario user = (Usuario) userObject;
			System.out.println("Validando Email...");
			if(user.getCorreo().equalsIgnoreCase(emailValue)) {
				FacesMessage msg = 
					new FacesMessage(null, "El correo solicitado ya existe.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}
	}
}
