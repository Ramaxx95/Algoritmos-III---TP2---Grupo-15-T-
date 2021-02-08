package dibujosTest;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import algoritmo.*;
import dibujos.Dibujo;



public class DibujoTest {
	
	@Test
	public void test01DibujoSeCreoYestaVacio(){
		Dibujo dibujo = new Dibujo();
		Assert.assertTrue(dibujo.estaEnBlanco());
	}
	
	@Test
	public void test02DibujoSeCreoYDibuja(){
		Dibujo dibujo = new Dibujo();
		Posicion posicion = new Posicion(0,0);
		
		dibujo.DibujarEn(posicion);
		
		Assert.assertFalse(dibujo.estaEnBlanco());
	}
	
	
	@Test
	public void test03SeCreaDosDibujosYSonIguales(){
		Dibujo dibujo = new Dibujo();
		Dibujo otroDibujo = new Dibujo();
		Posicion posicionUno = new Posicion(0,0);
		Posicion posicionDos = new Posicion(0,1);
		Posicion posicionTres = new Posicion(0,2);
		
		dibujo.DibujarEn(posicionUno);
		otroDibujo.DibujarEn(posicionUno);
		
		dibujo.DibujarEn(posicionDos);
		otroDibujo.DibujarEn(posicionDos);
		
		dibujo.DibujarEn(posicionTres);
		otroDibujo.DibujarEn(posicionTres);
		
		Assert.assertTrue(dibujo.EsIgualA(otroDibujo));
	}
	
	@Test
	public void test04SeCreaDosDibujosYNoSonIguales(){
		Dibujo dibujo = new Dibujo();
		Dibujo otroDibujo = new Dibujo();
		Posicion posicionUno = new Posicion(0,0);
		Posicion posicionDos = new Posicion(0,1);
		Posicion posicionTres = new Posicion(0,2);
		Posicion posicionCuatro = new Posicion(0,3);
		
		dibujo.DibujarEn(posicionUno);
		otroDibujo.DibujarEn(posicionUno);
		
		dibujo.DibujarEn(posicionDos);
		otroDibujo.DibujarEn(posicionDos);
		
		dibujo.DibujarEn(posicionTres);
		otroDibujo.DibujarEn(posicionCuatro);
		
		Assert.assertFalse(dibujo.EsIgualA(otroDibujo));
	}

	@Test
    public void test05PersonajeSeMueveConLapizAbajoYCreaDibujo(){
		Tablero tablero_prueba = new Tablero();
		Personaje personaje_prueba = new Personaje();

        personaje_prueba.bajarLapiz();
		personaje_prueba.moverseA(1, 0);
		tablero_prueba.ejecutarAlgoritmoCon(personaje_prueba);
		
		Assert.assertFalse(tablero_prueba.getDibujo().estaEnBlanco());
	}
	
	@Test
    public void test06PersonajeSeMueveConLapizArribaYNoCreaDibujo(){
		Tablero tablero_prueba = new Tablero();
		Personaje personaje_prueba = new Personaje();

		personaje_prueba.moverseA(1, 0);
		tablero_prueba.ejecutarAlgoritmoCon(personaje_prueba);
		
		Assert.assertTrue(tablero_prueba.getDibujo().estaEnBlanco());
    }
	
	
}