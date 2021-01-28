package com.br.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailDuplicadoValidator implements ConstraintValidator<com.br.zup.casadocodigo.autor.EmailDuplicado, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailDuplicado anotacao) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext contextoDeValidacao) {

        boolean existe = autorRepository.existsByEmail(email);
        return !existe;

    }
}
