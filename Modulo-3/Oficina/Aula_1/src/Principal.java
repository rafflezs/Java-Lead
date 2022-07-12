import Loja.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Principal {

    public static void main(String[] args) {
        Cliente [] clientes = preencheClientes();
        List <Produto> [] listaProdutos = criaListaProdutos();
        RegistroDePagamento registroDePagamentos [] = new RegistroDePagamento[2];

        registroDePagamentos[0] = new RegistroDePagamento(clientes[0], listaProdutos[0], new Date());
        registroDePagamentos[1] = new RegistroDePagamento(clientes[1], listaProdutos[1], new Date());

        System.out.println(registroDePagamentos[0].toString());
        System.out.println(registroDePagamentos[1].toString());

    }

    public static Cliente [] preencheClientes() {
        Cliente clientes [] = new Cliente[2];
        clientes[0] = new Cliente("Thiago");
        clientes[1] = new Cliente("Rafael");
        return clientes;
    }

    public static Produto [] preencheProdutos () {
        Produto produtos [] = new Produto[6];

        produtos[0] = new Produto("Parafuso Sextavado", 4, "Prateleira A");
        produtos[1] = new Produto("Porca", 2, "Prateleira B");
        produtos[2] = new Produto("Arruela", 1, "Prateleira C");
        produtos[3] = new Produto("Prego", 5, "Prateleira D");
        produtos[4] = new Produto("Parafuso Allen", 8, "Prateleira E");
        produtos[5] = new Produto("Mancal", 100, "Prateleira F");

        return produtos;
    }

    public static List<Produto>[] criaListaProdutos() {
        Produto produtos [] = preencheProdutos();
        List<Produto> [] listas = new List[2];

        listas[0] = new ArrayList<>();
        listas[0].add(produtos[0]);
        listas[0].add(produtos[2]);
        listas[0].add(produtos[4]);

        listas[1] = new ArrayList<>();
        listas[1].add(produtos[1]);
        listas[1].add(produtos[2]);
        listas[1].add(produtos[3]);

        return listas;
    }

}
