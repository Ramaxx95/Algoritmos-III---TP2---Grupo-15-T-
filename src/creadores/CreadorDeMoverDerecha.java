package creadores;

import bloques.*;


public class CreadorDeMoverDerecha implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new MoverDerecha();
	}
	
}