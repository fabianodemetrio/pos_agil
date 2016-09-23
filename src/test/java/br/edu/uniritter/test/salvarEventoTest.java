package br.edu.uniritter.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.edu.uniritter.Evento;
import br.edu.uniritter.Formulario;

public class salvarEventoTest {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	Calendar cal = Calendar.getInstance();

	@Test
	public void salvarEventoMaiorQue150Caracteres() {
		Assert.assertEquals(false, new Formulario().salvar(new Evento("Evento MUITO GRANDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEee", cal.getTime())));
	}
	
	@Test
	public void salvarEventoMenorQue150Caracteres() {
		Assert.assertEquals(true, new Formulario().salvar(new Evento("Evento X", cal.getTime())));
	}
	
	@Test
	public void salvarEventoIgualQue150Caracteres() {
		Assert.assertEquals(true, new Formulario().salvar(new Evento("EventoCom150Caracteres:grandeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", cal.getTime())));
	}
	
	 @Test
	public void salvarEventoDataMenorQueAtual() {
		try{
			date = sdf.parse("16/09/2015");
			Assert.assertEquals(false, new Formulario().salvar(new Evento("Evento", date)));
		} catch (ParseException ignore) {
		}
	}
	
	 @Test
	public void salvarEventoDataMaiorQueAtual() {
		try {
			date = sdf.parse("12/12/2020");
		} catch (ParseException ignore) {
		}
		Assert.assertEquals(true, new Formulario().salvar(new Evento("Evento X", date)));
	}
	
	@Test
	public void salvarEventoDataIgualQueAtual() {
		Assert.assertEquals(true, new Formulario().salvar(new Evento("Evento X", cal.getTime())));
	}
}
