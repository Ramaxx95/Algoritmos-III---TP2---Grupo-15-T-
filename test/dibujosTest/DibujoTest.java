package dibujosTest;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import algoritmo.*;
import dibujos.Dibujo;



public class DibujoTest {
	
	@Test
	public void DibujoSeCreoYestaVacio(){
		Dibujo dibujo = new Dibujo();
		Assert.assertTrue(dibujo.estaEnBlanco());
	}
	
	@Test
	public void DibujoSeCreoYDibuja(){
		Dibujo dibujo = new Dibujo();
		Posicion posicion = new Posicion(0,0);
		
		dibujo.DibujarEn(posicion);
		
		Assert.assertFalse(dibujo.estaEnBlanco());
	}
	
	
	@Test
	public void SeCreaDosDibujosYSonIguales(){
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
	public void SeCreaDosDibujosYNoSonIguales(){
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
	
	
}