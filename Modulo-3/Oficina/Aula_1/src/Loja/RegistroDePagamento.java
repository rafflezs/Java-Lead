package Loja;

import java.util.Date;
import java.util.List;

public class RegistroDePagamento {

    private List<Produto> produtos;
    private Cliente cliente;
    private Date dataCompra;

    RegistroDePagamento() { }

    public RegistroDePagamento(Cliente cliente, List<Produto> produtos, Date dataCompra) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataCompra = dataCompra;
    }


    public String toString(){
        return ("O cliente " + cliente + " comprou os itens " + produtos + "na data " + dataCompra);
    }
}
