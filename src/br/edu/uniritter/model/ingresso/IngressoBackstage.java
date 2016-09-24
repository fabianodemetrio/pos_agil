package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;

public class IngressoBackstage implements Ingresso{

	public BigDecimal getValor() {
		return new BigDecimal(800);
	}

}
