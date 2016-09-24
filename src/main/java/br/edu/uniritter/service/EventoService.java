package br.edu.uniritter.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.uniritter.model.Evento;

public class EventoService {

	public boolean nomeEventoMaiorIgual150Caracteres(String nomeEvento) {
		return (nomeEvento.length() > 150);
	}

	public boolean dataEventoMaiorAtual(Date dataEvento) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		try {
			data = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataEvento.before(data);
	}

	public boolean salvar(Evento evento) {
		if (nomeEventoMaiorIgual150Caracteres(evento.getNome())) {
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
}