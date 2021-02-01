package algoritmo;

public class RepetirDosVeces extends Repeticion{

    @Override
    public void repetirBloque(Personaje un_personaje) {

        for (int i = 0; i < 2; i++){

            bloque.ejecutarBloque(un_personaje);

        }

    }

}
