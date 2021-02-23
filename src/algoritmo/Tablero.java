package algoritmo;

import bloques.Bloques;
import bloques.SectorBloques;
import dibujos.Dibujo;
import dibujos.SectorDibujo;

import java.util.ArrayList;

public class Tablero {

    private Algoritmo sector_algoritmo;
    private SectorDibujo sector_dibujo;
    private SectorBloques sector_bloques;
    private ArrayList<Bloques> algoritmo_guardado;

    public Tablero(){
        this.sector_algoritmo = new Algoritmo();
        this.sector_dibujo = new SectorDibujo();
        this.sector_bloques = new SectorBloques();
        this.algoritmo_guardado = new ArrayList<>();
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
        this.borrarDibujo();
    }
    
    public void borrarDibujo() {
    	this.sector_dibujo.borrarDibujo();
    }
    
    public void guardarAlgoritmoActual(){
        this.sector_algoritmo.getAlgoritmo().forEach(bloque ->this.algoritmo_guardado.add(bloque));
        //faltaria hacer que sector_bloques cree un bloque de AlgoritmoPersonalizado para poder usar
    }

    public Algoritmo darAlgoritmo(){
        return this.sector_algoritmo;
    }

	public void seleccionarBloqueAlAlgoritmo(int unaPosicion) {
		Bloques unBloque = sector_bloques.seleccionarBloque(unaPosicion);
		this.agregarBloqueAlAlgoritmo(unBloque);
	}

	public Dibujo mostrarDibujo() {
		return sector_dibujo.getDibujo();
	}
    
}
