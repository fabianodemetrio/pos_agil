package br.edu.uniritter.test;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.edu.uniritter.model.Evento;
import br.edu.uniritter.service.EventoService;

public class SalvarEventoTest {
	
	private String caracteres(int tamanho) {
		char[] caracteres = new char[tamanho];
		Arrays.fill(caracteres, 'F');
		return new String(caracteres);
	}

	@Test
	public void salvarEventoMaiorQue150Caracteres() {
		Assert.assertEquals(false, new EventoService().salvar(new Evento(caracteres(200), LocalDate.now())));
	}
	
	@Test
	public void salvarEventoMenorQue150Caracteres() {
		Assert.assertEquals(true, new EventoService().salvar(new Evento(caracteres(149), LocalDate.now())));
	}
	
	@Test
	public void salvarEventoIgualQue150Caracteres() {
		Assert.assertEquals(true, new EventoService().salvar(new Evento(caracteres(150), LocalDate.now())));
	}
	
	 @Test
	public void salvarEventoDataMenorQueAtual() {
			Assert.assertEquals(false, new EventoService().salvar(new Evento(caracteres(149), LocalDate.now().minusDays(1L))));
	}
	
	 @Test
	public void salvarEventoDataMaiorQueAtual() {

		Assert.assertEquals(true, new EventoService().salvar(new Evento(caracteres(149), LocalDate.now().plusDays(1L))));
	}
	
	@Test
	public void salvarEventoDataIgualQueAtual() {
		Assert.assertEquals(true, new EventoService().salvar(new Evento(caracteres(149), LocalDate.now())));
	}
}
