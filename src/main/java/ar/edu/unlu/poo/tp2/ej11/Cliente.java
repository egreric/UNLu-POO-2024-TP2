package ar.edu.unlu.poo.tp2.ej11;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String dni;
    private ArrayList<Alquiler> alquileres;

    public Cliente(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
        alquileres = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void agregarAlquiler(Alquiler alquiler){
        alquileres.add(alquiler);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        return (this.dni.equals(((Cliente) obj).dni));

    }

    @Override
    public String toString(){
        return "Nombre:" + getNombre() + " - Dni: " + getDni();
    }

    public String informeAlquileres() {
        String listado = "";
        double sumatoria = 0;
        if (!alquileres.isEmpty()){
            for (Alquiler a: alquileres){
                listado += a.toString() + "\n";
                sumatoria += a.getMonto();
            }
        } else {
            return "No hay alquileres que mostrar de este cliente";
        }
        return listado + "\nEl monto total de los alquileres del cliente es: " + sumatoria + "\n";
    }
}
