package com.br.zup.casadocodigo.regiao;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/pais")
    @Transactional
    public String cria(@RequestBody @Valid NovoPaisRequest request) {
        Pais novoPais = request.nomePais(manager);
        manager.persist(novoPais);
        return novoPais.toString();
    }

}
