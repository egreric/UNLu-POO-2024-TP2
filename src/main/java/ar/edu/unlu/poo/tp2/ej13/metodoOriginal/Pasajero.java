package ar.edu.unlu.poo.tp2.ej13.metodoOriginal;

public class Pasajero extends Persona{
    private int numeroPasajero;

    public Pasajero(String nombre, String telefono, String direccion, int numeroPasajero) {
        super(nombre, telefono, direccion);
        this.numeroPasajero = numeroPasajero;
    }

    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    @Override
    public String toString(){
        return super.toString() + " - Num. Pasajero: " + numeroPasajero;
    }

}
