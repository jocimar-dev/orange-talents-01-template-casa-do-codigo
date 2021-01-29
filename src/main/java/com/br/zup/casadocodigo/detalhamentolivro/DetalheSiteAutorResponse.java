package com.br.zup.casadocodigo.detalhamentolivro;

import com.br.zup.casadocodigo.autor.Autor;

public class DetalheSiteAutorResponse {

    private String nome;

    private String descricao;

    public DetalheSiteAutorResponse(Autor autor)  {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutor() {
        return nome;
    }
}
