package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

public interface Bloque {

    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo);
	
	void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo);
}
