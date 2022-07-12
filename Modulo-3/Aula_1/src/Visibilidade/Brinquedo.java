package Visibilidade;

public class Brinquedo {
    private int cargaDaPilha;
    // ...
    public void mover() {
        /* Nesse caso o metodo gastarPilha pode ser acessado
         * pois está sendo invocado dentro da classe Brinquedo
         */
        gastarPilha();
    }
    private void gastarPilha() { }
    // ...
}
