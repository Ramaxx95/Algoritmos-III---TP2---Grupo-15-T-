package bloques;

import algoritmo.Escritura;
import algoritmo.Personaje;

public class SubirLapiz extends Escritura{

    @Override
    public void moverLapiz(Personaje un_personaje) {
        un_personaje.levantarLapiz();
    }

	@Override
	public String ubicacion() {
		// TODO Esbozo de m�todo generado autom�ticamente
		return "Subir lapiz";
	}

}
