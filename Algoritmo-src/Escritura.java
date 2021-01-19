package algoritmo;

public abstract class Escritura implements Bloques {

    @Override
    public void ejecutarBloque(Personaje un_personaje) {
        this.moverLapiz(un_personaje);
    }

    public abstract void moverLapiz(Personaje un_personaje);
}
