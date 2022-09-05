public class ContaBancaria {
    private double saldo;

    interface OperacaoBancaria {
        double calcular(double a, double b);
    }

    private double realizarOperacao (double saldo, double valor, OperacaoBancaria op) {
        return op.calcular(saldo,valor);
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    ContaBancaria() {
        this.saldo = 0;
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        OperacaoBancaria creditar = (a, b) -> a + b;
        OperacaoBancaria debitar = (a, b) -> a - b;
        System.out.println("Saldo pós-credito: " + conta.realizarOperacao(conta.getSaldo(),50, creditar));
        conta.setSaldo(conta.realizarOperacao(conta.getSaldo(),50, creditar)); // Hotfix para evitar que o valor da conta seja negativo
        System.out.println("Saldo pós-credito: " + conta.realizarOperacao(conta.getSaldo(),10, debitar)); //-10?
    }
}


