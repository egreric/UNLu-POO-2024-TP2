package ar.edu.unlu.poo.tp2.ej13.metodoOriginal;

public abstract class Persona {
    protected String nombre;
    protected String telefono;
    protected String direccion;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + " - Numero Tel.: " + telefono + " - Direccion: " + direccion;
    }
}
