package hotel;


/**
 * Classe que gerencia o quarto instanciado para um hospede único.
 * @author Thiago Rafael
 * @version 1.1
 */

class Quarto {
	

	private int numero;
	private Hospede hospede;

	/**
	 * Método construtor sem retorno, instância um quarto
	 * numero e com hospede cadastrado alocado.
	 * @param numero
	 * @param hospede
	 */
	public Quarto(int numero, Hospede hospede) {
		this.numero = numero;
		this.hospede = hospede;
	}
	
	
	/**
	 * @return numero do quarto
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * @param numero do quarto a ser instanciado
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * @return objeto instancia Hospede alocado ao quarto
	 */
	public Hospede getHospede() {
		return hospede;
	}
	
	/**
	 * @param hospede
	 */
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
}
