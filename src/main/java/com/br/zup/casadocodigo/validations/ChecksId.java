package com.br.zup.casadocodigo.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ChecksIdValidations.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface ChecksId {

    String message() default "{com.deveficiente.beanvalidation.existsid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String fieldName();

    Class<?> domainClass();
}