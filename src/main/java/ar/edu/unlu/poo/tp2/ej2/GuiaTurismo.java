package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class GuiaTurismo {
    private String nombre;
    private String telefono;
    private double precio;
    private ArrayList<Excursion> listadoExcursiones;

    public GuiaTurismo(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.precio = 0;
        listadoExcursiones = new ArrayList<>();
    }

    public void agregarExcursion(Excursion excursion){
        listadoExcursiones.add(excursion);
        actualizarPrecio();
    }

    private void actualizarPrecio() {
        double sumatoria = 0;
        for (Excursion e: listadoExcursiones){
            sumatoria += e.getPrecio();
        }
        precio = sumatoria;
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

    public String getListadoExcursiones(){
        String listado = "";
        for (Excursion e: listadoExcursiones){
            listado += e.getDescripcion() + "\n";
        }
        return listado;
    }
}
