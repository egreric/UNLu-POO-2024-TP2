package ar.edu.unlu.poo.tp2.ej10;

import java.time.LocalDate;

public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String cuit;
    protected LocalDate fechaNacimiento;

    public Empleado(String nombre, String apellido, String telefono, String cuit, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cuit = cuit;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCuit() {
        return cuit;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    protected boolean esMesDelCumpleanios(){
        return (fechaNacimiento.getMonth().equals(LocalDate.now().getMonth()));
    }

    protected double calcularBonoCumpleanios(){
        if (esMesDelCumpleanios()){
            return 2000;
        }
        return 0.0;
    }


    public abstract double calcularSueldo();
}
