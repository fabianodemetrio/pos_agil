package br.edu.uniritter.model;

import java.time.LocalDate;

public class Evento {
	private LocalDate data;
	private String nome;

	public Evento(String nomeEvento, LocalDate dataEvento) {
		this.nome = nomeEvento;
		this.data = dataEvento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}