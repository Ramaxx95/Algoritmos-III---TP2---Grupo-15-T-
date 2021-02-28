package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

public abstract class Escritura implements Bloque {

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
        this.moverLapiz(un_personaje);
    }

    public abstract void moverLapiz(Personaje un_personaje);
}
