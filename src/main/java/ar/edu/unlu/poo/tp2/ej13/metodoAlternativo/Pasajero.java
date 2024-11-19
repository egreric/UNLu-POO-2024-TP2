package ar.edu.unlu.poo.tp2.ej13.metodoAlternativo;

public class Pasajero extends Rol {
    private int numeroPasajero;

    public Pasajero(int numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }

    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    @Override
    public String toString(){
        return "Num. Pasajero: " + numeroPasajero;
    }

}
