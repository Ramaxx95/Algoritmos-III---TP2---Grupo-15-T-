package algoritmo;

import bloques.Bloques;
import dibujos.Dibujo;

public abstract class Movimiento implements Bloques{

	@Override
    public void ejecutarBloque(Personaje un_personaje,Dibujo un_dibujo) {	
		if (un_personaje.puedeEscribir()){
			this.moverPersonaje(un_personaje);
			un_dibujo.DibujarEn(un_personaje.getPosicion(),un_personaje);
		}
    }

    public abstract void moverPersonaje(Personaje un_personaje);

}
