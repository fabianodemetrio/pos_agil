package br.edu.uniritter.model;

import java.time.LocalDate;

public class Evento {
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private String nome;

	public Evento(String nomeEvento, LocalDate dataInicioEvento, LocalDate dataFinalEvento) {
		this.nome = nomeEvento;
		this.dataInicio = dataInicioEvento;
		this.dataFinal = dataFinalEvento;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}