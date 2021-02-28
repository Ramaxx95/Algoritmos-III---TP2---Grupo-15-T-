package creadores;

import bloques.*;


public class CreadorDeMoverDerecha implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new MoverDerecha();
	}
	
}