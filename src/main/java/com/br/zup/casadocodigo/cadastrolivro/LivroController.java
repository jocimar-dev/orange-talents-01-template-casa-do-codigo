package com.br.zup.casadocodigo.cadastrolivro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.ResultSet;

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
