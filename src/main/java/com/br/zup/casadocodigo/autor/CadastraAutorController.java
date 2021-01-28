package com.br.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class CadastraAutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid InsereAutorRequest insereAutor) {

        Autor autor = insereAutor.paraAutor();
        System.out.println(autor);

        autorRepository.save(autor);

        return ResponseEntity.ok().build();

    }

}
