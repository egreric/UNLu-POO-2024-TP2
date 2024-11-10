package ar.edu.unlu.poo.tp2.ej8;

public class Tesis extends Publicacion{
    private String autor;
    private int anioPublicacion;
    private int mesPublicacion;

    public Tesis(String nombre, String editor, String telefonoContacto, String autor, int anioPublicacion, int mesPublicacion){
        super(nombre, editor, telefonoContacto);
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.mesPublicacion = mesPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getMesPublicacion() {
        return mesPublicacion;
    }
}
