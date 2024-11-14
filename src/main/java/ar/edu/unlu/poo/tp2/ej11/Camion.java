package ar.edu.unlu.poo.tp2.ej11;

public class Camion extends Vehiculo{

    public Camion(String patente){
        super(patente);
        this.precioBase = 100000;
    }

    @Override
    public double calcularCostoAlquiler(int cantidadDias){
        double precioBase = this.precioBase;
        if (cantidadDias > 30){
            precioBase = 75000;
        }
        return precioBase * cantidadDias;
    }
}
