package br.edu.uniritter.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.exception.ValidacaoEventoException;

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
	public void deveGerarErroQuandoDataMenorAtual() {
		try{
			this.validador.validaDataEvento(LocalDate.now().minusDays(1));
			fail("deveGerarErroQuandoDataMenorAtual deveria falhar");
		}catch (ValidacaoEventoException e){
			assertEquals("A data do evento deve ser igual ou maior que a de hoje",e.getMessage());
		}
	}

	@Test
	public void devePassarQuandoDataMaiorAtual() {
		this.validador.validaDataEvento(LocalDate.now().plusDays(1));
	}

	@Test
	public void devePassarQuandoDataIgualAtual() {
		this.validador.validaDataEvento(LocalDate.now());
	}

	@Test
	public void deveGerarErroQuandoNomeEventoMaior150Caracteres() {
		try {
			this.validador.validaNomeEvento(caracteres(151));
			fail("deveGerarErroQuandoNomeEventoMaiorQue150Caracteres deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals("O nome permite no máximo 150 caracteres",e.getMessage());
		}
	}

	@Test
	public void devePassarNomeEventoMenor150Caracteres() {
		this.validador.validaNomeEvento(caracteres(50));
	}

	@Test
	public void devePassarNomeEventoIgual150Caracteres() {
		this.validador.validaNomeEvento(caracteres(150));
	}
	
	
}
