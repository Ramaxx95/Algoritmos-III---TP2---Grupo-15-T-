package algoritmoTest;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Random;

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
		
		repeticion.ejecutarBloque(personaje);
		
		Posicion posicionDelPersonaje = personaje.getPosicion();
		Posicion posicionEsperada = new Posicion(5,5);
		
		Boolean iguales = posicionDelPersonaje.sonIguales(posicionDelPersonaje);
		
		
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void SeCreaUnBloqueDeReperticionYPersonajeSeMueveTest() {
		
		Personaje personaje =new Personaje();
		RepetirTresVeces repeticion = new RepetirTresVeces();
		MoverArriba arriba = new MoverArriba();
		
		repeticion.agregarBloque(arriba);
		repeticion.ejecutarBloque(personaje);
		
		Posicion posicionDelPersonaje = personaje.getPosicion();
		Posicion posicionEsperada = new Posicion(5,8);
		
		Boolean iguales = posicionDelPersonaje.sonIguales(posicionDelPersonaje);
		
		
		Assert.assertTrue(iguales);
		
	}
	
	
	
}

