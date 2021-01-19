package algoritmo;

public class MoverArriba extends Movimiento{

    @Override
    public void moverPersonaje(Personaje un_personaje) {
        un_personaje.moverseA(0, 1);
    }

}
