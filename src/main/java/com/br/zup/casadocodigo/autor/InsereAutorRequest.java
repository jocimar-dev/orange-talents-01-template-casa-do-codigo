package com.br.zup.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InsereAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @EmailDuplicado
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor paraAutor() {
        return new Autor(nome, email, descricao);
    }

}
