package com.br.zup.casadocodigo.detalhamentolivro;

import com.br.zup.casadocodigo.cadastrolivro.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalheSiteLivroReponse {
    private DetalheSiteAutorResponse autor;
    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private String dataPublicacao;

    public DetalheSiteLivroReponse(Livro livro) {
        autor = new DetalheSiteAutorResponse(livro.getAutor());
        titulo = livro.getTitulo();
        isbn = livro.getTitulo();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
