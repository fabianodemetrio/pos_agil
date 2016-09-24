package br.edu.uniritter.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.edu.uniritter.model.Evento;
import br.edu.uniritter.service.EventoService;

public class SalvarEventoTest {

	@Test
	public void salvarEventoMaiorQue150Caracteres() {
		Assert.assertEquals(false, new EventoService().salvar(new Evento("Evento MUITO GRANDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEee", LocalDate.now())));
	}
	
	@Test
	public void salvarEventoMenorQue150Caracteres() {
		Assert.assertEquals(true, new EventoService().salvar(new Evento("Evento X", LocalDate.now())));
	}
	
	@Test
	public void salvarEventoIgualQue150Caracteres() {
		Assert.assertEquals(true, new EventoService().salvar(new Evento("EventoCom150Caracteres:grandeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", LocalDate.now())));
	}
	
	 @Test
	public void salvarEventoDataMenorQueAtual() {
			Assert.assertEquals(false, new EventoService().salvar(new Evento("Evento", LocalDate.now().minusDays(1L))));
	}
	
	 @Test
	public void salvarEventoDataMaiorQueAtual() {

		Assert.assertEquals(true, new EventoService().salvar(new Evento("Evento X", LocalDate.now().plusDays(1L))));
	}
	
	@Test
	public void salvarEventoDataIgualQueAtual() {
		Assert.assertEquals(true, new EventoService().salvar(new Evento("Evento X", LocalDate.now())));
	}
}
