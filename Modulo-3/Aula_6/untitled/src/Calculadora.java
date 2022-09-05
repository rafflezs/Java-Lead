// Lambda Function

public class Calculadora {
     interface OperacaoMatematica { // 1
         double operacao(double a, double b);
     }
     public double calcular(double a, double b, OperacaoMatematica operador) { // 2
         return operador.operacao(a, b);
     }
     public static void main(String[] args) {
         Calculadora calculadora = new Calculadora();
         OperacaoMatematica adicao = (a, b) -> a + b; // 3
         OperacaoMatematica subtracao = (a, b) -> a - b; // 3
         double a = 7.2;
         double b = 6.2;
         System.out.println(a + " + " + b + " = " + calculadora.calcular(a, b, adicao)); // 4
         System.out.println(a + " - " + b + " = " + calculadora.calcular(a, b, subtracao)); // 4
     }
}