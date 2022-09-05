import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTeste {
    @Test
    public void somarDoisValores() throws Exception{
        int valor1 = 1;
        int valor2 = 2;

        Calculadora calc = new Calculadora();
        int soma = calc.soma(valor1, valor2);
        assertEquals(3,soma);
    }

    @Test
    public void substrairDoisValores() throws Exception {
        int valor1 = 10;
        int valor2 = 4;

        Calculadora calc = new Calculadora();
        int subtracao = calc.subtracao(valor1, valor2);
        assertEquals(6,subtracao);
    }

    @Test
    public void multiplicarDoisValores() throws Exception {
        int valor1 = 100;
        int valor2 = 10;

        Calculadora calc = new Calculadora();
        int multiplicacao = calc.multiplicacao(valor1, valor2);
        assertEquals(1000, multiplicacao);
    }
}
