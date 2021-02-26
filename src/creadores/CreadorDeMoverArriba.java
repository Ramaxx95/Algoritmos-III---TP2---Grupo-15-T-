package creadores;

import bloques.*;


public class CreadorDeMoverArriba implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new MoverArriba();
	}
	
}