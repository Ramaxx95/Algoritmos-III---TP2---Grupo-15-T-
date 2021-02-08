package algoritmo;

import bloques.Bloques;
import dibujos.Dibujo;

public class Tablero {

    private Algoritmo sector_algoritmo;
    private Dibujo sector_dibujo;
    private Bloques sector_bloques;

    public Tablero(){
        this.sector_algoritmo = new Algoritmo();
        this.sector_dibujo = new Dibujo();
    }

    public void ejecutarAlgoritmoCon(Personaje personaje){
        this.sector_algoritmo.ejecutar(personaje);
    }

    public void agregarBloqueAlAlgoritmo(Bloques un_bloque){
        this.sector_algoritmo.agregarBloque(un_bloque);
    }
}
