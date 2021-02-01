package algoritmo;

public class RepetirTresVeces extends Repeticion{

    @Override
    public void repetirBloque(Personaje un_personaje) {

        for (int i = 0; i < 3; i++){

            bloque.ejecutarBloque(un_personaje);

        }

    }

}
