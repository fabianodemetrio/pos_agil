package br.edu.uniritter.validator;

import java.time.LocalDate;

import br.edu.uniritter.exception.ValidacaoEventoException;
import br.edu.uniritter.model.evento.Evento;

public class ValidadorEvento {
	private static final String MSG_DATA_EVENTO_IGUAL_MAIOR = "A data do evento deve ser igual ou maior que a de hoje";
	private static final String MSG_DATA_VENDA_INVALIDA = "A data de início de venda deve ser inferior a data de fim";
	private static final String MSG_MAX_CARACTERES = "O nome permite no máximo 150 caracteres";
	private static final String MSG_VALIDACAO_INGRESSO = "Não é permitido repetir ingressos";
	private static final int QTD_MAX_CARACTERES = 150;

	public void validate(Evento evento){
		validaNomeEvento(evento.getNome());
		validaDataEvento(evento.getData());
		validaDataVenda(evento);
		validaIngressos(evento);
	}

	public void validaNomeEvento(String nomeEvento) throws ValidacaoEventoException{
		if (nomeEvento.length() > QTD_MAX_CARACTERES)
			throw new ValidacaoEventoException(MSG_MAX_CARACTERES);
	}

	public void validaDataEvento(LocalDate dataEvento) throws ValidacaoEventoException{
		 if (dataEvento.isBefore(LocalDate.now()))
			 throw new ValidacaoEventoException(MSG_DATA_EVENTO_IGUAL_MAIOR);
	}
	
	public void validaDataVenda(Evento evento) {
		 if (evento.getDataInicialVenda().isAfter(evento.getDataFinalVenda()))
			 throw new ValidacaoEventoException(MSG_DATA_VENDA_INVALIDA);
	}
	
	public void validaIngressos(Evento evento){
		for(int i = 0; i < evento.getIngressos().size(); i++){
			for(int j = 0, repeticoes = 0; j < evento.getIngressos().size(); j++){
				if (evento.getIngressos().get(j).getClass().equals(evento.getIngressos().get(i).getClass())){
					repeticoes++;
				}
				if(repeticoes > 1){
					throw new ValidacaoEventoException(MSG_VALIDACAO_INGRESSO);					
				}
			}
		}
	}

}
