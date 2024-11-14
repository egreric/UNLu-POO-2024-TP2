package ar.edu.unlu.poo.tp2.ej11;

import ar.edu.unlu.poo.tp2.ej11.Vehiculo;

public class Presupuesto {
    private Vehiculo vehiculo;
    private int diasAlquiler;
    private double montoFinal;

    public Presupuesto(Vehiculo vehiculo, int diasAlquiler){
        this.vehiculo = vehiculo;
        this.diasAlquiler = diasAlquiler;
        this.montoFinal = vehiculo.calcularCostoAlquiler(diasAlquiler);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public double getMontoFinal() {
        return montoFinal;
    }
}
