package algoritmo;

import bloques.Bloque;
import bloques.SectorBloques;
import dibujos.Dibujo;
import dibujos.SectorDibujo;

import java.util.ArrayList;

public class Tablero {

    private Algoritmo sector_algoritmo;
    private SectorDibujo sector_dibujo;
    private SectorBloques sector_bloques;
    private ArrayList<Bloque> algoritmo_guardado;

    public Tablero(){
        this.sector_algoritmo = new Algoritmo();
        this.sector_dibujo = new SectorDibujo();
        this.sector_bloques = new SectorBloques();
        this.algoritmo_guardado = new ArrayList<>();
    }

    public void ejecutarAlgoritmoCon(Personaje personaje){
        this.sector_algoritmo.ejecutar(personaje, this.sector_dibujo.getDibujo());
    }

    public void agregarBloqueAlAlgoritmo(Bloque un_bloque){
        this.sector_algoritmo.agregarBloque(un_bloque);
    }
    
    public boolean dibujoVacio(){
        return this.sector_dibujo.getDibujo().estaEnBlanco();
    }
    
    public void reiniciarAlgoritmo(){
        this.sector_algoritmo.borrarBloques();
        this.borrarDibujo();
    }
    
    public void borrarDibujo() {
    	this.sector_dibujo.borrarDibujo();
    }
    
    public void guardarAlgoritmoActual(){
        this.sector_algoritmo.getAlgoritmo().forEach(bloque ->this.algoritmo_guardado.add(bloque));
    }

    public Algoritmo darAlgoritmo(){
        return this.sector_algoritmo;
    }

	public Dibujo mostrarDibujo() {
		return sector_dibujo.getDibujo();
	}
    
}
