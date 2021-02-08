package algoritmoTest;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algoritmo.*;
import bloques.BajarLapiz;
import bloques.MoverAbajo;
import bloques.MoverArriba;
import bloques.MoverDerecha;
import bloques.MoverIzquierda;
import bloques.Repeticion;
import bloques.RepetirDosVeces;
import bloques.RepetirTresVeces;

public class JuegoTest {

    @Test
    public void test01BajarLapizDelPersonaje(){

        Juego juego_prueba = new Juego();
        BajarLapiz bloque_bajar_lapiz = new BajarLapiz();

        juego_prueba.agregarBloque(bloque_bajar_lapiz);
        juego_prueba.ejecutarAlgoritmo();

        assertTrue(juego_prueba.personajePuedeEscribir());
    }

    @Test
    public void test02MoverAlPersonajeUnaVezConTodosLosTiposDeMovimientoLoDejaEnElMismoLugarEnDondeEmpezo(){

        Juego juego_prueba = new Juego();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        MoverArriba bloque_mover_arriba = new MoverArriba();
        MoverIzquierda bloque_mover_izquierda = new MoverIzquierda();

        juego_prueba.agregarBloque(bloque_mover_abajo);
        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.agregarBloque(bloque_mover_arriba);
        juego_prueba.agregarBloque(bloque_mover_izquierda);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(5, juego_prueba.posicionActual().getFila());
        assertEquals(5, juego_prueba.posicionActual().getColumna());
    }
    
    
    @Test
    public void test03MoverAlPersonajeConBloqueDeRepeticionDeDosPasosALaDerecha(){

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        Repeticion bloque_repeticion = new RepetirDosVeces();

        bloque_repeticion.agregarBloque(bloque_mover_derecha);
        juego_prueba.agregarBloque(bloque_repeticion);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(7, juego_prueba.posicionActual().getColumna());
    }
    
    
    @Test
    public void test04MoverAlPersonajeConBloqueDeRepeticionDeTresPasosHaciaAbajo(){

        Juego juego_prueba = new Juego();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        Repeticion bloque_repeticion = new RepetirTresVeces();

        bloque_repeticion.agregarBloque(bloque_mover_abajo);
        juego_prueba.agregarBloque(bloque_repeticion);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(2, juego_prueba.posicionActual().getFila());
    }
    
    @Test
    public void test05UsarDosBloquesDeRepeticionParaMoverse4EspaciosHaciaAbajo(){

        Juego juego_prueba = new Juego();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        Repeticion bloque_repeticion_1 = new RepetirDosVeces();
        Repeticion bloque_repeticion_2 = new RepetirDosVeces();

        bloque_repeticion_1.agregarBloque(bloque_repeticion_2);
        bloque_repeticion_2.agregarBloque(bloque_mover_abajo);
        juego_prueba.agregarBloque(bloque_repeticion_1);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(1, juego_prueba.posicionActual().getFila());
    }
    
}