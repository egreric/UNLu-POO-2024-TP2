package ar.edu.unlu.poo.tp2.ej10;

import java.time.LocalDate;

public class Pasante extends Empleado{
    public Pasante(String nombre, String apellido, String telefono, String cuit, LocalDate fechaNacimiento){
        super(nombre, apellido, telefono, cuit, fechaNacimiento);
    }

    @Override
    public double calcularSueldo(){
        return calcularBonoCumpleanios();
    }
    
}
