package ar.edu.unlu.poo.tp2.ej6y7;

public class Cliente {
    private String nombre;
    private String dni;

    public Cliente(String nombre, String dni){
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

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;

        return this.getNombre().equals(cliente.getNombre()) && this.getDni().equals(cliente.getDni());
    }
}
