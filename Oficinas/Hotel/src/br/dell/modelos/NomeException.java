package br.dell.modelos;

public class NomeException extends Exception {
	private String nome;
	
	public NomeException(String nome) {
		this.nome = nome;
	}
	
	public String getMessage() {
		return "O nome informado (" + nome + ") não está configurado nos padrões corretos. O mesmo não pode conter caracteres especiais.";
	}
}
