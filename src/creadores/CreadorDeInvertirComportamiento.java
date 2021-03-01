package creadores;

import bloques.Bloque;
import bloques.InvertirComportamiento;

public class CreadorDeInvertirComportamiento implements CreadorDeBloques{

    @Override
    public Bloque crearBloque() {
        return new InvertirComportamiento();
    }
}
