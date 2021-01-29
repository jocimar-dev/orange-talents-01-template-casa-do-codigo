package com.br.zup.casadocodigo.regiao;

import com.br.zup.casadocodigo.validations.UniqueValue;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String pais;

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public Pais nomePais(EntityManager manager) { return  new Pais(pais);
    }
}
