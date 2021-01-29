package com.br.zup.casadocodigo.regiao;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/estado")
    @Transactional
    public String cria(@RequestBody @Valid NovoEstadoRequest request) {
        Pais novoEstado = request.novoEstado(manager);
        manager.persist(novoEstado);
        return novoEstado.toString();
    }

}
