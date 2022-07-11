package estruturadedados;

public class No {
    private No esquerda;
    private No direita;
    private No pai;
    private int valor;

    public No(int valor){
        setEsquerda(setDireita(setPai(null)));
        setValor(valor);
    }

    public int getValor() {
        return valor;
    }

    public No getDireita() {
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public No getPai() {
        return pai;
    }

    public No setDireita(No direita) {
        this.direita = direita;
        return direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No setPai(No pai) {
        this.pai = pai;
        return pai;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
