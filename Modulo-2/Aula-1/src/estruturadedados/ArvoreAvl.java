package estruturadedados;

public class ArvoreAvl {

    // referencia do No raiz (pai)
    public No raiz;

    public void criarNo(int valor) {
        No novoNo = new No(valor);
        inserirNaArvore(this.raiz,novoNo);
    }


    /**
     * Descricao: Inserção recursiva na arvore
     * @param raiz
     * @param valor
     */
    public void inserirNaArvore(No raiz, No novoNo){

        // Caso a arvore esteja vazia (raiz nula), inserir na raiz
        if (raiz == null){
            this.raiz = novoNo;
        } else {
            // Caso contrario a raiz NÃO seja vazia, inserir os filhos em ordem
            if (novoNo.getValor() > raiz.getValor()) {
                // Valores maiores que a raiz são inseridos a direita

                if (raiz.getDireita() != null) {
                    inserirNaArvore(raiz.getDireita(), novoNo);
                } else {
                    raiz.setDireita(novoNo);
                    novoNo.setPai(raiz);
                }
            } else {
                if (novoNo.getValor() < raiz.getValor()) {
                    // Valores menores que a raiz são inseridos a esquerda

                    if (raiz.getEsquerda() != null) {
                        inserirNaArvore(raiz.getEsquerda(), novoNo);
                    } else {
                        raiz.setEsquerda(novoNo);
                        novoNo.setPai(raiz);
                    }
                }
            }
        }
    }

    /**
     * Descricao: Percorre a arvore, printando os valores em pre-ordem (esquerda - raiz - direita)
     * @param: raiz
     */
    public void printarPreOrdemRecursiva(No raiz) {
        // Percorrer a arvore apenas se a raiz NÃO for nula
        if (raiz != null) {
            printarPreOrdemRecursiva(raiz.getEsquerda());
            printarPreOrdemRecursiva(raiz.getDireita());
            System.out.println("Valor : " + raiz.getValor());
        }
    }

    public No getRaiz() {
        return raiz;
    }
}
