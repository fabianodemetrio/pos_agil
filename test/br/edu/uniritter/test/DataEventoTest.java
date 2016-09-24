package br.edu.uniritter.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.validator.ValidadorEvento;

public class DataEventoTest {

	private ValidadorEvento validador;

	@Before
	public void setUp() {
		this.validador = new ValidadorEvento();
	}

	@Test
	public void dataEventoMenorQueAtual() {
		Assert.assertEquals(true,this.validador.dataEventoMaiorAtual(LocalDate.now().minusDays(1L)));
	}

	@Test
	public void dataEventoMaiorQueAtual() {
		Assert.assertEquals(false, this.validador.dataEventoMaiorAtual(LocalDate.now().plusDays(1L)));
	}

	@Test
	public void dataEventoIgualQueAtual() {
		Assert.assertEquals(false,this.validador.dataEventoMaiorAtual(LocalDate.now()));
	}
}
