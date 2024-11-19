package ar.edu.unlu.poo.tp2.ej14;

import java.time.LocalDate;

public class Compra {
    private PaqueteTurismo paqueteTurismo;
    private double monto;
    private LocalDate fecha;

    public Compra(PaqueteTurismo paqueteTurismo, double monto, LocalDate fecha) {
        this.paqueteTurismo = paqueteTurismo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public PaqueteTurismo paqueteTurismo(){ return paqueteTurismo; }
}
