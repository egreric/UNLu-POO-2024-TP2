package ar.edu.unlu.poo.tp2.ej11;

public class AutoPasajero extends Vehiculo{

    protected int cantidadAsientos;
    protected double precioPorAsiento = 300;

    public AutoPasajero(String patente, int cantidadAsientos){
        super(patente);
        this.cantidadAsientos = cantidadAsientos;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    @Override
    public double calcularCostoAlquiler(int cantidadDias){
        return super.calcularCostoAlquiler(cantidadDias) + ((precioPorAsiento * cantidadAsientos) * cantidadDias);
    }
}
