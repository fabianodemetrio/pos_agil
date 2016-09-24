package br.edu.uniritter.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.edu.uniritter.service.EventoService;

public class DataEventoTest {

	@Test
	public void dataEventoMenorQueAtual() {
		Assert.assertEquals(true, new EventoService()
				.dataEventoMaiorAtual(LocalDate.now().minusDays(1L)));
	}

	@Test
	public void dataEventoMaiorQueAtual() {

		Assert.assertEquals(false,
				new EventoService().dataEventoMaiorAtual(LocalDate.now().plusDays(1L)));
	}

	@Test
	public void dataEventoIgualQueAtual() {
		Assert.assertEquals(false,
				new EventoService().dataEventoMaiorAtual(LocalDate.now()));
	}
}
