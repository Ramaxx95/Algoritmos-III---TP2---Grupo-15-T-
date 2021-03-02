package algoritmoTest;

import algoritmo.Posicion;
/*
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
*/
import junit.framework.Assert;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class PosicionTest {

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
    
    /*
    @Test
    public void test05MoverseUnPasoHaciaArribaEnElEjeYAlteraElValorFilaDeLaPosicion(){
        
        HashMap<Posicion, Posicion> map = new HashMap<>();
        Posicion posicion = new Posicion(1, 0);
        Posicion posicion2 = new Posicion(1, 1);
        Posicion posicion3 = new Posicion(2, 1);
        
        map.put(posicion, posicion2);
        map.put(posicion2, posicion3);
        
        assertTrue( posicion2.equals(map.get(posicion)) );
    }
    */
}
