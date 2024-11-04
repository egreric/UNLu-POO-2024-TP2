package ar.edu.unlu.poo.tp2.ej2;

public class Excursion {
    private String descripcion;
    private double precio;

    public Excursion(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

}
