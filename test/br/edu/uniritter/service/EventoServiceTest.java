package br.edu.uniritter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.exception.ValidacaoEventoException;
import br.edu.uniritter.model.evento.Evento;
import br.edu.uniritter.model.ingresso.Ingresso;
import br.edu.uniritter.model.ingresso.IngressoBackstage;
import br.edu.uniritter.model.ingresso.IngressoPlateiaVip;
import br.edu.uniritter.model.ingresso.IngressoVip;
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
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());

		try {
			new EventoService(this.validador).criar(new Evento(caracteres(200), LocalDate.now(), LocalDate.now(),
					LocalDate.now().plusDays(2), listaIngressos));
			fail("deveGerarErroSalvarEventoMaiorQue150Caracteres deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals("O nome permite no maximo 150 caracteres",
					e.getMessage());
		}
	}

	@Test
	public void devePassarSalvarEventoMenorQue150Caracteres() {
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		new EventoService(this.validador).criar(new Evento(caracteres(149),
				LocalDate.now(), LocalDate.now(), LocalDate.now().plusDays(2), listaIngressos));
	}

	@Test
	public void devePassarSalvarEventoIgualQue150Caracteres() {
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		new EventoService(this.validador).criar(new Evento(caracteres(150),
				LocalDate.now(), LocalDate.now(), LocalDate.now().plusDays(2), listaIngressos));
	}

	@Test
	public void deveGerarErroSalvarEventoDataMenorQueAtual() {
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		try {
			new EventoService(this.validador).criar(new Evento(caracteres(150),
					LocalDate.now().minusDays(1), LocalDate.now(), LocalDate.now().plusDays(2), listaIngressos));
			fail("deveGerarErroSalvarEventoDataMenorQueAtual deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals(
					"A data do evento deve ser igual ou maior que a de hoje",
					e.getMessage());
		}
	}

	@Test
	public void devePassarSalvarEventoDataMaiorQueAtual() {
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		new EventoService(this.validador).criar(new Evento(caracteres(149),
				LocalDate.now().plusDays(1), LocalDate.now(), LocalDate.now().plusDays(2), listaIngressos));
	}

	@Test
	public void devePassarSalvarEventoDataIgualQueAtual() {
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		new EventoService(this.validador).criar(new Evento(caracteres(149),
				LocalDate.now(), LocalDate.now(), LocalDate.now().plusDays(2), listaIngressos));
	}
	
	@Test
	public void deveGerarErroSalvarEventoDataInicioVendaMenorDataInicio(){
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		try {
			new EventoService(this.validador).criar(new Evento(caracteres(149),
					LocalDate.now(), LocalDate.now(), LocalDate.now().minusDays(2), listaIngressos));
			fail("deveGerarErroSalvarEventoDataInicioVendaMenorQueInicio deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals(
					"A data de inicio de venda deve ser inferior a data de fim",
					e.getMessage());
		}

	}
	
	@Test
	public void devePassarSalvarEventoDataInicioVendaMaiorDataInicio(){
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		new EventoService(this.validador).criar(new Evento(caracteres(149),
				LocalDate.now(), LocalDate.now(), LocalDate.now().plusDays(2), listaIngressos));
	}
	
	@Test
	public void devePassarSalvarEventoDataInicioVendaIgualDataInicio(){
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		new EventoService(this.validador).criar(new Evento(caracteres(149),
				LocalDate.now(), LocalDate.now(), LocalDate.now(), listaIngressos));
	}
	
	@Test
	public void devePassarSalvarEventoIngressosDiferentes(){
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		new EventoService(this.validador).criar(new Evento(caracteres(149),
				LocalDate.now(), LocalDate.now(), LocalDate.now(), listaIngressos));
	}
	
	@Test
	public void deveGerarErroSalvarEventoIngressosIguais(){
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>(0);
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoVip());
		listaIngressos.add(new IngressoBackstage());
		listaIngressos.add(new IngressoPlateiaVip());
		
		try {
			new EventoService(this.validador).criar(new Evento(caracteres(149),
					LocalDate.now(), LocalDate.now(), LocalDate.now(), listaIngressos));
			fail("deveGerarErroSalvarEventoIngressosIguais deveria falhar!");
		} catch (ValidacaoEventoException e) {
			assertEquals(
					"Nao e permitido repetir ingressos",
					e.getMessage());
		}

	}
}
