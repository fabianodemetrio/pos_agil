package br.edu.uniritter.model.desconto;

import java.math.BigDecimal;

public class DescontoSilver implements Desconto {

	public BigDecimal getPorcentagem() {
		return new BigDecimal(0.6);
	}

}
