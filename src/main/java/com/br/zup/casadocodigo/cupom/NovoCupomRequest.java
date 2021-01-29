package com.br.zup.casadocodigo.cupom;

import com.br.zup.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoCupomRequest {

	@NotBlank
	@UniqueValue(domainClass = Cupom.class,fieldName = "codigo")
	private String codigo;
	@Positive
	@NotNull
	private BigDecimal percentualDesconto;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate validade;

	public NovoCupomRequest(@NotBlank String codigo,
			@Positive @NotNull BigDecimal percentualDesconto) {
		super();
		this.codigo = codigo;
		this.percentualDesconto = percentualDesconto;
	}
	
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Cupom toModel() {
		return new Cupom(codigo,percentualDesconto,validade);
	}

}
