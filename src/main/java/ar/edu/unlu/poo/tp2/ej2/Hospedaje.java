package ar.edu.unlu.poo.tp2.ej2;

public class Hospedaje {
    private String nombre;
    private String telefono;
    private double precio;
    private TipoHospedaje tipoHospedaje;

    public Hospedaje(String nombre, String telefono, double precio, TipoHospedaje tipoHospedaje) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.precio = precio;
        this.tipoHospedaje = tipoHospedaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoHospedaje getTipoHospedaje() {
        return tipoHospedaje;
    }
}
