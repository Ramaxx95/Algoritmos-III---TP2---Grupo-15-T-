package algoritmo;

public abstract class Repeticion implements Bloques{

    protected Bloques bloque;

    public Repeticion(){
        this.bloque = new BloqueVacio();
    }

    public void agregarBloque(Bloques un_bloque){
        this.bloque = un_bloque;
    }

    @Override
    public void ejecutarBloque(Personaje un_personaje) {
        this.repetirBloque(un_personaje);
    }

    public abstract void repetirBloque(Personaje un_personaje);
}
