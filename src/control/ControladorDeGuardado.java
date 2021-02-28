package control;


import creadores.CreadorDeBloques;

public abstract class ControladorDeGuardado {

	public abstract void añadirBloque(CreadorDeBloques creadorDeBloques, String img);
	public abstract void añadirBloqueContenedor(CreadorDeBloques creadorDeBloques, String img);
	public abstract void finalizarContenedor();
}