package br.edu.uniritter.service;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.exception.ValidacaoEventoException;
import br.edu.uniritter.model.Evento;
import br.edu.uniritter.service.EventoService;
import br.edu.uniritter.validator.ValidadorEvento;

public class EventoServiceTest {

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
	public void deveGerarErroSalvarEventoMaiorQue150Caracteres() {
		try {
			new EventoService(this.validador).criar(new Evento(caracteres(200), LocalDate.now(), LocalDate.now().plusDays(7L)));
			fail("deveGerarErroSalvarEventoMaiorQue150Caracteres deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals("O nome permite no máximo 150 caracteres", e.getMessage());
		}
	}

	@Test
	public void devePassarSalvarEventoMenorQue150Caracteres() {
		new EventoService(this.validador).criar(new Evento(caracteres(149), LocalDate.now(), LocalDate.now().plusDays(7L)));
	}

	@Test
	public void devePassarSalvarEventoIgualQue150Caracteres() {
		new EventoService(this.validador).criar(new Evento(caracteres(150), LocalDate.now(), LocalDate.now().plusDays(7L)));
	}

	@Test
	public void deveGerarErroSalvarEventoDataMenorQueAtual() {
		try {
			new EventoService(this.validador).criar(new Evento(caracteres(150), LocalDate.now().minusDays(1L), LocalDate.now().plusDays(7L)));
			fail("deveGerarErroSalvarEventoDataMenorQueAtual deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals("A data do evento deve ser igual ou maior que a de hoje",e.getMessage());
		}
	}

	@Test
	public void devePassarSalvarEventoDataMaiorQueAtual() {
		new EventoService(this.validador).criar(new Evento(caracteres(149), LocalDate.now().plusDays(1L), LocalDate.now().plusDays(7L)));
	}

	@Test
	public void devePassarSalvarEventoDataIgualQueAtual() {
		new EventoService(this.validador).criar(new Evento(caracteres(149), LocalDate.now(), LocalDate.now().plusDays(7L)));
	}
}