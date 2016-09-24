package br.edu.uniritter.validator;

import java.time.LocalDate;

import br.edu.uniritter.exception.ValidacaoEventoException;
import br.edu.uniritter.model.Evento;

public class ValidadorEvento {
	private static final int QTD_MAX_CARACTERES = 150;

	public boolean validate(Evento evento) {
		validaNomeEvento(evento.getNome());
		validaDataEvento(evento.getData());
		return true;
	}

	public void validaNomeEvento(String nomeEvento) throws ValidacaoEventoException{
		if (nomeEvento.length() > QTD_MAX_CARACTERES)
			throw new ValidacaoEventoException("O nome permite no m�ximo 150 caracteres");
	}

	public void validaDataEvento(LocalDate dataEvento) throws ValidacaoEventoException{
		 if (dataEvento.isBefore(LocalDate.now()))
			 throw new ValidacaoEventoException("A data do evento deve ser igual ou maior que a de hoje");
	}

}
