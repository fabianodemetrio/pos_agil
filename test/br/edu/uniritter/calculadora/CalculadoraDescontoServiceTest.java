package br.edu.uniritter.calculadora;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import br.edu.uniritter.service.CalculadoraDescontoService;
import br.edu.uniritter.service.estrategia.EstrategiaDesconto;

public class CalculadoraDescontoServiceTest {
	
	private CalculadoraDescontoService calculadora;
	
	@Mock
	private EstrategiaDesconto estrategia;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		calculadora = new CalculadoraDescontoService(estrategia);
	}

	@Test
	public void deveCalcularDescontoViaEstrategia() {
		calculadora.calcular();
		
		verify(estrategia).calcular();
		
	}
}
