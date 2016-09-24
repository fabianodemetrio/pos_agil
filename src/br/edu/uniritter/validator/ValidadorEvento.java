package br.edu.uniritter.validator;

import java.time.LocalDate;

import br.edu.uniritter.exceptions.ValidacaoEventoException;
import br.edu.uniritter.model.Evento;

public class ValidadorEvento {
	private static final int QTD_MAX_CARACTERES = 150;

	public boolean validate(Evento evento) {
		validaNomeEvento(evento.getNome());
		
		if (validaDataEvento(evento.getData())) {
			System.out
					.println("A data do evento deve ser igual ou maior que a de hoje");
			return false;
		}
		return true;
	}

	public void validaNomeEvento(String nomeEvento) throws ValidacaoEventoException{
		if (nomeEvento.length() > QTD_MAX_CARACTERES)
			throw new ValidacaoEventoException("O nome permite no máximo 150 caracteres");
	}

	public boolean validaDataEvento(LocalDate dataEvento) {
		return dataEvento.isBefore(LocalDate.now());
	}

}
