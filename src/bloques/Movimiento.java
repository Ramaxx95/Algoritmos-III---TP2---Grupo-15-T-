package bloques;

import algoritmo.Personaje;
import algoritmo.Posicion;
import dibujos.Dibujo;

public abstract class Movimiento implements Bloque {

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
    	Posicion posicionAnterior = new Posicion( un_personaje.getPosicion().getColumna(), un_personaje.getPosicion().getFila() ); 
    	this.moverPersonaje(un_personaje);
        un_dibujo.DibujarEn(posicionAnterior, un_personaje);
    }

    public abstract void moverPersonaje(Personaje un_personaje);

}
