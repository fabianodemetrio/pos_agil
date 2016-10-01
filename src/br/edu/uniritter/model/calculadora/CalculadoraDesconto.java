package br.edu.uniritter.model.calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.edu.uniritter.model.desconto.Desconto;
import br.edu.uniritter.model.ingresso.Ingresso;

public class CalculadoraDesconto {
	public BigDecimal calcular(Ingresso ingresso, Desconto desconto) {
		return ingresso.getValor().subtract(ingresso.getValor().multiply(desconto.getPorcentagem())).setScale(2, RoundingMode.HALF_DOWN);
	}
}
