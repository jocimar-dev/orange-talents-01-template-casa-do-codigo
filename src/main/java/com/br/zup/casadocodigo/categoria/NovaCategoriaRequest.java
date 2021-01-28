package com.br.zup.casadocodigo.categoria;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @JsonDeserialize(as = CategoriaRepository.class)

    private String nome;

    public NovaCategoriaRequest(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria categoriaNome() { return  new Categoria(nome);
    }
}
