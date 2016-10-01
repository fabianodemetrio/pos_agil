package br.edu.uniritter.model.calculadora;

import java.math.BigDecimal;

public class CalculadoraDesconto {

	private EstrategiaDesconto estrategiaDesconto;

	public CalculadoraDesconto(EstrategiaDesconto estrategiaDesconto) {
		this.estrategiaDesconto = estrategiaDesconto;
	}

	public BigDecimal calcular() {
		return estrategiaDesconto.calcular();
	}
}
