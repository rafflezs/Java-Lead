import helloworld.HelloWorld;

public class HelloTest {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld("Thiago");
        System.out.println("Olá, " + helloWorld.getUserName() + ", está é uma classe empacotada");

    }
}
