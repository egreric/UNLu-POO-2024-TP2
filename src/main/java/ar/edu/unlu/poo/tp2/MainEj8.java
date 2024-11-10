package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej8.Libro;
import ar.edu.unlu.poo.tp2.ej8.Publicacion;

import java.util.ArrayList;

public class MainEj8 {
    public static void main(String[] args) {
        ArrayList<String> autores1 = new ArrayList<>();
        autores1.add(" Gabriel Garcia Marquez");

        Libro libro1 = new Libro("Cien Años de Soledad", "Editorial ABC", "123456789", "978-3-16-148410-0", 1967, autores1, 3);

        System.out.println(libro1.getNombre());
        System.out.println(libro1.getEditor());
        System.out.println(libro1.getTelefonoContacto());

        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        publicaciones.add(libro1);

        System.out.println(libro1.getEjemplaresDisponibles());
        System.out.println(libro1.getTotalEjemplares());
        System.out.println(libro1.getEjemplaresPrestados());


    }
}
