package com.br.zup.casadocodigo.compras;

import com.br.zup.casadocodigo.cadastrolivro.Livro;
import com.br.zup.casadocodigo.validations.ChecksId;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovoPedidoItemRequest {

	@NotNull
	@ChecksId(domainClass = Livro.class, fieldName = "id")
	private Long idLivro;
	@Positive
	private int quantidade;

	public NovoPedidoItemRequest(@NotNull Long idLivro,
			@Positive int quantidade) {
		super();
		this.idLivro = idLivro;
		this.quantidade = quantidade;
	}
	
	public Long getIdLivro() {
		return idLivro;
	}

	@Override
	public String toString() {
		return "NovoPedidoItemRequest [idLivro=" + idLivro + ", quantidade="
				+ quantidade + "]";
	}

	public ItemPedido toModel(EntityManager manager) {
		@NotNull Livro livro = manager.find(Livro.class, idLivro);
		return new ItemPedido(livro,quantidade);
	}
	
}
