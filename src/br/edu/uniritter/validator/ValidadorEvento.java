package br.edu.uniritter.validator;

import java.time.LocalDate;

import br.edu.uniritter.model.Evento;

public class ValidadorEvento {

	public boolean validate(Evento evento) {
		
		if (nomeEventoMaiorIgual150Caracteres(evento.getNome())) {
			System.out.println("O nome permite no máximo 150 caracteres");
			return false;
		}
		if (dataEventoMaiorAtual(evento.getData())) {
			System.out.println("A data do evento deve ser igual ou maior que a de hoje");
			return false;
		}
		return true;
	}

	public boolean nomeEventoMaiorIgual150Caracteres(String nomeEvento) {
		return (nomeEvento.length() > 150);
	}

	public boolean dataEventoMaiorAtual(LocalDate dataEvento) {
		return dataEvento.isBefore(LocalDate.now());
	}

}
