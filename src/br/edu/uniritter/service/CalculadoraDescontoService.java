package br.edu.uniritter.service;

import java.math.BigDecimal;

import br.edu.uniritter.service.estrategia.EstrategiaDesconto;

public class CalculadoraDescontoService {

	private EstrategiaDesconto estrategiaDesconto;

	public CalculadoraDescontoService(EstrategiaDesconto estrategiaDesconto) {
		this.estrategiaDesconto = estrategiaDesconto;
	}

	public BigDecimal calcular() {
		return estrategiaDesconto.calcular();
	}
}
