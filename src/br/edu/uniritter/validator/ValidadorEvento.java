package br.edu.uniritter.validator;

import java.time.LocalDate;

import br.edu.uniritter.exception.ValidacaoEventoException;
import br.edu.uniritter.model.Evento;

public class ValidadorEvento {
	private static final String MSG_DATA_EVENTO_IGUAL_MAIOR = "A data do evento deve ser igual ou maior que a de hoje";
	private static final String MSG_DATA_VENDA_INGRESSO_POSTERIOR_DATA_FINAL= "A data de início de venda deve ser inferior a data de fim";
	private static final String MSG_MAX_CARACTERES = "O nome permite no máximo 150 caracteres";
	private static final int QTD_MAX_CARACTERES = 150;

	public void validate(Evento evento){
		validaNomeEvento(evento.getNome());
		validaDataInicioEvento(evento.getDataInicio());
		validaDataFinalEvento(evento.getDataFinal());
	}

	public void validaNomeEvento(String nomeEvento) throws ValidacaoEventoException{
		if (nomeEvento.length() > QTD_MAX_CARACTERES)
			throw new ValidacaoEventoException(MSG_MAX_CARACTERES);
	}

	public void validaDataInicioEvento(LocalDate dataEvento) throws ValidacaoEventoException{
		 if (dataEvento.isBefore(LocalDate.now()))
			 throw new ValidacaoEventoException(MSG_DATA_EVENTO_IGUAL_MAIOR);
	}
	
	public void validaDataFinalEvento(LocalDate dataEvento) throws ValidacaoEventoException{
		 if (dataEvento.isBefore(LocalDate.now()))
			 throw new ValidacaoEventoException(MSG_DATA_VENDA_INGRESSO_POSTERIOR_DATA_FINAL);
	}

}
