package controle_rh;

class ControleRH {
	private float salarioBase;
	private int qtdFuncionarios;
	
	public float getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	
	/* 
	 * Obtêm a quantidade de faltas multiplicando as faltas de um funcionario por 12
	 * 
	 * @param funcionario (objeto instanciado)
	 * @return dias faltados (int) em um periodo de 12 meses
	 * 
	 * @author: Daniel - RH
	 */
	public int faltasAcumuladasAno(Funcionario f) {
		return f.getQtdFaltasMes() * 12;
	}
	
	/*
	 * @deprecated Essa função foi substituida pela
	 * @link {faltasAcumuladasAno} para obtênção das
	 * faltas no ano em detrimento a periodo restrito.
	 */
	public int faltasAcumuladasPeriodo(Funcionario f, int periodo) {
		return f.getQtdFaltasMes() * periodo;
	}
	
}
