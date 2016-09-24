package br.edu.uniritter.service;

import br.edu.uniritter.model.Evento;
import br.edu.uniritter.validator.ValidadorEvento;

public class EventoService {

	private ValidadorEvento validador;

	public EventoService(ValidadorEvento validator) {
		this.validador = validator;
	}

	public boolean criar(Evento evento) {
		return salvar(evento);
	}

	public boolean salvar(Evento evento) {
		return this.validador.validate(evento);
	}

}