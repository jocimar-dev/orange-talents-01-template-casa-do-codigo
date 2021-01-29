package com.br.zup.casadocodigo.compras;

import com.br.zup.casadocodigo.cupom.Cupom;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository
		extends org.springframework.data.repository.Repository<Cupom, Long> {

	/**
	 * Busca por um cupom que existe no sistema
	 * @param codigo
	 * @return
	 */
	public Cupom getByCodigo(String codigo);
}
