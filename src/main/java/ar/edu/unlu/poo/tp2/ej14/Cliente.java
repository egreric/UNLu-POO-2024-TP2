package ar.edu.unlu.poo.tp2.ej14;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String dni;
    private ArrayList<Compra> listadoCompras;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.listadoCompras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public ArrayList<Compra> getListadoCompras() {
        return listadoCompras;
    }

    public void registrarCompra(Compra compra){
        listadoCompras.add(compra);
    }

}
