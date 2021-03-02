package algoritmoTest;

import algoritmo.*;
import bloques.*;
import excepciones.NoHayAlgoritmoGuardadoException;
/*
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
*/
import junit.framework.Assert;
import static org.junit.Assert.*;

import org.junit.Test;

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

        AlgoritmoPersonalizado bloque_algo = new AlgoritmoPersonalizado(juego_prueba.pasarAlgoritmoGuardado());

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
        AlgoritmoPersonalizado bloque_algo = new AlgoritmoPersonalizado(juego_prueba.pasarAlgoritmoGuardado());

        juego_prueba.reiniciar();
        juego_prueba.agregarBloque(bloque_algo);

        juego_prueba.ejecutarAlgoritmo();

        assertEquals(7, juego_prueba.posicionActual().getColumna());
   }
    
    @Test
    public void test12InvertirUnBloqueDeMoverseALaDerechaHaceQueElPersonajeSeMuevaALaIzquierda(){

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_mover_derecha);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(4, juego_prueba.posicionActual().getColumna());
    }

    @Test
    public void test13InvertirUnBloqueDeMoverseALaIzquierdaHaceQueElPersonajeSeMuevaALaDerecha(){

        Juego juego_prueba = new Juego();
        MoverIzquierda bloque_mover_izquierda = new MoverIzquierda();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_mover_izquierda);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(6, juego_prueba.posicionActual().getColumna());
    }

    @Test
    public void test14InvertirUnBloqueDeMoverseHaciaAbajoHaceQueElPersonajeSeMuevaHaciaArriba(){

        Juego juego_prueba = new Juego();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_mover_abajo);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(6, juego_prueba.posicionActual().getFila());
    }

    @Test
    public void test15InvertirUnBloqueDeMoverseHaciaArribaHaceQueElPersonajeSeMuevaHaciaAbajo(){

        Juego juego_prueba = new Juego();
        MoverArriba bloque_mover_arriba = new MoverArriba();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_mover_arriba);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(4, juego_prueba.posicionActual().getFila());
    }

    @Test
    public void test16InvertirUnBloqueDeBajarElLapizHaceQueElPersonajeLoSuba(){

        Juego juego_prueba = new Juego();
        BajarLapiz bloque_bajar_lapiz = new BajarLapiz();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_bajar_lapiz);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertFalse(juego_prueba.personajePuedeEscribir());
    }

    @Test
    public void test17InvertirUnBloqueDeSubirElLapizHaceQueElPersonajeLoBaje(){

        Juego juego_prueba = new Juego();
        SubirLapiz bloque_subir_lapiz = new SubirLapiz();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_subir_lapiz);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertTrue(juego_prueba.personajePuedeEscribir());
    }

    @Test
    public void test18InvertirUnBloqueDeRepetirDosVecesALaDerecha(){

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        RepetirDosVeces bloque_repeticion = new RepetirDosVeces();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_repeticion.agregarBloque(bloque_mover_derecha);
        bloque_invertir.agregarBloque(bloque_repeticion);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(3, juego_prueba.posicionActual().getColumna());
    }

    @Test
    public void test19InvertirUnBloqueDeRepetirTresVecesHaciaAbajo(){

        Juego juego_prueba = new Juego();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        RepetirTresVeces bloque_repeticion = new RepetirTresVeces();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        bloque_repeticion.agregarBloque(bloque_mover_abajo);
        bloque_invertir.agregarBloque(bloque_repeticion);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(8, juego_prueba.posicionActual().getFila());
    }

    @Test
    public void test20InvertirUnBloqueDeAlgoritmoPersonalizadoInvierteLosBloquesDentroDeEseAlgoritmo() throws NoHayAlgoritmoGuardadoException{

        Juego juego_prueba = new Juego();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();

        juego_prueba.agregarBloque(bloque_mover_abajo);
        juego_prueba.agregarBloque(bloque_mover_abajo);
        juego_prueba.guardarAlgoritmo();
        AlgoritmoPersonalizado bloque_algoritmo = new AlgoritmoPersonalizado(juego_prueba.pasarAlgoritmoGuardado());
        
        juego_prueba.reiniciar();

        bloque_invertir.agregarBloque(bloque_algoritmo);
        juego_prueba.agregarBloque(bloque_invertir);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(7, juego_prueba.posicionActual().getFila());
    }

    @Test
    public void test21InvertirDosVecesUnBloqueDeMoverseALaDerechaAnulaLaInversionDeSuComportamiento(){

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        InvertirComportamiento bloque_invertir_2 = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_mover_derecha);
        bloque_invertir_2.agregarBloque(bloque_invertir);
        juego_prueba.agregarBloque(bloque_invertir_2);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(6, juego_prueba.posicionActual().getColumna()); //se movio a la derecha
    }

    @Test
    public void test22InvertirTresVecesUnBloqueDeMoverseALaDerechaHaceQueSeMuevaUnaPosicionALaIzquierda(){

        Juego juego_prueba = new Juego();
        MoverDerecha bloque_mover_derecha = new MoverDerecha();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        InvertirComportamiento bloque_invertir_2 = new InvertirComportamiento();
        InvertirComportamiento bloque_invertir_3 = new InvertirComportamiento();

        bloque_invertir.agregarBloque(bloque_mover_derecha);
        bloque_invertir_2.agregarBloque(bloque_invertir);
        bloque_invertir_3.agregarBloque(bloque_invertir_2);
        juego_prueba.agregarBloque(bloque_invertir_3);
        juego_prueba.ejecutarAlgoritmo();

        assertEquals(4, juego_prueba.posicionActual().getColumna()); //se movio a la derecha
    }
    
}
