
public class TratamentoExcecoes {

	public static void main(String[] args) {
		
		try {
			String[] s = {"Pos 0", "Pos 1"};
			System.out.println(s[2]);			
		}catch(ArrayIndexOutOfBoundsException error) {
			System.out.println("Houve erro ao acessar a posição do vetor n-dimensional: " + error.getMessage());
		} finally {
			System.out.println("Fim da execução");
		}
	}
	
}
