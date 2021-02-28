package algoritmoTest;

import algoritmo.Posicion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PosicionTest {

    @Test
    public void test01DosPosicionesDistintasQueTenganLasMismasCoordenadasSonIguales(){
        Posicion posicion_1 = new Posicion(1, 0);
        Posicion posicion_2 = new Posicion(1, 0);

        assertTrue(posicion_1.equals(posicion_2));
        //son dos objetos diferentes pero con posiciones iguales
        assertFalse(posicion_1.hashCode() == posicion_2.hashCode());
    }

    @Test
    public void test02CambiarLaPosicionOriginalParaQueDosPosicionesSeanIguales(){
        Posicion posicion_1 = new Posicion(1, 0);
        Posicion posicion_2 = new Posicion(0, 1);

        assertFalse(posicion_1.equals(posicion_2));

        posicion_1.reemplazar(posicion_2);

        assertTrue(posicion_1.equals(posicion_2));
    }

    @Test
    public void test03MoverseUnPasoHaciaLaDerechaEnElEjeXAlteraElValorColumnaDeLaPosicion(){
        Posicion posicion = new Posicion(1, 0);

        posicion.moverEnX(1);

        assertEquals(2, posicion.getColumna());
    }

    @Test
    public void test04MoverseUnPasoHaciaArribaEnElEjeYAlteraElValorFilaDeLaPosicion(){
        Posicion posicion = new Posicion(1, 0);

        posicion.moverEnY(1);

        assertEquals(1, posicion.getFila());
    }
}
