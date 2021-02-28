package main_test;

import algoritmo.Algoritmo;
import algoritmo.Personaje;
import bloques.MoverAbajo;
import bloques.*;
import dibujos.Dibujo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlgortimoTest {

    @Test
    public void test01BorrarLosBloquesDelAlgoritmoQuitaTodosLosBloquesQueSeEncuentranEnElAlgoritmo(){
        Algoritmo algoritmo = new Algoritmo();
        Bloque bloque = new MoverAbajo();

        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque);
        assertEquals(3, algoritmo.getAlgoritmo().size());

        algoritmo.borrarBloques();
        assertEquals(0, algoritmo.getAlgoritmo().size());
    }

    @Test
    public void test02EjecutarElAlgoritmoMueveAlPersonajeHaciaAbajo(){
        Algoritmo algoritmo = new Algoritmo();
        Bloque bloque = new MoverAbajo();
        Personaje personaje = new Personaje();
        Dibujo dibujo = new Dibujo();

        algoritmo.agregarBloque(bloque);
        algoritmo.ejecutar(personaje, dibujo);

        assertEquals(4, personaje.getPosicion().getFila());
    }
}
