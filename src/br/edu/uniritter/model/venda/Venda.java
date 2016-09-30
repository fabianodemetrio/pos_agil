package br.edu.uniritter.model.venda;

import java.util.List;

import br.edu.uniritter.model.ingresso.Ingresso;

public class Venda {
	private List<Ingresso> ingressos;
	
	public List<Ingresso> getIngressos() {
		return ingressos;
	}
	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
}
