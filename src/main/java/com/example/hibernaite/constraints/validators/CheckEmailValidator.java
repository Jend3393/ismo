package com.example.hibernaite.constraints.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.hibernaite.constraints.annotations.CheckEmail;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {
   public void initialize(CheckEmail constraint) {
   }

   public boolean isValid(String email, ConstraintValidatorContext context) {

      return email.contains("@");

   }
}
