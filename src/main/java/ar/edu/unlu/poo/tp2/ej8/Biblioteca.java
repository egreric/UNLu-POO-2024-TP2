package ar.edu.unlu.poo.tp2.ej8;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.socios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(String titulo, String editorial, String telefonoContacto, String isbn, int anioPublicacion, ArrayList<String> autores, int totalEjemplares){
        libros.add(new Libro(titulo, editorial, telefonoContacto, isbn, anioPublicacion, autores, totalEjemplares));
    }

    public void agregarSocio(String nombre, String dni){
        socios.add(new Socio(nombre, dni));
    }

    public void prestarLibro(int idLibro, int idSocio){
        Libro libro = buscarLibro(idLibro);
        Socio socio = buscarSocio(idSocio);
        if (libro != null & socio != null){
            prestamos.add(new Prestamo(buscarSocio(idSocio), buscarLibro(idSocio)));
        }
    }

    public void devolverLibro(int idLibro, int idSocio){
        Libro libro = buscarLibro(idLibro);
        Socio socio = buscarSocio(idSocio);
        if (libro != null & socio != null){
            Prestamo prestamoADevolver = buscarPrestamo(libro,socio);
            if (prestamoADevolver != null){
                prestamoADevolver.registrarDevolucion();
            }
        }
    }

    private Prestamo buscarPrestamo(Libro libro, Socio socio) {
        for (Prestamo p:prestamos){
            if (p.getSocio().equals(socio) && p.getPublicacionPrestable().equals(libro)){
                return p;
            }
        }
        return null;
    }


    private Libro buscarLibro(int idLibro) {
        if(!libros.isEmpty() && idLibro >= 1 && idLibro <= libros.size()){
            return libros.get(idLibro-1);
        }
        return null;
    }

    private Socio buscarSocio(int idSocio) {
        if(!socios.isEmpty() && idSocio >= 1 && idSocio <= socios.size()){
            return socios.get(idSocio-1);
        }
        return null;
    }


}
