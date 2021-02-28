package creadores;

import bloques.*;


public class CreadorDeMoverArriba implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new MoverArriba();
	}
	
}