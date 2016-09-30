package br.edu.uniritter.model.ingresso;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Ingresso {
	BigDecimal getValor();
	LocalDate getVendaData();
}
