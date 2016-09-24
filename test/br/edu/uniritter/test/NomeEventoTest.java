package br.edu.uniritter.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.validator.ValidadorEvento;

public class NomeEventoTest {

	private ValidadorEvento validador;

	private String caracteres(int tamanho) {
		char[] caracteres = new char[tamanho];
		Arrays.fill(caracteres, 'T');
		return new String(caracteres);
	}

	@Before
	public void setUp() {
		this.validador = new ValidadorEvento();
	}

	@Test
	public void nomeDoEventoMaiorQue150Caracteres() {
		Assert.assertEquals(true,this.validador.noveEventoMaiorIgual(caracteres(151)));
	}

	@Test
	public void nomeDoEventoMenorQue150Caracteres() {
		Assert.assertEquals(false,this.validador.noveEventoMaiorIgual(caracteres(50)));
	}

	@Test
	public void nomeDoEventoIgual150Caracteres() {
		Assert.assertEquals(false,this.validador.noveEventoMaiorIgual(caracteres(150)));
	}
}
