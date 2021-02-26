package creadores;

import bloques.*;


public class CreadorDeRepetirTresVeces implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new RepetirTresVeces();
	}
	
}