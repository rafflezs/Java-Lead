import java.io.File;

public class TesteDeArquivo {

    public static void main(String[] args){
        String enderecoArquivo = "D:\\DellLead\\Modulo-3\\Aula_2\\Teste.txt";

        File arquivoAlvo = new File(enderecoArquivo);

        if(arquivoAlvo.exists()){
            System.out.println("E arquivo? " + (arquivoAlvo.isFile() ? "Sim" : "Nao"));
            System.out.println("O arquivo tem " + arquivoAlvo.length() + "bytes");
            System.out.println("Esta dentro de " + arquivoAlvo.getParent());
        }else{
            System.out.println("O endereco informado nao existe.");
        }
    }
}
