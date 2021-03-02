package algoritmoTest;
/*
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
*/
import junit.framework.Assert;
import static org.junit.Assert.*;

import org.junit.Test;

import algoritmo.*;
import bloques.MoverArriba;
import bloques.RepetirTresVeces;
import dibujos.Dibujo;



public class RepetirTresVecesTest {
	
	@Test
	public void SeCreaUnBloqueDePerticionYPersonajeNoSeMueveTest() {
		
		Personaje personaje =new Personaje();
		RepetirTresVeces repeticion = new RepetirTresVeces();
		Dibujo dibujo = new Dibujo();
		
		repeticion.ejecutarBloque(personaje, dibujo);
		
		Posicion posicionDelPersonaje = personaje.getPosicion();
		Posicion posicionEsperada = new Posicion(5,5);
		
		Boolean iguales = posicionDelPersonaje.sonIguales(posicionEsperada);
		
		
		assertTrue(iguales);
		
	}
	
	@Test
	public void SeCreaUnBloqueDeReperticionYPersonajeSeMueveTest() {
		
		Personaje personaje =new Personaje();
		RepetirTresVeces repeticion = new RepetirTresVeces();
		MoverArriba arriba = new MoverArriba();
		Dibujo dibujo = new Dibujo();
		
		repeticion.agregarBloque(arriba);
		repeticion.ejecutarBloque(personaje, dibujo);
		
		Posicion posicionDelPersonaje = personaje.getPosicion();
		Posicion posicionEsperada = new Posicion(5,8);
		
		Boolean iguales = posicionDelPersonaje.sonIguales(posicionEsperada);
		
		
		assertTrue(iguales);
		
	}
	
	
	
}

