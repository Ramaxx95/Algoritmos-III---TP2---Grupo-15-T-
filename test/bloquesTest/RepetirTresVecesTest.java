package bloques_test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import algoritmo.*;
import bloques.MoverArriba;
import bloques.RepetirTresVeces;
import dibujos.Dibujo;

public class RepetirTresVecesTest {

    @Test
    public void test01SeCreaUnBloqueDePerticionYPersonajeNoSeMueveTest() {

        Personaje personaje =new Personaje();
        RepetirTresVeces repeticion = new RepetirTresVeces();
        Dibujo dibujo = new Dibujo();

        repeticion.ejecutarBloque(personaje, dibujo);

        Posicion posicionDelPersonaje = personaje.getPosicion();
        Posicion posicionEsperada = new Posicion(5,5);

        boolean iguales = posicionDelPersonaje.equals(posicionEsperada);


        assertTrue(iguales);

    }

    @Test
    public void test02SeCreaUnBloqueDeReperticionYPersonajeSeMueveTest() {

        Personaje personaje =new Personaje();
        RepetirTresVeces repeticion = new RepetirTresVeces();
        MoverArriba arriba = new MoverArriba();
        Dibujo dibujo = new Dibujo();

        repeticion.agregarBloque(arriba);
        repeticion.ejecutarBloque(personaje, dibujo);

        Posicion posicionDelPersonaje = personaje.getPosicion();
        Posicion posicionEsperada = new Posicion(5,8);

        boolean iguales = posicionDelPersonaje.equals(posicionEsperada);


        assertTrue(iguales);

    }

}
