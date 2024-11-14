package ar.edu.unlu.poo.tp2.ej11;

public class Camioneta extends Vehiculo{
    private double pat;
    private double precioPat = 600;

    public Camioneta(String patente, double pat){
        super(patente);
        this.pat = pat;
    }

    @Override
    public double calcularCostoAlquiler(int cantidadDias){
        return super.calcularCostoAlquiler(cantidadDias) + ((pat * precioPat) * cantidadDias);
    }
}
