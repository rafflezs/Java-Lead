package hotel;

/**
 * Classe que gerencia o Hospede cadastrado.
 * @author Thiago Rafael
 * @version 1.1
 */

class Hospede {
	private String cpf;
	private String rg;
	private String nome;
	private int idade;
	private String endereco;
	
	/**
	 * Construtor do Objeto Hosepde
	 * @param cpf
	 * @param rg
	 * @param nome
	 * @param idade
	 * @param endereco
	 */
	public Hospede(String cpf, String rg, String nome, int idade, String endereco) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}

	/**
	 * @return
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return
	 */
	public String getRg() {
		return rg;
	}
	/**
	 * @param rg
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return
	 */
	public int getIdade() {
		return idade;
	}
	/**
	 * @param idade
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}
	/**
	 * @return
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
		
}