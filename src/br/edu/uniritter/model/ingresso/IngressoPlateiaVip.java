package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;

public class IngressoPlateiaVip implements Ingresso {

	public BigDecimal getValor() {
		return new BigDecimal(500);
	}
}
