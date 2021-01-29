package com.br.zup.casadocodigo.detalhamentolivro;

import com.br.zup.casadocodigo.cadastrolivro.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class DetalheSiteLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/produtos/{id}")
    public DetalheSiteLivroReponse detalhe(@PathVariable("id") Long id) {
        Livro livroBuscado = Optional.ofNullable(manager.find(Livro.class, id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        DetalheSiteLivroReponse detalheSiteLivroResponse = new DetalheSiteLivroReponse(livroBuscado);
        return detalheSiteLivroResponse;

    }
}
