package com.br.zup.casadocodigo.autor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CadastraAutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/autores")
    @Transactional
    public String cadastrar(@RequestBody @Valid InsereAutorRequest insereAutor) {

        Autor autor = insereAutor.paraAutor();
        manager.persist(autor);
        return autor.toString();

    }

}
