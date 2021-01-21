package com.br.zup.casadocodigo.autores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class CadastraAutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public void cadastra(@RequestBody @Valid NovoAutorRequest novoAutor) {

        Autor autor = novoAutor.paraAutor();
        System.out.println(autor);

        autorRepository.save(autor);

    }

}
