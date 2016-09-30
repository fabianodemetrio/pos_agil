package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IngressoVip implements Ingresso {
	public BigDecimal getValor() {
		return new BigDecimal(1000);
	}
	
	public LocalDate getVendaData(){
		return LocalDate.now();
	}
}
