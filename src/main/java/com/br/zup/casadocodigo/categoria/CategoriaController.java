package com.br.zup.casadocodigo.categoria;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;
    
    @PostMapping(value = "/categorias")
    @Transactional
    public String cria(@RequestBody @Valid NovaCategoriaRequest request) {


        Categoria novaCategoria = request.categoriaNome();
        manager.persist(novaCategoria);
        return novaCategoria.toString();
    }

}
