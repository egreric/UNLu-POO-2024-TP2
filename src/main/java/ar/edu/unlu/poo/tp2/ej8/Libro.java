package ar.edu.unlu.poo.tp2.ej8;

import java.util.ArrayList;

public class Libro extends PublicacionPrestable {
    private String isbn;
    private int anioPublicacion;
    private ArrayList<String> autores;

    public Libro(String nombre, String editor, String telefonoContacto, String isbn, int anioPublicacion, ArrayList<String> autores, int totalEjemplares){
        super(nombre,editor,telefonoContacto,totalEjemplares);
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.autores = autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public boolean equals(Libro libro){
        return (this.isbn.equals(libro.isbn));
    }



}
