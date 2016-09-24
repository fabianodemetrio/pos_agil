package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;

public class IngressoVip implements Ingresso {
	public BigDecimal getValor() {
		return new BigDecimal(1000);
	}
}
