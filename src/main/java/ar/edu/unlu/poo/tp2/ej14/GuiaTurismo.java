package ar.edu.unlu.poo.tp2.ej14;

import java.util.ArrayList;

public class GuiaTurismo extends Proveedor {

    private ArrayList<Excursion> listadoExcursiones;

    public GuiaTurismo(String nombre, String telefono) {
        super(nombre, telefono, 0);
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
        precioBase = sumatoria;
    }

    @Override
    public double calcularMontoExtra(int maxClientes) {
        return maxClientes > 200 ? 90 : 0;
    }


    public String getListadoExcursiones(){
        String listado = "";
        for (Excursion e: listadoExcursiones){
            listado += e.getDescripcion() + "\n";
        }
        return listado;
    }
}
