package Loja;

public class Produto {

    private String nome;
    private float preco;
    private String path;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    Produto(){
        ///
    }

    public Produto(String nome, float preco, String path){
        this.nome = nome;
        this.preco = preco;
        this.path = path;
    }

    public String toString(){
        return (nome);
    }

}
