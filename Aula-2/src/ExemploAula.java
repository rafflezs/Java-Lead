import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploAula {
	public static void main(String[] args) {
		//Declarando a classe Scanner:
		Scanner scanner1 = new Scanner(System.in);

		//Solicitando um valor numérico ao usuário:
		System.out.println("Informe um valor numérico: ");

		//Recebendo a informação numérica decimal:
		double valor = scanner1.nextDouble();

		//Exibindo o conteúdo:
		System.out.println("O valor informado é " + valor);

		//Fechando o objeto scanner:
		scanner1.close();

		//Usando a estrutura try..catch:
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Informe um valor numérico: ");
			Double valor1 = scanner.nextDouble();
			System.out.println("O valor1 informado é: " + valor1);
			scanner.close();
			}catch(InputMismatchException exception){
				System.err.println("Foi informado um valor de entrada inválido.");
			}

			//Colocando o valor em um laço de repetição:
			while(true){
				try{
					Scanner scanner = new Scanner(System.in);
					System.out.print("Informe um valor numérico: ");
					Double valor1 = scanner.nextDouble();
					System.out.println("O valor informado é: " + valor1);
					scanner.close();
					break;
					}catch(InputMismatchException exception){
						System.err.println("Foi informado um valor de entrada inválido. Por favor, insira um valor válido.");
					}
				//Adicionando um bloco catch com uma exceção da classe Exception:
					catch (Exception exception){
						System.err.println("Foi detectado um erro desconhecido não tratado. Erro: " + exception);
						break;
					}
			}
	}
}
