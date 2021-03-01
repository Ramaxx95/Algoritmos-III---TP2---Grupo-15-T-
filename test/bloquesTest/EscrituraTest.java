package bloques_test;


import algoritmo.Personaje;
import dibujos.Dibujo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bloques.*;

public class EscrituraTest {

    @Test
    public void test01BajarElLapizLePermiteAlPersonajeEscribirEnElDibujo(){
        Personaje personaje = new Personaje();
        BajarLapiz bloque_bajar_lapiz = new BajarLapiz();
        Dibujo dibujo = new Dibujo();

        bloque_bajar_lapiz.ejecutarBloque(personaje, dibujo);

        assertTrue(personaje.puedeEscribir());
    }

    @Test
    public void test02SubirElLapizParaUnPersonajeRecienCreadoNoAlteraSuEstado(){
        Personaje personaje = new Personaje();
        SubirLapiz bloque_subir_lapiz = new SubirLapiz();
        Dibujo dibujo = new Dibujo();

        bloque_subir_lapiz.ejecutarBloque(personaje, dibujo);

        assertFalse(personaje.puedeEscribir());
    }

    @Test
    public void test03SubirElLapizLuegoDeHaberloBajadoHaceQueElPersonajeNoPuedaDibujar(){
        Personaje personaje = new Personaje();
        BajarLapiz bloque_bajar_lapiz = new BajarLapiz();
        SubirLapiz bloque_subir_lapiz = new SubirLapiz();
        Dibujo dibujo = new Dibujo();

        bloque_bajar_lapiz.ejecutarBloque(personaje, dibujo);
        bloque_subir_lapiz.ejecutarBloque(personaje, dibujo);

        assertFalse(personaje.puedeEscribir());
    }
}
