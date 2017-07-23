package com.oleksii.home.validation;

import com.oleksii.home.entity.User;
import com.oleksii.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Admin on 21.05.2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","invalid.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"secondName","invalid.secondName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","invalid.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","invalid.phone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login","invalid.login");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","invalid.password");

        if (user.getPhone().length()>13){
            errors.rejectValue("phone","invalid.phoneNumber");
        }
        if (userService.findByLogin(user.getLogin())!=null){
            errors.rejectValue("login","invalid.userExist");
        }
        if (!user.getEmail().matches(ValidationPatterns.EMAIL_PATTERN)){
            errors.rejectValue("email", "invalid.wrongEmailFormat");
        }

    }
}
