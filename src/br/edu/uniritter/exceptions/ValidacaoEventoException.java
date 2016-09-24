package br.edu.uniritter.exceptions;

public class ValidacaoEventoException extends RuntimeException {
	public ValidacaoEventoException(String mensagemErro) {
		super(mensagemErro);
	}

	private static final long serialVersionUID = 1L;

}
