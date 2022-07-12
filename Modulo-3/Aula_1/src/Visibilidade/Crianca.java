package Visibilidade;

public class Crianca {
    // ...
    public void brincarCerto(Brinquedo brinquedo) {
        brinquedo.mover();
    }

    public void brincarErrado(Brinquedo brinquedo) {
        brinquedo.mover();
        /* * Metodo gastarPilha é privado e inerente de brinquedo
         * * portanto não pode ser acessado a partir de criança
         * */
        //! brinquedo.gastarPilha();
    }
    // ...
}