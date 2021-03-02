package algoritmo;

import bloques.Bloque;
import bloques.SectorBloques;
import dibujos.Dibujo;

import java.util.ArrayList;

public class Tablero {

    private Algoritmo sector_algoritmo;
    private Dibujo dibujo;
    private ArrayList<Bloque> algoritmo_guardado;

    public Tablero(){
        this.sector_algoritmo = new Algoritmo();
        this.dibujo = new Dibujo();
        this.algoritmo_guardado = new ArrayList<>();
    }

    public void ejecutarAlgoritmoCon(Personaje personaje){
        this.sector_algoritmo.ejecutar(personaje, this.dibujo);
    }

    public void agregarBloqueAlAlgoritmo(Bloque un_bloque){
        this.sector_algoritmo.agregarBloque(un_bloque);
    }
    
    public boolean dibujoVacio(){
        return this.dibujo.estaEnBlanco();
    }
    
    public void reiniciarAlgoritmo(){
        this.sector_algoritmo.borrarBloques();
        this.borrarDibujo();
    }
    
    public void borrarDibujo() {
    	this.dibujo.borrar();;
    }
    
    public void guardarAlgoritmoActual(){
        this.sector_algoritmo.getAlgoritmo().forEach(bloque ->this.algoritmo_guardado.add(bloque));
    }

    public Algoritmo darAlgoritmo(){
        return this.sector_algoritmo;
    }
	
    public ArrayList<Bloque> darAlgoritmoGuardado(){
    	ArrayList<Bloque> algoritmo_guardadoAux = this.algoritmo_guardado;
    	this.algoritmo_guardado = new ArrayList<>();
        return algoritmo_guardadoAux;
    }

	public Dibujo mostrarDibujo() {
		return this.dibujo;
	}
    
}
