import estruturadedados.ArvoreAvl;

public class ForumMain {
    public static void main(String[] args) {
        ArvoreAvl avl = new ArvoreAvl();
        avl.criarNo(10);
        avl.criarNo(15);
        avl.criarNo(2);
        avl.criarNo(4);
        avl.printarPreOrdemRecursiva(avl.getRaiz());
    }
}
