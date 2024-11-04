package ar.edu.unlu.poo.tp2.ej6;

public class Vendedor {
    private String nombre;
    private String dni;

    public Vendedor(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + " - DNI: " + getDni();
    }


}
