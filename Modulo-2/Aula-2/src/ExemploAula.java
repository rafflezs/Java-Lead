import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploAula {
	public static void main(String[] args) {
		//Declarando a classe Scanner:
		Scanner scanner1 = new Scanner(System.in);

		//Solicitando um valor num�rico ao usu�rio:
		System.out.println("Informe um valor num�rico: ");

		//Recebendo a informa��o num�rica decimal:
		double valor = scanner1.nextDouble();

		//Exibindo o conte�do:
		System.out.println("O valor informado � " + valor);

		//Fechando o objeto scanner:
		scanner1.close();

		//Usando a estrutura try..catch:
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Informe um valor num�rico: ");
			Double valor1 = scanner.nextDouble();
			System.out.println("O valor1 informado �: " + valor1);
			scanner.close();
			}catch(InputMismatchException exception){
				System.err.println("Foi informado um valor de entrada inv�lido.");
			}

			//Colocando o valor em um la�o de repeti��o:
			while(true){
				try{
					Scanner scanner = new Scanner(System.in);
					System.out.print("Informe um valor num�rico: ");
					Double valor1 = scanner.nextDouble();
					System.out.println("O valor informado �: " + valor1);
					scanner.close();
					break;
					}catch(InputMismatchException exception){
						System.err.println("Foi informado um valor de entrada inv�lido. Por favor, insira um valor v�lido.");
					}
				//Adicionando um bloco catch com uma exce��o da classe Exception:
					catch (Exception exception){
						System.err.println("Foi detectado um erro desconhecido n�o tratado. Erro: " + exception);
						break;
					}
			}
	}
}
