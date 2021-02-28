package creadores;

import bloques.*;


public class CreadorDeMoverIzquierda implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new MoverIzquierda();
	}
	
}