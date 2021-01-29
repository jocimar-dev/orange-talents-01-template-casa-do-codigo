package com.br.zup.casadocodigo.regiao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String pais;

    public Pais(@NotBlank String pais) {
        this.id = id;
        this.pais = pais;
    }

    @Deprecated
    public Pais() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pais.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("pais='" + pais + "'")
                .toString();
    }

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }
}
