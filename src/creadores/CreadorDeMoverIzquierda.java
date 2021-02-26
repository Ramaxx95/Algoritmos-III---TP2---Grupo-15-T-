package creadores;

import bloques.*;


public class CreadorDeMoverIzquierda implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new MoverIzquierda();
	}
	
}