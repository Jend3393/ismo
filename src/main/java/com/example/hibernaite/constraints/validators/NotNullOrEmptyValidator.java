package com.example.hibernaite.constraints.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.hibernaite.constraints.annotations.NotNullOrEmpty;
import com.example.hibernaite.persistence.entity.Collaborator;

public class NotNullOrEmptyValidator implements ConstraintValidator<NotNullOrEmpty, Collaborator> {
   public void initialize(NotNullOrEmpty constraint) {
   }

   public boolean isValid(Collaborator collaborator, ConstraintValidatorContext context) {
      if(collaborator.getEmail().isEmpty()
         || collaborator.getFirstName().isEmpty()
         || collaborator.getLastName().isEmpty()) return false;
      return true;
   }
}
