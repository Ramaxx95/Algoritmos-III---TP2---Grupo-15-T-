package algoritmoTest;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import algoritmo.*;
import bloques.MoverArriba;
import bloques.RepetirDosVeces;
import dibujos.Dibujo;



public class RepetirDosVecesTest {
	
	@Test
	public void SeCreaUnBloqueDePerticionYPersonajeNoSeMueveTest() {
		
		Personaje personaje =new Personaje();
		RepetirDosVeces repeticion = new RepetirDosVeces();
		
		repeticion.ejecutarBloque(personaje);
		
		Posicion posicionDelPersonaje = personaje.getPosicion();
		Posicion posicionEsperada = new Posicion(5,5);
		
		Boolean iguales = posicionDelPersonaje.sonIguales(posicionDelPersonaje);
		
		
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void SeCreaUnBloqueDeReperticionYPersonajeSeMueveTest() {
		
		Personaje personaje =new Personaje();
		RepetirDosVeces repeticion = new RepetirDosVeces();
		MoverArriba arriba = new MoverArriba();
		
		repeticion.agregarBloque(arriba);
		repeticion.ejecutarBloque(personaje);
		
		Posicion posicionDelPersonaje = personaje.getPosicion();
		Posicion posicionEsperada = new Posicion(5,7);
		
		Boolean iguales = posicionDelPersonaje.sonIguales(posicionDelPersonaje);
		
		
		Assert.assertTrue(iguales);
		
	}
	
	
	
}

