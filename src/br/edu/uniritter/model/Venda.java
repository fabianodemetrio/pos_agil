package br.edu.uniritter.model;

import java.util.List;

import br.edu.uniritter.model.ingresso.Ingresso;

public class Venda {
	private Evento evento;
	private List<Ingresso> ingressos;
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public List<Ingresso> getIngressos() {
		return ingressos;
	}
	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
}
