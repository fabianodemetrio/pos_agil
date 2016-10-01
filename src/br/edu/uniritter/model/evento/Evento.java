package br.edu.uniritter.model.evento;

import java.util.List;

import org.joda.time.LocalDate;

import br.edu.uniritter.model.ingresso.Ingresso;

public class Evento {
	private LocalDate data;
	private LocalDate dataInicialVenda;
	private LocalDate dataFinalVenda;
	private List<Ingresso> ingressos;

	private String nome;

	public Evento(String nomeEvento, LocalDate dataEvento, LocalDate dataInicialVenda, LocalDate dataFinalVenda, List<Ingresso> ingressos) {
		this.nome = nomeEvento;
		this.data = dataEvento;
		this.dataInicialVenda = dataInicialVenda;
		this.dataFinalVenda = dataFinalVenda;
		this.ingressos = ingressos;
	}

	public LocalDate getDataInicialVenda() {
		return dataInicialVenda;
	}

	public void setDataInicialVenda(LocalDate dataInicialVenda) {
		this.dataInicialVenda = dataInicialVenda;
	}

	public LocalDate getDataFinalVenda() {
		return dataFinalVenda;
	}

	public void setDataFinalVenda(LocalDate dataFinalVenda) {
		this.dataFinalVenda = dataFinalVenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}