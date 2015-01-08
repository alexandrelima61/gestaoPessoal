/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author jalima
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([0-9]{3}\\-?[0-9]{1})?")
public @interface NUMBANCO {

    @OverridesAttribute(constraint = Pattern.class, name = "message")
    String message() default "{br.com.gerenciapessoa.constraints.NUMBANCO.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
