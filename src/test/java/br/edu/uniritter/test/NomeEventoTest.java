package br.edu.uniritter.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.edu.uniritter.service.EventoService;

public class NomeEventoTest {

	private String caracteres(int tamanho) {
		char[] caracteres = new char[tamanho];
		Arrays.fill(caracteres, 'T');
		return new String(caracteres);
	}

	@Test
	public void nomeDoEventoMaiorQue150Caracteres() {
		Assert.assertEquals(true, new EventoService()
				.nomeEventoMaiorIgual150Caracteres(caracteres(151)));
	}

	@Test
	public void nomeDoEventoMenorQue150Caracteres() {
		Assert.assertEquals(false, new EventoService()
				.nomeEventoMaiorIgual150Caracteres(caracteres(50)));
	}

	@Test
	public void nomeDoEventoIgual150Caracteres() {
		Assert.assertEquals(false, new EventoService()
				.nomeEventoMaiorIgual150Caracteres(caracteres(150)));
	}
}
