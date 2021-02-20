package algoritmo;

import bloques.Bloques;
import dibujos.SectorDibujo;

public class Tablero {

    private Algoritmo sector_algoritmo;
    private SectorDibujo sector_dibujo;
    private SectorBloques sector_bloques;

    public Tablero(){
        this.sector_algoritmo = new Algoritmo();
        this.sector_dibujo = new SectorDibujo();
        this.sector_bloques = new SectorBloques();
    }

    public void ejecutarAlgoritmoCon(Personaje personaje){
        this.sector_algoritmo.ejecutar(personaje, this.sector_dibujo.getDibujo());
    }

    public void agregarBloqueAlAlgoritmo(Bloques un_bloque){
        this.sector_algoritmo.agregarBloque(un_bloque);
    }
    
    public boolean dibujoVacio(){
        return this.sector_dibujo.getDibujo().estaEnBlanco();
    }
    
    public void reiniciarAlgoritmo(){
        this.sector_algoritmo.borrarBloques();
        this.sector_dibujo.borrarDibujo();
    }
    
}
