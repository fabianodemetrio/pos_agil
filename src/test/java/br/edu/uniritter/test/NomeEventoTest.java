package br.edu.uniritter.test;

import org.junit.Assert;
import org.junit.Test;

import br.edu.uniritter.service.EventoService;

public class NomeEventoTest {
	@Test
	public void nomeDoEventoMaiorQue150Caracteres() {
		Assert.assertEquals(true, new EventoService().nomeEventoMaiorIgual150Caracteres("adsdasdsadsadsasdsadadsadasdasdsadasdsadasdasdasdsadaadsdasdsadsadsasdsadadsadasdasdsadasdsadasdasdasdsadaadsdasdsadsadsasdsadadsadasdasdsadasdsadasdasdasdsadaadsdasdsadsadsasdsadadsadasdasdsadasdsadasdasdasdsada"));
	}

	@Test
	public void nomeDoEventoMenorQue150Caracteres() {
		Assert.assertEquals(false, new EventoService().nomeEventoMaiorIgual150Caracteres("teste"));
	}

	@Test
	public void nomeDoEventoIgual150Caracteres() {
		Assert.assertEquals(false, new EventoService().nomeEventoMaiorIgual150Caracteres("adsdasdsadsadsasdsadadsadasdasdsadasdsadasdasdasdsadaadsdasdsadsadsasdsadadsadasdasdsadasdsadasdasdasdsadaadsdasdsadsadsasdsadadsadasdasdsadasdsadasda"));
	}
}
