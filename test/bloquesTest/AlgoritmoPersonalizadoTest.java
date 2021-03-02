package bloquesTest;

import dibujos.Dibujo;
import excepciones.NoHayAlgoritmoGuardadoException;
import junit.framework.Assert;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import algoritmo.*;
import bloques.*;

public class AlgoritmoPersonalizadoTest {
	
	
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test01TratarDeGuardarUnAlgoritmoCuandoNoSeAgregoNingunBloqueAEsteSaltaError() throws NoHayAlgoritmoGuardadoException{

        Tablero tablero = new Tablero();
        thrown.expect(NoHayAlgoritmoGuardadoException.class);
        AlgoritmoPersonalizado bloque_guardado = new AlgoritmoPersonalizado(tablero.darAlgoritmoGuardado());

    }
    

    @Test
    public void test02GuardarTodoTipoDeBloques() throws NoHayAlgoritmoGuardadoException {

        Tablero tablero = new Tablero();
        MoverAbajo bloque_abajo = new MoverAbajo();
        RepetirDosVeces bloque_repetir = new RepetirDosVeces();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Personaje personaje = new Personaje();
        Dibujo dibujo = new Dibujo();

        bloque_repetir.agregarBloque(bloque_abajo);
        bloque_invertir.agregarBloque(bloque_repetir);
        tablero.agregarBloqueAlAlgoritmo(bloque_invertir);
        tablero.guardarAlgoritmoActual();
        AlgoritmoPersonalizado bloque_guardado = new AlgoritmoPersonalizado(tablero.darAlgoritmoGuardado());

        bloque_guardado.ejecutarBloque(personaje, dibujo);

        assertEquals(7, personaje.getPosicion().getFila());
    }

    @Test
    public void test03UsarInvertirComportamientoEnUnAlgoritmoGuardadoInvierteTodosLosBloquesQueContiene() throws NoHayAlgoritmoGuardadoException {

        Tablero tablero = new Tablero();
        MoverAbajo bloque_abajo = new MoverAbajo();
        InvertirComportamiento bloque_invertir = new InvertirComportamiento();
        Personaje personaje = new Personaje();

        tablero.agregarBloqueAlAlgoritmo(bloque_abajo);
        tablero.agregarBloqueAlAlgoritmo(bloque_abajo);
        tablero.guardarAlgoritmoActual();
        AlgoritmoPersonalizado bloque_guardado = new AlgoritmoPersonalizado(tablero.darAlgoritmoGuardado());
        tablero.reiniciarAlgoritmo();

        bloque_invertir.agregarBloque(bloque_guardado);
        tablero.agregarBloqueAlAlgoritmo(bloque_invertir);
        tablero.ejecutarAlgoritmoCon(personaje);

        assertEquals(7, personaje.getPosicion().getFila());
    }
}
