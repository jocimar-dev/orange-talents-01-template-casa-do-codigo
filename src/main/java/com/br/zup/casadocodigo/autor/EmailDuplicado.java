package com.br.zup.casadocodigo.autor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {EmailDuplicadoValidator.class})
@Target({FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface EmailDuplicado {

    String message() default "{email.duplicado}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
