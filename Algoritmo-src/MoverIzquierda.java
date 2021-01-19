package algoritmo;

public class MoverIzquierda extends Movimiento{

    @Override
    public void moverPersonaje(Personaje un_personaje) {
        un_personaje.moverseA(-1, 0);
    }

}
