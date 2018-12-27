package com.example.hibernaite.constraints.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.hibernaite.constraints.validators.CheckEmailValidator;
import com.example.hibernaite.persistence.enums.Errors;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {

    /**
     * @return the associated error code.
     */
    Errors error() default Errors.A01;

    /**
     * @return the error message template.
     */
    String message() default "email invalide";
    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};
    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};
}
