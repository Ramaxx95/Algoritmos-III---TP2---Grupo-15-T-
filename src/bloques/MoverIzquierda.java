package bloques;

import algoritmo.Movimiento;
import algoritmo.Personaje;

public class MoverIzquierda extends Movimiento{

    @Override
    public void moverPersonaje(Personaje un_personaje) {
        un_personaje.moverseA(-1, 0);
    }

	@Override
	public String ubicacion() {
		// TODO Esbozo de m�todo generado autom�ticamente
		return "Mover izquierda";
	}

}
