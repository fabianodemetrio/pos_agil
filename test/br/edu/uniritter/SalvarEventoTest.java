package br.edu.uniritter;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.model.Evento;
import br.edu.uniritter.service.EventoService;
import br.edu.uniritter.validator.ValidadorEvento;

public class SalvarEventoTest {

	private ValidadorEvento validador;

	private String caracteres(int tamanho) {
		char[] caracteres = new char[tamanho];
		Arrays.fill(caracteres, 'F');
		return new String(caracteres);
	}

	@Before
	public void setUp() {
		this.validador = new ValidadorEvento();
	}

	@Test
	public void salvarEventoMaiorQue150Caracteres() {
		Assert.assertEquals(false, new EventoService(this.validador)
				.criar(new Evento(caracteres(200), LocalDate.now())));
	}

	@Test
	public void salvarEventoMenorQue150Caracteres() {
		Assert.assertEquals(true, new EventoService(this.validador)
				.criar(new Evento(caracteres(149), LocalDate.now())));
	}

	@Test
	public void salvarEventoIgualQue150Caracteres() {
		Assert.assertEquals(true, new EventoService(this.validador)
				.criar(new Evento(caracteres(150), LocalDate.now())));
	}

	@Test
	public void salvarEventoDataMenorQueAtual() {
		Assert.assertEquals(false, new EventoService(this.validador)
				.criar(new Evento(caracteres(149), LocalDate.now()
						.minusDays(1L))));
	}

	@Test
	public void salvarEventoDataMaiorQueAtual() {

		Assert.assertEquals(true,
				new EventoService(this.validador).criar(new Evento(
						caracteres(149), LocalDate.now().plusDays(1L))));
	}

	@Test
	public void salvarEventoDataIgualQueAtual() {
		Assert.assertEquals(true, new EventoService(this.validador)
				.criar(new Evento(caracteres(149), LocalDate.now())));
	}
}
