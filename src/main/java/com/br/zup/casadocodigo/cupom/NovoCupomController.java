package com.br.zup.casadocodigo.cupom;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoCupomController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/cupons")
	@Transactional
	public String cria(@RequestBody @Valid NovoCupomRequest request) {
		
		Cupom novoCupom = request.toModel();
		manager.persist(novoCupom);
		
		return novoCupom.toString();
	}

}
