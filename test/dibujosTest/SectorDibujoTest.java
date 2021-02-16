package dibujosTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import algoritmo.*;
import dibujos.*;


public class SectorDibujoTest {

	
	@Test
	public void test01SectorDibujoSeCreoYpuedeDibujar(){
		SectorDibujo sectorDi = new SectorDibujo();
		Assert.assertTrue(sectorDi.PuedeDibujar() );
	}
	
	
	@Test
	public void test02SectorDibujoSeCreoYDibujaCorrectamente(){
		SectorDibujo sectorDi = new SectorDibujo();
		Personaje personaje = new Personaje();
		Posicion posicion_1 = new Posicion(5,5);
        	Posicion posicion_2 = new Posicion(5,6);
		
		personaje.bajarLapiz();
        	sectorDi.ActualizarPosicion(personaje);
        	personaje.moverseA(0, 1);
        	sectorDi.ActualizarPosicion(personaje);
		
		
		Dibujo dibujo = new Dibujo();
		dibujo.DibujarEn(posicion_1), personaje);
		dibujo.DibujarEn(posicion_2, personaje);
		Dibujo otroDibujo = sectorDi.getDibujo();
		
		assertTrue(dibujo.EsIgualA(otroDibujo) );
	}
	
}
