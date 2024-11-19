package ar.edu.unlu.poo.tp2.ej13.metodoOriginal;

import java.util.ArrayList;

public class Vuelo {
    private ArrayList<Persona> miembrosVuelo;

    public Vuelo() {
        this.miembrosVuelo = new ArrayList<>();
    }

    public void agregarMiembro(Persona persona){
        miembrosVuelo.add(persona);
    }
}
