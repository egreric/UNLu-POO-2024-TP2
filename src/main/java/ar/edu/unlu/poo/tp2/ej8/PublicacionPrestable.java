package ar.edu.unlu.poo.tp2.ej8;

public abstract class PublicacionPrestable extends Publicacion{
    protected int totalEjemplares;
    protected int ejemplaresDisponibles;

    public PublicacionPrestable(String nombre, String editor, String telefonoContacto, int totalEjemplares){
        super(nombre,editor,telefonoContacto);
        this.totalEjemplares = totalEjemplares;
        this.ejemplaresDisponibles = totalEjemplares;
    }

    public int getTotalEjemplares() {
        return totalEjemplares;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void prestar(){
        if (this.ejemplaresDisponibles > 0){
            ejemplaresDisponibles--;
        }
    }

    public void devolver(){
        if (ejemplaresDisponibles < totalEjemplares){
            ejemplaresDisponibles++;
        }
    }

    public int getEjemplaresPrestados(){
        return totalEjemplares-ejemplaresDisponibles;
    }


}
