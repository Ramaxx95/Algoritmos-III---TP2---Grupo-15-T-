package dibujosTest;

/*
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
*/
import junit.framework.Assert;
import static org.junit.Assert.*;

import org.junit.Test;

import algoritmo.*;
import bloques.*;
import dibujos.Dibujo;



public class DibujoTest {
	
	@Test
	public void test01DibujoSeCreoYestaVacio(){
		Dibujo dibujo = new Dibujo();
		assertTrue(dibujo.estaEnBlanco());
	}
	
	@Test
	public void test02DibujoSeCreoYDibuja(){
		Dibujo dibujo = new Dibujo();
		Posicion posicion = new Posicion(0,0);
		Personaje personaje = new Personaje();
		
		personaje.bajarLapiz();
		dibujo.DibujarEn(posicion, personaje);
		
		assertFalse(dibujo.estaEnBlanco());
	}
	
	
	@Test
	public void test03SeCreaDosDibujosYSonIguales(){
		Dibujo dibujo = new Dibujo();
		Dibujo otroDibujo = new Dibujo();
		Posicion posicionUno = new Posicion(0,0);
		Posicion posicionDos = new Posicion(0,1);
		Posicion posicionTres = new Posicion(0,2);
		Personaje personaje = new Personaje();
		Personaje personaje2 = new Personaje();
		
		personaje.bajarLapiz();
		dibujo.DibujarEn(posicionUno, personaje);
		personaje.moverseA(0, 1);
		dibujo.DibujarEn(posicionUno, personaje);
		personaje.moverseA(0, 1);
		dibujo.DibujarEn(posicionDos, personaje);
		
		
		personaje2.bajarLapiz();
		otroDibujo.DibujarEn(posicionUno, personaje2);
		personaje2.moverseA(0, 1);
		otroDibujo.DibujarEn(posicionUno, personaje2);
		personaje2.moverseA(0, 1);
		otroDibujo.DibujarEn(posicionDos, personaje2);
		
		
		
		assertTrue(dibujo.EsIgualA(otroDibujo));
	}

	@Test
	public void test04SeCreaDosDibujosYNoSonIguales(){
		Dibujo dibujo = new Dibujo();
		Dibujo otroDibujo = new Dibujo();
		Posicion posicionUno = new Posicion(0,0);
		Posicion posicionDos = new Posicion(0,1);
		Posicion posicionTres = new Posicion(0,2);
		Posicion posicionCuatro = new Posicion(0,3);
		Personaje personaje = new Personaje();
		Personaje personaje2 = new Personaje();

        personaje.bajarLapiz();
		dibujo.DibujarEn(posicionUno, personaje);
		personaje.moverseA(0, 1);
		dibujo.DibujarEn(posicionUno, personaje);
		personaje.moverseA(0, 2);
		dibujo.DibujarEn(posicionDos, personaje);
		
		
		personaje2.bajarLapiz();
		otroDibujo.DibujarEn(posicionUno, personaje2);
		personaje.moverseA(0, 1);
		otroDibujo.DibujarEn(posicionUno, personaje2);
		personaje.moverseA(0, 3);
		otroDibujo.DibujarEn(posicionDos, personaje2);
		
		assertFalse(dibujo.EsIgualA(otroDibujo));
		
	}

	@Test
    	public void test05PersonajeSeMueveConLapizAbajoYCreaDibujo(){
		Tablero tablero_prueba = new Tablero();
		Personaje personaje_prueba = new Personaje();
		Bloque bajar_lapiz = new BajarLapiz();
       	Bloque mover_derecha = new MoverDerecha();

        tablero_prueba.agregarBloqueAlAlgoritmo(bajar_lapiz);
        tablero_prueba.agregarBloqueAlAlgoritmo(mover_derecha);
		tablero_prueba.ejecutarAlgoritmoCon(personaje_prueba);
		
		assertFalse(tablero_prueba.dibujoVacio());
		
	}
	
	@Test
   	 public void test06PersonajeSeMueveConLapizArribaYNoCreaDibujo(){
		Tablero tablero_prueba = new Tablero();
		Personaje personaje_prueba = new Personaje();
		 Bloque mover_derecha = new MoverDerecha();

		tablero_prueba.agregarBloqueAlAlgoritmo(mover_derecha);
		tablero_prueba.ejecutarAlgoritmoCon(personaje_prueba);
		
		assertTrue(tablero_prueba.dibujoVacio());
    }
	
	
}
