package com.br.zup.casadocodigo.cadastrolivro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/livros")
    @Transactional
    public String cria(@RequestBody @Valid com.deveficiente.casadocodigov2.cadastrolivro.InsereLivroRequest request) {
        Livro novoLivro = request.toModel(manager);
        manager.persist(novoLivro);
        return novoLivro.toString();
    }

}
