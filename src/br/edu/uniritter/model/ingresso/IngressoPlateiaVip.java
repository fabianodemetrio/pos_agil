package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IngressoPlateiaVip implements Ingresso {

	public BigDecimal getValor() {
		return new BigDecimal(500);
	}
	
	public LocalDate getVendaData(){
		return LocalDate.now();
	}

}
