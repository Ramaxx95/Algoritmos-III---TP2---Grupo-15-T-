package bloquesTest;

import dibujos.Dibujo;
import excepciones.NoHayAlgoritmoGuardadoException;
import junit.framework.Assert;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import algoritmo.*;
import bloques.*;

public class AlgoritmoPersonalizadoTest {

    @Test
    public void test01TratarDeGuardarUnAlgoritmoCuandoNoSeAgregoNingunBloqueAEsteSaltaError(){

        Algoritmo algoritmo = new Algoritmo();

        assertThrows(NoHayAlgoritmoGuardadoException.class, ()->{
                AlgoritmoPersonalizado bloque_guardado = new AlgoritmoPersonalizado(algoritmo);
        });

    }

    @Test
    public void test02GuardarTodoTipoDeBloques() throws NoHayAlgoritmoGuardadoException {

        Algoritmo algoritmo = new Algoritmo();
        MoverAbajo bloque_abajo = new MoverAbajo();
        RepetirDosVeces bloque_repetir = new RepetirDosVeces();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Personaje personaje = new Personaje();
        Dibujo dibujo = new Dibujo();

        bloque_repetir.agregarBloque(bloque_abajo);
        bloque_invertir.agregarBloque(bloque_repetir);
        algoritmo.agregarBloque(bloque_invertir);
        AlgoritmoPersonalizado bloque_guardado = new AlgoritmoPersonalizado(algoritmo);

        bloque_guardado.ejecutarBloque(personaje, dibujo);

        assertEquals(7, personaje.getPosicion().getFila());
    }

    @Test
    public void test03UsarInvertirComportamientoENUnAlgoritmoGuardadoInvierteTodosLosBloquesQueContiene() throws NoHayAlgoritmoGuardadoException {

        Algoritmo algoritmo = new Algoritmo();
        MoverAbajo bloque_abajo = new MoverAbajo();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Personaje personaje = new Personaje();
        Dibujo dibujo = new Dibujo();

        algoritmo.agregarBloque(bloque_abajo);
        algoritmo.agregarBloque(bloque_abajo);
        AlgoritmoPersonalizado bloque_guardado = new AlgoritmoPersonalizado(algoritmo);
        algoritmo.borrarBloques();

        bloque_invertir.agregarBloque(bloque_guardado);
        algoritmo.agregarBloque(bloque_invertir);
        algoritmo.ejecutar(personaje, dibujo);

        assertEquals(7, personaje.getPosicion().getFila());
    }
}
