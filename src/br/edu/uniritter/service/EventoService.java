package br.edu.uniritter.service;

import br.edu.uniritter.model.evento.Evento;
import br.edu.uniritter.validator.ValidadorEvento;

public class EventoService {

	private ValidadorEvento validador;

	public EventoService(ValidadorEvento validator) {
		this.validador = validator;
	}

	public void criar(Evento evento) {
		this.validador.validate(evento);
	}
}