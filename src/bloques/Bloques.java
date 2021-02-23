package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

public interface Bloques {

    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo);
	
	void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo);

	public String ubicacion();
}
