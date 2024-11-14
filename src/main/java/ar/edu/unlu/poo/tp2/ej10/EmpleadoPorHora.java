package ar.edu.unlu.poo.tp2.ej10;

import java.time.LocalDate;

public class EmpleadoPorHora extends Empleado{
    private double valorHora;
    private int horasTrabajadas;

    public EmpleadoPorHora(String nombre, String apellido, String telefono, String cuit, LocalDate fechaNacimiento, double valorHora, int horasTrabajadas){
        super(nombre, apellido, telefono, cuit, fechaNacimiento);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    @Override
    public double calcularSueldo(){
        int minimoHorasParaIngresoExtra = 40;
        double porcentajeIngresoExtra = 0.2;
        double sueldo = (valorHora * horasTrabajadas);

        if (horasTrabajadas > minimoHorasParaIngresoExtra) {
            sueldo *= (1 + porcentajeIngresoExtra);
        }

        if (esMesDelCumpleanios()){
            return sueldo + calcularBonoCumpleanios();
        }
        return sueldo;
    }
}
