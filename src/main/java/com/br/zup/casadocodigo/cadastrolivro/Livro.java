package com.br.zup.casadocodigo.cadastrolivro;

import com.br.zup.casadocodigo.autor.Autor;
import com.br.zup.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private @Size(max = 500) String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    private int numeroPaginas;

    @NotBlank
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @ManyToOne
    @NotNull
    @Valid
    private Autor autor;

    @ManyToOne
    @NotNull
    @Valid
    private Categoria categoria;

    @Deprecated
    public Livro() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Livro.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("titulo='" + titulo + "'")
                .add("resumo='" + resumo + "'")
                .add("sumario='" + sumario + "'")
                .add("preco=" + preco)
                .add("numeroPaginas=" + numeroPaginas)
                .add("isbn='" + isbn + "'")
                .add("dataPublicacao=" + dataPublicacao)
                .add("autor=" + autor)
                .add("categoria=" + categoria)
                .toString();
    }

    public Livro(@NotBlank String titulo,
                 @NotBlank @Size(max = 500) String resumo,
                 @NotBlank String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @Min(100) int numeroPaginas,
                 @NotBlank String isbn,
                 @NotNull @Future LocalDate dataPublicacao,
                 @NotNull @Valid Autor autor,
                 @NotNull Categoria categoria) {
        super();
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }


    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

}

