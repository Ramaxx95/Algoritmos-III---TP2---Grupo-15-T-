package main_test;

import algoritmo.Personaje;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01PorDefectoElPersonajeSeCreaConElLapizArriba(){
        Personaje personaje_prueba = new Personaje();
        assertFalse(personaje_prueba.puedeEscribir());
    }

    @Test
    public void test02MoverseUnaPosicionArribaCambiaLaPosicionInicial(){
        Personaje personaje_prueba = new Personaje();
        personaje_prueba.moverseA(0, 1);
        assertEquals(6, personaje_prueba.getPosicion().get(1));
    }

    @Test
    public void test03MoverseUnaPosicionALaIzquierdaCambiaLaPosicionInicial(){
        Personaje personaje_prueba = new Personaje();
        personaje_prueba.moverseA(-1, 0);
        assertEquals(4, personaje_prueba.getPosicion().get(0));
    }

    @Test
    public void test04BajarElLapizPermiteAlPersonajeEscribir(){
        Personaje personaje_prueba = new Personaje();
        personaje_prueba.bajarLapiz();
        assertTrue(personaje_prueba.puedeEscribir());
    }

    @Test
    public void test05LevantarElLapizNoCambiaSuEstadoAnteriorSiYaLoTeniaArriba(){
        Personaje personaje_prueba = new Personaje();
        personaje_prueba.levantarLapiz();
        assertFalse(personaje_prueba.puedeEscribir());
    }

}
