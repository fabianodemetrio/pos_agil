package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IngressoPlateia implements Ingresso {

	public BigDecimal getValor() {
		return new BigDecimal(300);
	}

	public LocalDate getVendaData(){
		return LocalDate.now();
	}
}
