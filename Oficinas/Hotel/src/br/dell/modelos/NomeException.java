package br.dell.modelos;

public class NomeException extends Exception {
	private String nome;
	
	public NomeException(String nome) {
		this.nome = nome;
	}
	
	public String getMessage() {
		return "O nome informado (" + nome + ") n�o est� configurado nos padr�es corretos. O mesmo n�o pode conter caracteres especiais.";
	}
}
