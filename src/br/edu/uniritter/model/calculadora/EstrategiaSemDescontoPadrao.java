package br.edu.uniritter.model.calculadora;

import java.math.BigDecimal;

import br.edu.uniritter.model.ingresso.Ingresso;

public class EstrategiaSemDescontoPadrao implements EstrategiaDesconto {

	private Ingresso ingresso;

	public EstrategiaSemDescontoPadrao(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public BigDecimal calcular() {
		return this.ingresso.getValor();
	}

}
