package br.edu.uniritter.model.calculadora;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.model.desconto.DescontoGold;
import br.edu.uniritter.model.ingresso.IngressoVip;
import br.edu.uniritter.service.estrategia.EstrategiaDescontoPadrao;
import br.edu.uniritter.service.estrategia.EstrategiaSemDesconto;

public class EstrategiaSemDescontoTest {

	private EstrategiaSemDesconto desconto;
	
	@Before
	public void setup(){
		desconto = new EstrategiaSemDesconto(new IngressoVip());
	}
	
	@Test
	public void deveCalcularDescontoSubtraindoValorDoIngressoDoPercentualDeDesconto() {
		assertEquals(BigDecimal.valueOf(1000.00).setScale(2), desconto.calcular());
	}

}
