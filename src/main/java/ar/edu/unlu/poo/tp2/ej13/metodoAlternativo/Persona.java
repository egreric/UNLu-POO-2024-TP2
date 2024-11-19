package ar.edu.unlu.poo.tp2.ej13.metodoAlternativo;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String telefono;
    private String direccion;
    private ArrayList<Rol> roles;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.roles = new ArrayList<>();
    }
    public void agregarRol(Rol rol){
        roles.add(rol);
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

    private String mostrarRoles(){
        String s = "";
        if (roles != null){
            for (Rol r: roles){
                s += r.toString() + "\n";
            }
        }
        return s;
    }
    @Override
    public String toString(){
        return "Nombre: " + nombre + " - Numero Tel.: " + telefono + " - Direccion: " + direccion + "\nRol/es: " + mostrarRoles();
    }
}
