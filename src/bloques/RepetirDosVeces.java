package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

public class RepetirDosVeces extends Repeticion{

    @Override
    public void repetirBloque(Personaje un_personaje, Dibujo un_dibujo) {

        for (int i = 0; i < 2; i++){

            bloques.forEach(bloques -> bloques.ejecutarBloque(un_personaje, un_dibujo));

        }

    }
	
    @Override
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {

        for (int i = 0; i < 2; i++){

            bloques.forEach(bloques -> bloques.ejecutarBloqueInvertido(un_personaje, un_dibujo));

        }
    }

}
