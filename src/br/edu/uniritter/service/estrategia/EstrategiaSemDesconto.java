package br.edu.uniritter.service.estrategia;

import java.math.BigDecimal;

import br.edu.uniritter.model.ingresso.Ingresso;

public class EstrategiaSemDesconto implements EstrategiaDesconto {

	private Ingresso ingresso;

	public EstrategiaSemDesconto(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public BigDecimal calcular() {
		return this.ingresso.getValor().setScale(2);
	}

}
