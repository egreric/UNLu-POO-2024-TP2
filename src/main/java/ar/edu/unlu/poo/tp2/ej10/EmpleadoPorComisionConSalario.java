package ar.edu.unlu.poo.tp2.ej10;

import java.time.LocalDate;

public class EmpleadoPorComisionConSalario extends EmpleadoPorComision{
    private double salarioBase;

    public EmpleadoPorComisionConSalario(String nombre, String apellido, String telefono, String cuit, LocalDate fechaNacimiento, double montoVentas, double porcentajeComision, double salarioBase){
        super(nombre, apellido, telefono, cuit, fechaNacimiento, montoVentas, porcentajeComision);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public double calcularSueldo(){
        return super.calcularSueldo() + salarioBase;
    }

    @Override
    protected double calcularBonoCumpleanios(){
        return super.calcularBonoCumpleanios() + 1000.0;
    }
}
