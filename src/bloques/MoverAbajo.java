package bloques;

import algoritmo.Movimiento;
import algoritmo.Personaje;

public class MoverAbajo extends Movimiento{

    @Override
    public void moverPersonaje(Personaje un_personaje) {
        un_personaje.moverseA(0, -1);
    }

}
