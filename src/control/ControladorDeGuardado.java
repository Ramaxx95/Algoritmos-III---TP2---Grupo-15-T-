package control;


import creadores.CreadorDeBloques;

public abstract class ControladorDeGuardado {

	public abstract void a�adirBloque(CreadorDeBloques creadorDeBloques, String img);
	public abstract void a�adirBloqueContenedor(CreadorDeBloques creadorDeBloques, String img);
	public abstract void finalizarContenedor();
}