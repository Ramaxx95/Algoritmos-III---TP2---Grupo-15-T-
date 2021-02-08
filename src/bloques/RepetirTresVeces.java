package bloques;

import algoritmo.Personaje;

public class RepetirTresVeces extends Repeticion{

    @Override
    public void repetirBloque(Personaje un_personaje) {

        for (int i = 0; i < 3; i++){

        	//bloques.forEach(bloques -> bloques.ejecutarBloque(un_personaje));
        	bloque.ejecutarBloque(un_personaje);
        }

    }

}
