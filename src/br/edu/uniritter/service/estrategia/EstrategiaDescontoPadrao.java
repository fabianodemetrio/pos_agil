package br.edu.uniritter.service.estrategia;

import java.math.BigDecimal;

import br.edu.uniritter.model.desconto.Desconto;
import br.edu.uniritter.model.ingresso.Ingresso;

public class EstrategiaDescontoPadrao implements EstrategiaDesconto {

	private Ingresso ingresso;
	private Desconto desconto;

	public EstrategiaDescontoPadrao(Ingresso ingresso, Desconto desconto) {
		this.ingresso = ingresso;
		this.desconto = desconto;
	}

	public BigDecimal calcular() {
		return this.ingresso
				.getValor()
				.subtract(
						this.ingresso.getValor().multiply(
								this.desconto.getPorcentagem())).setScale(2);
	}

}
