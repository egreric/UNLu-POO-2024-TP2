package ar.edu.unlu.poo.tp2.ej8;

public class Socio {
    private String nombre;
    private String dni;

    public Socio(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public boolean equals(Socio socio){
        return this.dni.equals(socio.dni);
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + " DNI: " + getDni() ;
    }
}
