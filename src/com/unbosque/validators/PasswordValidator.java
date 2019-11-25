package com.unbosque.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.unbosque.validators.PasswordValidator")
public class PasswordValidator implements Validator  {

	private boolean checkString(String str) {
	    char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	    }
	    return false;
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String passwordValues = value.toString();
		// TODO Auto-generated method stub
		if(passwordValues.length() <= 5) {
			FacesMessage msg = 
					new FacesMessage(null, "La clave debe tener minimo 5 caracteres.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
			
		if(!this.checkString(passwordValues) ) {
			FacesMessage msg = 
					new FacesMessage(null, "La clave debe tener una mayuscula, una minuscula y un digito.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
