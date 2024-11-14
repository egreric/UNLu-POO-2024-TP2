
package ar.edu.unlu.poo.tp2.ej10;

import java.time.LocalDate;

public class EmpleadoPorComision extends Empleado {
    protected double montoVentas;
    protected double porcentajeComision; // valores entre 0 y 100

    public EmpleadoPorComision(String nombre, String apellido, String telefono, String cuit, LocalDate fechaNacimiento, double montoVentas, double porcentajeComision){
        super(nombre,apellido,telefono,cuit, fechaNacimiento);
        this.montoVentas = montoVentas;
        this.porcentajeComision = porcentajeComision;
    }

    public void agregarNuevaVenta(double montoVenta){
        this.montoVentas += montoVenta;
    }

    public double getMontoVentas() {
        return montoVentas;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    @Override
    public double calcularSueldo(){
        if (esMesDelCumpleanios()){
            return montoVentas * (porcentajeComision/100.0) + calcularBonoCumpleanios();
        }
        return montoVentas * (porcentajeComision/100.0);
    }

    @Override
    protected double calcularBonoCumpleanios(){
        return (super.calcularBonoCumpleanios() + (montoVentas * 0.05));
    }
}
