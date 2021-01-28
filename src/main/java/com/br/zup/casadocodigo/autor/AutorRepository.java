package com.br.zup.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    boolean existsByEmail(String email);

    Optional<Autor> findAutorByNome(String name);

}


