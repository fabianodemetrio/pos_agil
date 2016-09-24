package br.edu.uniritter.validator;

import java.time.LocalDate;

import br.edu.uniritter.model.Evento;

public class ValidadorEvento {
	private static final int QTD_MAX_CARACTERES = 150;

	public boolean validate(Evento evento) {
		if (noveEventoMaiorIgual(evento.getNome())) {
			System.out.println("O nome permite no máximo 150 caracteres");
			return false;
		}
		if (dataEventoMaiorAtual(evento.getData())) {
			System.out
					.println("A data do evento deve ser igual ou maior que a de hoje");
			return false;
		}
		return true;
	}

	public boolean noveEventoMaiorIgual(String nomeEvento) {
		return (nomeEvento.length() > QTD_MAX_CARACTERES);
	}

	public boolean dataEventoMaiorAtual(LocalDate dataEvento) {
		return dataEvento.isBefore(LocalDate.now());
	}

}
