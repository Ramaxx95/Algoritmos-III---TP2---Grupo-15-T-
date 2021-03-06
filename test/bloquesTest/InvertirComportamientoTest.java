package bloquesTest;

import algoritmo.Algoritmo;
import algoritmo.Personaje;
import algoritmo.Tablero;
import dibujos.Dibujo;
import excepciones.NoHayAlgoritmoGuardadoException;
import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import bloques.*;

public class InvertirComportamientoTest {

    @Test
    public void test01InvertirElComportamientoDeUnBloqueDeMovimientoHaceQueSeMuevaEnLaDireccionOpuesta(){
        Personaje personaje = new Personaje();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Dibujo dibujo = new Dibujo();

        bloque_invertir.agregarBloque(bloque_mover_abajo);
        bloque_invertir.ejecutarBloque(personaje, dibujo);

        assertEquals(6, personaje.getPosicion().getFila());

    }

    @Test
    public void test02InvertirElComportamientoDeUnBloqueDeEscrituraHaceQueMuevaElLapizDeManeraOpuesta(){
        Personaje personaje = new Personaje();
        SubirLapiz bloque_subir_lapiz = new SubirLapiz();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Dibujo dibujo = new Dibujo();

        bloque_invertir.agregarBloque(bloque_subir_lapiz);
        bloque_invertir.ejecutarBloque(personaje, dibujo);

        assertTrue(personaje.puedeEscribir());

    }

    @Test
    public void test03InvertirElComportamientoDeUnBloqueDeRepeticionHaceQueCadaBloqueDentroSeComporaDeManeraOpuesta(){
        Personaje personaje = new Personaje();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        SubirLapiz bloque_subir_lapiz = new SubirLapiz();
        RepetirDosVeces bloque_repeticion = new RepetirDosVeces();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Dibujo dibujo = new Dibujo();

        bloque_repeticion.agregarBloque(bloque_subir_lapiz);
        bloque_repeticion.agregarBloque(bloque_mover_abajo);
        bloque_invertir.agregarBloque(bloque_repeticion);
        bloque_invertir.ejecutarBloque(personaje, dibujo);

        assertEquals(7, personaje.getPosicion().getFila());
        assertTrue(personaje.puedeEscribir());

    }

    @Test
    public void test04InvertirElComportamientoEnUnAlgoritmoPersonalizadoHaceQueCadaBloqueSeComporteDeManeraInversa() throws NoHayAlgoritmoGuardadoException {
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        MoverAbajo bloque_mover_abajo = new MoverAbajo();
        SubirLapiz bloque_subir_lapiz = new SubirLapiz();
        RepetirDosVeces bloque_repeticion = new RepetirDosVeces();
        AlgoritmoPersonalizado bloque_algoritmo = new AlgoritmoPersonalizado();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Dibujo dibujo = new Dibujo();

        bloque_repeticion.agregarBloque(bloque_subir_lapiz);
        bloque_repeticion.agregarBloque(bloque_mover_abajo);
        tablero.agregarBloqueAlAlgoritmo(bloque_repeticion);
        tablero.guardarAlgoritmoActual();
        bloque_algoritmo.agregarAlgoritmo(tablero.darAlgoritmoGuardado());
        bloque_invertir.agregarBloque(bloque_algoritmo);

        bloque_invertir.ejecutarBloque(personaje, dibujo);

        assertEquals(7, personaje.getPosicion().getFila());
        assertTrue(personaje.puedeEscribir());

    }
}
