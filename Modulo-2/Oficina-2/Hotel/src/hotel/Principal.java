package hotel;
import javax.swing.*;
import java.util.*;
import javafx;

/**
 * A classe Principal executa o main-loop do programa
 * gerenciando o cadastro de clientes e alocação de quartos.
 * @author thi-r
 *
 */
public class Principal {

	
	/**
	 * Embora a função main não receba parametros além do Args de sistema
	 * o código instância um objeto Hospede em um HashMap associando o cliente
	 * à um CPF único evitando repetições.
	 * Após validado os dados do cliente, o memso é alocado à um quarto instânciado
	 * unicamente para um Hospede.
	 */
	public static void main(String[] args) {
		
		 stage.show();
		
		HashMap<String, Hospede> hospedes = new HashMap<>();
		
		HashSet<Quarto> quartos = new HashSet<Quarto>(10);
		int quartCont = 0;
		
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Hospede \n2 - Procurar por Hospede \n3 - Exibir Hospede \n 0 - Sair"));
		while (operacao != 0) {
			switch (operacao) {
			case 1: {
			try {
					if (quartCont == 10) {
						quartCont = 0;
						throw new Exception("\nTodos os quartos estão ocupados.");
					}
					
					 TextField campoDeCpf = new TextField("CPF: ");
					 TextField campoDeRg = new TextField("RG: ");
					 TextField campoDeNome = new TextField("Nome: ");
					 TextField campoDeIdade = new TextField("Idade: ");
					 Button confirmar = new Button("Confirmar");

					 Button cancelar = new Button("Cancelar");
					
					int opt = JOptionPane.showConfirmDialog(null, "Selecione uma opção...","Cadastrar novo Hospede?", JOptionPane.YES_NO_OPTION);
					
					if (opt != 0) {
						continue;
					}
					
					while (opt == 0) {
						
						String nome = JOptionPane.showInputDialog("Nome: ");
						String cpf = JOptionPane.showInputDialog("CPF: ");
						String rg = JOptionPane.showInputDialog("RG: ");
						int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
						String endereco = JOptionPane.showInputDialog("Endere�o");
						
						while(validarNome(nome) == false) {
							JOptionPane.showMessageDialog(null, "Por favor, digite um nome valido");
							nome = JOptionPane.showInputDialog("Nome: ");
						}
						Hospede newHospede = new Hospede(cpf, rg, nome, idade, endereco);
						hospedes.put(cpf, newHospede);
						opt = JOptionPane.showConfirmDialog(null, "Selecione uma opção...","Cadastrar novo Hospede?", JOptionPane.YES_NO_OPTION);
					
						quartos.add(new Quarto(quartCont,newHospede));
						quartCont++;
					}
				}catch(NumberFormatException e) { 
					JOptionPane.showMessageDialog(null,"Favor, inserir apenas numeros: " + e.getMessage());
				}catch(InputMismatchException e) { 
					JOptionPane.showMessageDialog(null,"O valor inserido deve ser numerico: " + e.getMessage());
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Não é possível alocar mais quartos!" + e.getMessage());
				}
			operacao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Hospede \n2 - Procurar por Hospede \n3 - Exibir Hospede \n 0 - Sair"));
			}
			break;
			case 2: {
				String cpf = JOptionPane.showInputDialog("Informe o CPF para busca: ");
				for(Quarto q : quartos) {
					if (q.getHospede().getCpf().equals(cpf)) {
						JOptionPane.showMessageDialog(null,q.getHospede().getNome() + " está no quarto " + q.getNumero());
						break;
					}
				}
				operacao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Hospede \n2 - Procurar por Hospede \n3 - Exibir Hospede \n 0 - Sair"));
			}
			break;
			case 3:{
				quartos.forEach(item->JOptionPane.showMessageDialog(null,item.getHospede().getNome() + " está no quarto " + item.getNumero()));
				operacao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Hospede \n2 - Procurar por Hospede \n3 - Exibir Hospede \n 0 - Sair"));
			}
			break;
			default: {
				operacao = 0;
			}
			}
		}
		
	}
	
	public void start(Stage stage) throws Excepetion {
		stage.show();
	}
	
	/**
	 * Valida por meio de expressão regular o nome do hospede
	 * @param String nome
	 * @return
	 */
	private static Boolean validarNome(String nome) {
	    String expression = "^[a-zA-Z\\s]+"; 
	    if(!nome.matches(expression)) 
	    	return false;
	    return true;
	}
	
	
}