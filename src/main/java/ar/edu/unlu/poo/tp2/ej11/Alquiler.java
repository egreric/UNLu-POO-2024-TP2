package ar.edu.unlu.poo.tp2.ej11;

import ar.edu.unlu.poo.tp2.ej11.Cliente;
import ar.edu.unlu.poo.tp2.ej11.Presupuesto;

import java.time.LocalDate;

public class Alquiler {
    private Cliente cliente;
    private Presupuesto presupuesto;
    private double monto;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    public Alquiler(Cliente cliente, Presupuesto presupuesto, LocalDate fechaInicio){
        this.cliente = cliente;
        this.presupuesto = presupuesto;
        this.monto = presupuesto.getMontoFinal();
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaInicio.plusDays(presupuesto.getDiasAlquiler());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    @Override
    public String toString(){
        return getPresupuesto().getVehiculo().toString() + " - Fecha inicio: " + getFechaInicio() + " - Dias alquilados: " + getPresupuesto().getDiasAlquiler() + " - Monto: " + getMonto();
    }
}
