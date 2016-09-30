package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IngressoBackstage implements Ingresso{

	public BigDecimal getValor() {
		return new BigDecimal(800);
	}
	
	public LocalDate getVendaData(){
		return LocalDate.now();
	}

}
