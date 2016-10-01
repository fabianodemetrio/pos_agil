package br.edu.uniritter.calculadora;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import br.edu.uniritter.model.calculadora.CalculadoraDesconto;
import br.edu.uniritter.model.calculadora.EstrategiaDescontoPadrao;
import br.edu.uniritter.model.desconto.DescontoEstudante;
import br.edu.uniritter.model.desconto.DescontoGold;
import br.edu.uniritter.model.desconto.DescontoIdoso;
import br.edu.uniritter.model.desconto.DescontoSilver;
import br.edu.uniritter.model.ingresso.IngressoPlateia;
import br.edu.uniritter.model.ingresso.IngressoVip;

public class CalculadoraDescontoTest {

	@Test
	public void deveAplicarDescontoGold() {
		assertEquals(
				new BigDecimal(250.00).setScale(2, RoundingMode.HALF_DOWN),
				new CalculadoraDesconto(new EstrategiaDescontoPadrao(
						new IngressoVip(), new DescontoGold())).calcular());
	}

	@Test
	public void deveAplicarDescontoSilver() {
		assertEquals(
				new BigDecimal(120.00).setScale(2, RoundingMode.HALF_DOWN),
				new CalculadoraDesconto(new EstrategiaDescontoPadrao(
						new IngressoPlateia(), new DescontoSilver()))
						.calcular());
	}

	@Test
	public void deveAplicarDescontoIdoso() {
		assertEquals(
				new BigDecimal(500.00).setScale(2, RoundingMode.HALF_DOWN),
				new CalculadoraDesconto(new EstrategiaDescontoPadrao(
						new IngressoVip(), new DescontoIdoso())).calcular());
	}

	@Test
	public void deveAplicarDescontoEstudante() {
		assertEquals(
				new BigDecimal(500.00).setScale(2, RoundingMode.HALF_DOWN),
				new CalculadoraDesconto(new EstrategiaDescontoPadrao(
						new IngressoVip(), new DescontoEstudante())).calcular());
	}

}
