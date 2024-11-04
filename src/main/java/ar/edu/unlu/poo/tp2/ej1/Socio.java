package ar.edu.unlu.poo.tp2.ej1;

import java.time.LocalDate;

public class Socio {
    private String nombre;
    private String direccion;
    private String email;
    private LocalDate fechaInscripcion;
    private TipoSuscripcion tipoSuscripcion;

    public Socio(String nombre, String direccion, String email, LocalDate fechaInscripcion, TipoSuscripcion tipoSuscripcion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaInscripcion = fechaInscripcion;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipoSuscripcion(TipoSuscripcion tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }
}
