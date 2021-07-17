package com.java.spring.validator;

import com.java.spring.entity.Computer;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ComputerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Computer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Computer computer = (Computer) target;
        if (StringUtils.isNotBlank(computer.getModel()) && !CharUtils.isAsciiAlphaUpper(computer.getModel().charAt(0))){
            errors.rejectValue("model", "computer.model.capital-latter",
                    "Computer model should start with capital latter");
        }
    }
}
