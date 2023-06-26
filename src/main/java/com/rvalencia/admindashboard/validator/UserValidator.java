package com.rvalencia.admindashboard.validator;

import org.apache.catalina.realm.JNDIRealm.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserValidator {

	 @Override
	    public boolean supports(Class<?> c) {
	        return User.class.equals(c);
	    }
	    
	    // 2
	    @Override
	    public void validate(Object object, Errors errors) {
	        User user = (User) object;
	        
	        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
	            // 3
	            errors.rejectValue("passwordConfirmation", "Match");
	        }         
	    }
}
