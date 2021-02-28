package creadores;

import bloques.*;


public class CreadorDeRepetirTresVeces implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new RepetirTresVeces();
	}
	
}