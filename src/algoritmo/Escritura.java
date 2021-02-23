package algoritmo;

import bloques.Bloques;
import dibujos.Dibujo;

public abstract class Escritura implements Bloques {

    @Override
    public void ejecutarBloque(Personaje un_personaje,Dibujo un_dibujo) {
        this.moverLapiz(un_personaje);
    }

    public abstract void moverLapiz(Personaje un_personaje);
}
