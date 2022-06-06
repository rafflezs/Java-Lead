package br.dell.modelos;

class Hospede {
	private String cpf;
	private String rg;
	private String nome;
	private int idade;
	private String endereco;
	
	public Hospede(String cpf, String rg, String nome, int idade, String endereco) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
