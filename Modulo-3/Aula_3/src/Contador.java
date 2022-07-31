import java.lang.*;

public class Contador implements Runnable{

    String contNome;
    Contador(String nome) {
        contNome = nome;
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 49; i++) {
            Contador contador = new Contador(String.valueOf(i));
            Thread tCont = new Thread(contador, String.valueOf(i));
            tCont.sleep(5);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 499; i++) {
            System.out.println("Thread " + contNome + " contado: " + i);
        }
    }
}
