package ar.edu.unlu.poo.tp2.ej10;

import java.time.LocalDate;

public class EmpleadoAsalariado extends Empleado{
    private double salarioBase;

    public EmpleadoAsalariado(String nombre, String apellido, String telefono, String cuit, LocalDate fechaNacimiento, double salario){
        super(nombre,apellido,telefono,cuit, fechaNacimiento);
        this.salarioBase = salario;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public double calcularSueldo(){
        if (esMesDelCumpleanios()){
            return salarioBase + calcularBonoCumpleanios();
        }
        return salarioBase;
    }

    @Override
    protected double calcularBonoCumpleanios(){
        return super.calcularBonoCumpleanios() + 1000.0;

    }
}
