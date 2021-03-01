package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

public abstract class Movimiento implements Bloque {

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
    	this.moverPersonaje(un_personaje);
        un_dibujo.DibujarEn(un_personaje.getPosicion(), un_personaje);
        
    }

    public abstract void moverPersonaje(Personaje un_personaje);

}
