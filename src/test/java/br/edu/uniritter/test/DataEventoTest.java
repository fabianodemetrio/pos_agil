package br.edu.uniritter.test;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.uniritter.Formulario;

public class DataEventoTest {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void dataEventoMenorQueAtual() {
		try {
			Assert.assertEquals(true, new Formulario().dataEventoMaiorAtual(sdf.parse("16/09/2016")));
		} catch (ParseException ignore) {
		}
	}

	@Test
	public void dataEventoMaiorQueAtual() {
		Date date = new Date();
		try {
			date = sdf.parse("18/09/2019");
		} catch (ParseException ignore) {
		}
		Assert.assertEquals(false, new Formulario().dataEventoMaiorAtual(date));
	}
	
	@Test
	public void dataEventoIgualQueAtual() {
		Date date = new Date();
		try {
			date = sdf.parse(sdf.format(new Date()));
		} catch (ParseException ignore) {
		}
		Assert.assertEquals(false, new Formulario().dataEventoMaiorAtual(date));
	}
}
