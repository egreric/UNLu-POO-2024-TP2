package ar.edu.unlu.poo.tp2.ej14;

public abstract class Proveedor {
    protected String nombre;
    protected String telefono;
    protected double precioBase;

    public Proveedor(String nombre, String telefono, double precioBase) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public abstract double calcularMontoExtra(int maxClientes);
    public double calcularTotal(int maxClientes){
        return getPrecioBase() + calcularMontoExtra(maxClientes);
    }


}
