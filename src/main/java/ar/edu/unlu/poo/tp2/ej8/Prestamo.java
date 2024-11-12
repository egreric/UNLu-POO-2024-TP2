package ar.edu.unlu.poo.tp2.ej8;

import java.time.LocalDate;

public class Prestamo {

    private Socio socio;
    private PublicacionPrestable publicacionPrestable;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Socio socio, PublicacionPrestable publicacionPrestable){
        this.socio = socio;
        this.publicacionPrestable = publicacionPrestable;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public Socio getSocio() {
        return socio;
    }

    public PublicacionPrestable getPublicacionPrestable() {
        return publicacionPrestable;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void registrarDevolucion(){
        this.fechaDevolucion = LocalDate.now();
    }

    @Override
    public String toString(){
        String s = "Libro: " + getPublicacionPrestable().getNombre() + " - Prestado a: " + getSocio().getNombre() + " (DNI: " + getSocio().getDni() + "), el dia: " + getFechaPrestamo();
        if (getFechaDevolucion() == null){
            s += " (Sin devolver)" + "\n";
        } else {
            s += " (Devuelto el dia: " + getFechaDevolucion() + ")\n";
        }
        return s;
    }
}
