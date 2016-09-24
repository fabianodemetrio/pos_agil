package br.edu.uniritter.exception;

public class ValidacaoEventoException extends RuntimeException {
	public ValidacaoEventoException(String mensagemErro) {
		super(mensagemErro);
	}

	private static final long serialVersionUID = 1L;

}
