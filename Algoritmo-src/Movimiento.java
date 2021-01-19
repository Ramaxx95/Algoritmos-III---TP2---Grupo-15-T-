package algoritmo;

public abstract class Movimiento implements Bloques{

    @Override
    public void ejecutarBloque(Personaje un_personaje) {
        this.moverPersonaje(un_personaje);
    }

    public abstract void moverPersonaje(Personaje un_personaje);

}
