package bloques;

import java.util.ArrayList;

import algoritmo.Personaje;

public abstract class Repeticion implements Bloques{
	
    protected Bloques bloque;
    
    public Repeticion(){
        this.bloque = new BloqueVacio();
    }

    public void agregarBloque(Bloques un_bloque){
        this.bloque = un_bloque;
    }

    @Override
    public void ejecutarBloque(Personaje un_personaje) {
        this.repetirBloque(un_personaje);
    }

    public abstract void repetirBloque(Personaje un_personaje);
    
	
	/*
	protected ArrayList<Bloques> bloques;
	
	public Repeticion(){
		bloques = new ArrayList<>();
	}
	
	public void agregarBloque(Bloques un_bloque){
        this.bloques.add(un_bloque);
    }
	
	@Override
    public void ejecutarBloque(Personaje un_personaje) {
        this.repetirBloque(un_personaje);
    }
	
	public abstract void repetirBloque(Personaje un_personaje);
	*/
}
