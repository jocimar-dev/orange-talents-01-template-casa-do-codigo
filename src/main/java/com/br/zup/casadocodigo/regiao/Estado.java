package com.br.zup.casadocodigo.regiao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String pais;

    @NotBlank
    private String estados;

    public Estado(@NotBlank String pais) {
        this.id = id;
        this.pais = pais;
        this.estados = estados;
    }

    @Deprecated
    public Estado() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Estado.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("pais='" + pais + "'")
                .add("estados='" + estados + "'")
                .toString();
    }

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getEstados() {
        return estados;
    }
    public boolean pertenceAPais(Pais pais) {
        return this.pais.equals(pais);
    }
}
