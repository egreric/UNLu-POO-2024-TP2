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

    public void agregarLibro(String titulo, String editorial, String telefonoContacto, String isbn, int anioPublicacion, String autor, int totalEjemplares){
        libros.add(new Libro(titulo, editorial, telefonoContacto, isbn, anioPublicacion, autor, totalEjemplares));
    }

    public void agregarSocio(String nombre, String dni){
        socios.add(new Socio(nombre, dni));
    }

    public void prestarLibro(int idLibro, int idSocio){
        Libro libro = buscarLibro(idLibro);
        Socio socio = buscarSocio(idSocio);
        if (libro != null && socio != null && libro.getEjemplaresDisponibles() > 0){
            libro.prestar();
            prestamos.add(new Prestamo(socio, libro));
        }
    }

    public void devolverLibro(int idLibro, int idSocio){
        Libro libro = buscarLibro(idLibro);
        Socio socio = buscarSocio(idSocio);
        if (libro != null & socio != null){
            Prestamo prestamoADevolver = buscarPrestamo(libro,socio);
            if (prestamoADevolver != null){
                libro.devolver();
                prestamoADevolver.registrarDevolucion();
            }
        }
    }

    private Prestamo buscarPrestamo(Libro libro, Socio socio) {
        for (Prestamo p:prestamos){
            if (p.getSocio().equals(socio) && p.getPublicacionPrestable().equals(libro) && p.getFechaDevolucion() == null){
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

    public String mostrarListadoSocios(){
        String listado = "----- LISTADO DE SOCIOS -----\n";
        if (!socios.isEmpty()){
            for (int i = 0; i < socios.size(); i++){
                listado += (i+1) + ". Nombre: " + socios.get(i).getNombre() + " DNI: " + socios.get(i).getDni() + "\n";
            }
        }
        return listado;
    }

    public String mostrarListadoLibros(){
        String listado = "------ LISTADO DE LIBROS ------\n";
        if (!libros.isEmpty()){
            for (int i = 0; i < libros.size(); i++){
                listado += (i+1) + ". Titulo: "+ libros.get(i).getNombre() + " - Autor/es: " + libros.get(i).getAutores() + " - Editor: " + libros.get(i).editor +
                " - " + libros.get(i).getEjemplaresDisponibles() + " Ejemplares disponibles (" + libros.get(i).getEjemplaresPrestados() + " prestados)." + "\n";
            }
        }
        return listado;
    }

    public int getCantidadLibros() {
        return libros.size();
    }

    public int getCantidadSocios() {
        return socios.size();
    }

    public String mostrarLibroPorId(int idLibro) {
        Libro libroAMostrar = buscarLibro(idLibro);
        if (libroAMostrar != null){
            return "Titulo: "+ libroAMostrar.getNombre() + " - Autor/es: " + libroAMostrar.getAutores() + " - Editor: " + libroAMostrar.getEditor() + ".\n";
        }
        return "LIBRO NO EXISTENTE.";
    }

    public String mostrarSocioPorId(int idSocio) {
        Socio socioAMostrar = buscarSocio(idSocio);
        if (socioAMostrar != null){
            return "Nombre: "+ socioAMostrar.getNombre() + " - DNI: " + socioAMostrar.getDni() + ".\n";
        }
        return "SOCIO NO EXISTENTE.";
    }


    // Muestro tanto prestamos devueltos como sin devolver
    public String mostrarListadoPrestamos() {
        String listado = "------ LISTADO DE PRESTAMOS ------\n";
        if (!prestamos.isEmpty()){
            for (int i = 0; i < prestamos.size() ;i++) {
                listado += (i+1) + ". " + prestamos.get(i).toString();
            }
        } else {
            return "NO SE HAN REALIZADO PRESTAMOS";
        }
        return listado;
    }

    public boolean existePrestamo(int idLibro, int idSocio) {
        Libro libro = buscarLibro(idLibro);
        Socio socio = buscarSocio(idSocio);
        if (libro != null & socio != null){
            if (buscarPrestamo(libro,socio) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean quedanEjemplaresParaPrestar(int idLibro) {
        Libro libroBuscado = buscarLibro(idLibro);
        if (libroBuscado != null){
            return libroBuscado.getEjemplaresDisponibles() > 0;
        }
        return false;
    }
}
