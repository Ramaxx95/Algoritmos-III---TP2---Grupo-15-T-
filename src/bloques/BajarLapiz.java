package bloques;

import algoritmo.Escritura;
import algoritmo.Personaje;

public class BajarLapiz extends Escritura{

    @Override
    public void moverLapiz(Personaje un_personaje) {
        un_personaje.bajarLapiz();
    }

}
