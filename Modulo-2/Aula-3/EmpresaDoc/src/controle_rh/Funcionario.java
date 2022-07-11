package controle_rh;

class Funcionario {

	private String nome;
	
	private int qtdFaltasMes;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdFaltasMes() {
		return qtdFaltasMes;
	}
	
	/*
	 * @param quantidade de dias faltados no mês (int)
	 * @return void
	 * 
	 * @author Daniel - RH
	 */
	public void setQtdFaltasMes(int qtdFaltasMes) {
		this.qtdFaltasMes = qtdFaltasMes;
	}
	
}
