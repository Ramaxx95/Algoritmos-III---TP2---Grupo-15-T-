package bloques;

import algoritmo.Movimiento;
import algoritmo.Personaje;

public class MoverAbajo extends Movimiento{

    @Override
    public void moverPersonaje(Personaje un_personaje) {
        un_personaje.moverseA(0, -1);
    }

	@Override
	public String ubicacion() {
		// TODO Esbozo de m�todo generado autom�ticamente
		return "mover abajo";
	}

}
