package br.edu.uniritter.model;

import java.util.Date;

public class Evento {
	private Date data;
	private String nome;

	public Evento(String nomeEvento, Date dataEvento) {
		this.nome = nomeEvento;
		this.data = dataEvento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}