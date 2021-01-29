package com.br.zup.casadocodigo.categoria;

import com.br.zup.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria categoriaNome() { return  new Categoria(nome);
    }
}
