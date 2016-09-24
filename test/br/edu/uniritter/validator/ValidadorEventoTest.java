package br.edu.uniritter.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.exceptions.ValidacaoEventoException;
import br.edu.uniritter.validator.ValidadorEvento;

public class ValidadorEventoTest {

	private ValidadorEvento validador;

	@Before
	public void setUp() {
		this.validador = new ValidadorEvento();
	}

	private String caracteres(int tamanho) {
		char[] caracteres = new char[tamanho];
		Arrays.fill(caracteres, 'T');
		return new String(caracteres);
	}

	
	@Test
	public void dataEventoMenorQueAtual() {
		Assert.assertEquals(true,this.validador.validaDataEvento(LocalDate.now().minusDays(1L)));
	}

	@Test
	public void dataEventoMaiorQueAtual() {
		Assert.assertEquals(false, this.validador.validaDataEvento(LocalDate.now().plusDays(1L)));
	}

	@Test
	public void dataEventoIgualQueAtual() {
		Assert.assertEquals(false,this.validador.validaDataEvento(LocalDate.now()));
	}

	@Test
	public void deveGerarErroQuandoNomeEventoMaiorQue150Caracteres() {
		try {
			this.validador.validaNomeEvento(caracteres(151));
			fail("deveGerarErroQuandoNomeEventoMaiorQue150Caracteres deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals("O nome permite no máximo 150 caracteres",e.getMessage());
		}
	}

	@Test
	public void nomeDoEventoMenorQue150Caracteres() {
		this.validador.validaNomeEvento(caracteres(50));
	}

	public void nomeDoEventoIgual150Caracteres() {
		this.validador.validaNomeEvento(caracteres(150));
	}
}
