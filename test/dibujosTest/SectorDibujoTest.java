package dibujosTest;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import algoritmo.Personaje;
import algoritmo.Posicion;
import bloques.MoverArriba;
import dibujos.*;


public class SectorDibujoTest {

	
	@Test
	public void sectorDibujoSeCreoYpuedeDibujar(){
		SectorDibujo sectorDi = new SectorDibujo();
		Assert.assertTrue(sectorDi.PuedeDibujar() );
	}
	
	
	@Test
	public void sectorDibujoSeCreoYDibujaCorrectamente(){
		SectorDibujo sectorDi = new SectorDibujo();
		Personaje personaje = new Personaje();
		personaje.moverseA(0, 1);
		
		sectorDi.ActualizarPosicion(personaje);
		
		
		Dibujo dibujo = new Dibujo();
		dibujo.DibujarEn(new Posicion(5,5));
		dibujo.DibujarEn(new Posicion(6,5));
		Dibujo otroDibujo = sectorDi.getDibujo();
		
		Assert.assertTrue(dibujo.EsIgualA(otroDibujo) );
	}
	
}