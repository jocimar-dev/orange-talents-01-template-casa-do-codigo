package com.br.zup.casadocodigo.compras;

import com.br.zup.casadocodigo.regiao.Estado;
import com.br.zup.casadocodigo.regiao.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovaCompraRequest request = (NovaCompraRequest) target;
		
		if(request.temEstado()) {
			Pais pais = manager.find(Pais.class, request.getIdPais());
			Estado estado = manager.find(Estado.class, request.getIdEstado());
			if(!estado.pertenceAPais(pais)) {
				errors.rejectValue("idEstado",null,"este estado não é o do país selecionado");
			}
		}
				
	}

}
