package algoritmoTest;

import algoritmo.*;
import bloques.*;
import excepciones.NoHayAlgoritmoGuardadoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void test06MoverPersonajeArribaConLapizAbajoDibuja(){

        Juego juego_prueba = new Juego();
        MoverArriba bloque_mover_arriba = new MoverArriba();
        BajarLapiz bloque_bajar_lapiz = new BajarLapiz();

        juego_prueba.agregarBloque(bloque_bajar_lapiz);
        juego_prueba.agregarBloque(bloque_mover_arriba);
        juego_prueba.ejecutarAlgoritmo();

        assertTrue(juego_prueba.personajePuedeEscribir());
    }
    
    @Test
    public void test07UsarMasDeUnBloqueDentroDeUnoDeRepeticion(){

        Juego juego_prueba = new Juego();
        MoverArriba bloque_mover_arriba = new MoverArriba();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        Repeticion bloque_repeticion = new RepetirDosVeces();

        bloque_repeticion.agregarBloque(bloque_mover_arriba);
        bloque_repeticion.agregarBloque(bloque_mover_derecha);
        juego_prueba.agregarBloque(bloque_repeticion);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(7, juego_prueba.posicionActual().getFila());
        assertEquals(7, juego_prueba.posicionActual().getColumna());
    }
    
    @Test
    public void test08UsarUnBloqueDeRepeticionVacioNoAlteraElAlgoritmo(){

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        Repeticion bloque_repeticion = new RepetirDosVeces();

        juego_prueba.agregarBloque(bloque_repeticion);
        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.agregarBloque(bloque_repeticion);
        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(7, juego_prueba.posicionActual().getColumna());
    }
    
    @Test
    public void test09GuardarUnAlgoritmoPersonalizado() throws NoHayAlgoritmoGuardadoException {

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();

        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.guardarAlgoritmo();

        AlgoritmoPersonalizado bloque_algo = new AlgoritmoPersonalizado(juego_prueba.pasarAlgoritmo());

        juego_prueba.agregarBloque(bloque_algo); //agrega 2 bloques mas de moverse a la derecha

        juego_prueba.ejecutarAlgoritmo();

        assertEquals(9, juego_prueba.posicionActual().getColumna());
    }
    
    @Test
    public void test10ReiniciarElAlgoritmoBorraTodosLosBloquesQueTeniaAnteriormenteYQuedaVacio(){

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        BajarLapiz bloque_bajar_lapiz = new BajarLapiz();

        juego_prueba.agregarBloque(bloque_bajar_lapiz);
        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.ejecutarAlgoritmo();   //personaje estaria en posicion (6,5)
        juego_prueba.reiniciar();

        assertEquals(5, juego_prueba.posicionActual().getColumna());
        assertEquals(5, juego_prueba.posicionActual().getFila());
        assertTrue(juego_prueba.tableroVacio());
   }
    
   @Test
   public void test11AlgoritmoPersonalizadoQuedaGuardadoDespuesDeReiniciarElAlgoritmo() throws NoHayAlgoritmoGuardadoException {

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();

        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.agregarBloque(bloque_mover_derecha);
        juego_prueba.guardarAlgoritmo();
        AlgoritmoPersonalizado bloque_algo = new AlgoritmoPersonalizado(juego_prueba.pasarAlgoritmo());

        juego_prueba.reiniciar();
        juego_prueba.agregarBloque(bloque_algo);

        juego_prueba.ejecutarAlgoritmo();

        assertEquals(7, juego_prueba.posicionActual().getColumna());
   }
    
}
