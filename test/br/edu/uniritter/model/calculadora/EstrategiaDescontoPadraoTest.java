package br.edu.uniritter.model.calculadora;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.model.desconto.DescontoGold;
import br.edu.uniritter.model.ingresso.IngressoVip;
import br.edu.uniritter.service.estrategia.EstrategiaDescontoPadrao;

public class EstrategiaDescontoPadraoTest {

	private EstrategiaDescontoPadrao descontoPadrao;
	
	@Before
	public void setup(){
		descontoPadrao = new EstrategiaDescontoPadrao(new IngressoVip(), new DescontoGold());
	}
	
	@Test
	public void deveCalcularDescontoSubtraindoValorDoIngressoDoPercentualDeDesconto() {
		assertEquals(BigDecimal.valueOf(250.00).setScale(2), descontoPadrao.calcular());
	}

}
