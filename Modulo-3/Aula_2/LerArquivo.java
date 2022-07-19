import java.io.*;

public class LerArquivo {

    public static void main(String[] args) {

        try {
            File arquivo = new File("D:\\DellLead\\Modulo-3\\Aula_2\\Teste.txt");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo));
            String linha = null;

            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

            bufferedReader.close();

        } catch (IOException exception) {
            System.err.println("# Ocorreu um erro durante a leitura do arquivo.");
            exception.printStackTrace();
        }
    }
}
