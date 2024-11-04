package ar.edu.unlu.poo.tp2.ej6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstacionServicio {
    private String nombre;
    private ArrayList<Cliente> listadoClientes;
    private ArrayList<Vendedor> listadoVendedores;
    private ArrayList<Surtidor> listadoSurtidores;
    private ArrayList<Venta> listadoVentas;

    public EstacionServicio(String nombre){
        this.nombre = nombre;
        this.listadoClientes = new ArrayList<>();
        this.listadoVendedores = new ArrayList<>();
        this.listadoSurtidores = new ArrayList<>();
        this.listadoVentas = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    private boolean agregarCliente(Cliente Cliente){
        if (!listadoClientes.contains(Cliente)){
            listadoClientes.add(Cliente);
            return true;
        }
        return false;
    }

    public boolean agregarVendedor(Vendedor vendedor){
        if (!listadoVendedores.contains(vendedor)){
            listadoVendedores.add(vendedor);
            return true;
        }
        return false;
    }

    public boolean agregarSurtidor(Surtidor surtidor){
        if (!listadoSurtidores.contains(surtidor)){
            listadoSurtidores.add(surtidor);
            return true;
        }
        return false;
    }

    public boolean realizarVenta(Cliente cliente, String patente, Vendedor vendedor, Surtidor surtidor, LocalDate fecha, double cantidadLitros){
        if (listadoVendedores.contains(vendedor) && listadoSurtidores.contains(surtidor)){
        agregarCliente(cliente);
        listadoVentas.add(new Venta(cliente, patente, vendedor, surtidor, fecha, cantidadLitros));
        return true;
        }
        return false;
    }

    public String getVendedores(){
        String listado = "Listado de Vendedores: \n";
        for (Vendedor v: listadoVendedores) {
            listado += v.toString() + "\n";
        }
        return listado;
    }
    public String getClientes(){
        String listado = "Listado de Clientes: \n";
        for (Cliente c: listadoClientes) {
            listado += c.toString() + "\n";
        }
        return listado;
    }
    public String getSurtidores(){
        String listado = "Listado de Surtidores: \n";
        for (Surtidor s: listadoSurtidores) {
            listado += s.toString() + "\n";
        }
        return listado;
    }
    public String getVentas() {
        String listado = "Listado de Ventas: \n";
        for (Venta v: listadoVentas) {
            listado += v.toString() + "\n";
        }
        return listado;
    }

    // CREO QUE SOLO ME FALTA IMPLENTAR LOS LISTADOS (CREO Q PARA TODOS LOS LISTADOS TENGO QUE RECORRER SI O SI LOS LISTADOS DE VENTAS)
    public String getListadoProporcionVentasPorTipoCombustible(){
        String listado = "Total de ventas: " + listadoVentas.size() + "\n";
        TipoCombustible tipoCombustible;
        Map<TipoCombustible, Integer> ventasPorTipoCombustible = new HashMap<>();
        for (Venta v: listadoVentas){
            ventasPorTipoCombustible.put(v.getTipoCombustible(), ventasPorTipoCombustible.getOrDefault(v.getTipoCombustible(),0) + 1);
        }

        for (Map.Entry<TipoCombustible, Integer> entrada: ventasPorTipoCombustible.entrySet()){
            listado += "Tipo Combustible: " + entrada.getKey() + " - " + entrada.getValue() + " ventas (" + String.format("%.1f",((entrada.getValue()*100.0)/listadoVentas.size())) + "%)\n" ;
        }

        return listado;
    }
}
