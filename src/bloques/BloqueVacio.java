package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

public class BloqueVacio implements Bloques{

    @Override
    public void ejecutarBloque(Personaje un_personaje,Dibujo un_dibujo) {
    }

	@Override
	public String ubicacion() {
		// TODO Esbozo de método generado automáticamente
		return "vacio";
	}

	@Override
	public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
		// TODO Esbozo de método generado automáticamente
		
	}
}
