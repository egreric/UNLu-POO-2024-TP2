package ar.edu.unlu.poo.tp2.ej2;

public class MedioTransporte {
    private String nombre;
    private String telefono;
    private double precio;
    private TipoTransporte tipoTransporte;

    public MedioTransporte(String nombre, String telefono, double precio, TipoTransporte tipoTransporte) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.precio = precio;
        this.tipoTransporte = tipoTransporte;
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

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }
}
