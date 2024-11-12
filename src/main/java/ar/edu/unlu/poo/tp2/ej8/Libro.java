package ar.edu.unlu.poo.tp2.ej8;

import java.util.ArrayList;

public class Libro extends PublicacionPrestable {
    private String isbn;
    private int anioPublicacion;
    private String autor;

    public Libro(String nombre, String editor, String telefonoContacto, String isbn, int anioPublicacion, String autor, int totalEjemplares){
        super(nombre,editor,telefonoContacto,totalEjemplares);
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getAutores() {
        return autor;
    }

    public boolean equals(Libro libro){
        return (this.isbn.equals(libro.isbn));
    }

    @Override
    public String toString(){
        return "Titulo: "+ getNombre() + " - Autor/es: " + getAutores() + " - Editor: " + getEditor() + " - ISBN: " + getIsbn() + ".\n";
    }

}
