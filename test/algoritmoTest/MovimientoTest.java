package algoritmoTest;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import algoritmo.*;

class MovimientoTest {

    @Test
    public void test01BloqueMoverArribaMuevePersonajeHaciaArriba(){

        Personaje personaje_prueba = new Personaje();
        MoverArriba mover_arriba_prueba = new MoverArriba();

        mover_arriba_prueba.moverPersonaje(personaje_prueba);
        
        assertEquals(6, personaje_prueba.getPosicion().getFila());
    }

    @Test
    public void test02BloqueMoverAbajoMuevePersonajeHaciaAbajo(){

        Personaje personaje_prueba = new Personaje();
        MoverAbajo mover_abajo_prueba = new MoverAbajo();

        mover_abajo_prueba.moverPersonaje(personaje_prueba);
        
        assertEquals(4, personaje_prueba.getPosicion().getFila());
    }

    @Test
    public void test03BloqueMoverDerechaMuevePersonajeHaciaDerecha(){

        Personaje personaje_prueba = new Personaje();
        MoverDerecha mover_derecha_prueba = new MoverDerecha();

        mover_derecha_prueba.moverPersonaje(personaje_prueba);
        
        assertEquals(6, personaje_prueba.getPosicion().getColumna());
    }

    @Test
    public void test04BloqueMoverIzquierdaMuevePersonajeHaciaIzquierda(){

        Personaje personaje_prueba = new Personaje();
        MoverIzquierda mover_izquierda_prueba = new MoverIzquierda();

        mover_izquierda_prueba.moverPersonaje(personaje_prueba);
        
        assertEquals(4, personaje_prueba.getPosicion().getColumna());
    }
}