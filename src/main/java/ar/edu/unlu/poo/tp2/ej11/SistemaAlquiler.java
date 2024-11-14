package ar.edu.unlu.poo.tp2.ej11;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaAlquiler {
    ArrayList<Cliente> clientes;
    ArrayList<Vehiculo> vehiculos;
    ArrayList<Presupuesto> presupuestos;
    ArrayList<Alquiler> alquileres;

    public SistemaAlquiler(){
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        presupuestos = new ArrayList<>();
        alquileres = new ArrayList<>();
    }

    public void registrarCliente(String nombre, String dni){
        Cliente cliente = new Cliente(nombre,dni);
        if (clientes.isEmpty() || !clientes.contains(cliente)){
            clientes.add(cliente);
        }
    }

    public void registrarVehiculo(Vehiculo vehiculo){
        if (vehiculos.isEmpty() || !vehiculos.contains(vehiculo)){
            vehiculos.add(vehiculo);
        }
    }

    public void generarPresupuesto(int idVehiculo, int cantidadDias){
        Vehiculo vehiculo = buscarVehiculo(idVehiculo);
        if (vehiculo != null){
            Presupuesto presupuesto = new Presupuesto(vehiculo, cantidadDias);
            presupuestos.add(presupuesto);
        }
    }

    public void generarAlquiler(int idCliente, int idPresupuesto, LocalDate fechaInicio){
        Cliente cliente = buscarCliente(idCliente);
        Presupuesto presupuesto = buscarPresupuesto(idPresupuesto);
        if (cliente != null && presupuesto != null){
            if (!presupuesto.getVehiculo().estaPrestado()){
                Alquiler alquiler = new Alquiler(cliente, presupuesto, fechaInicio);
                alquileres.add(alquiler);
                presupuesto.getVehiculo().prestar();
                cliente.agregarAlquiler(alquiler);
            }
        }
    }

    public void devolucionAlquiler(int idAlquiler){
        Alquiler alquiler = buscarAlquiler(idAlquiler);
        if (alquiler != null){
            alquiler.getPresupuesto().getVehiculo().devolver();
        }
    }

    private Cliente buscarCliente(int idCliente) {
        if (!clientes.isEmpty() && idCliente >= 1 && idCliente <= clientes.size()){
            return (clientes.get(idCliente-1));
        }
        return null;
    }

    private Vehiculo buscarVehiculo(int idVehiculo) {
        if (!vehiculos.isEmpty() && idVehiculo >= 1 && idVehiculo <= vehiculos.size()){
            return (vehiculos.get(idVehiculo-1));
        }
        return null;
    }

    private Presupuesto buscarPresupuesto(int idPresupuesto) {
        if (!presupuestos.isEmpty() && idPresupuesto >= 1 && idPresupuesto <= presupuestos.size()){
            return (presupuestos.get(idPresupuesto-1));
        }
        return null;
    }

    private Alquiler buscarAlquiler(int idAlquiler) {
        if (!alquileres.isEmpty() && idAlquiler >= 1 && idAlquiler <= alquileres.size()){
            return (alquileres.get(idAlquiler-1));
        }
        return null;
    }

    public String mostrarClientes(){
        String listado = "----- LISTADO DE CLIENTES -----\n";
        for (Cliente c: clientes){
            listado += c.toString() + "\n";;
        }
        return listado;
    }

    public String mostrarVehiculos(){
        String listado = "----- LISTADO DE VEHICULOS -----\n";
        for (Vehiculo v: vehiculos){
            listado += v.toString() + "\n";
        }
        return listado;
    }

    public String mostrarAlquileres(){
        String listado = "----- LISTADO DE ALQUILERES -----\n";
        double sumatoria = 0;
        for (Alquiler a: alquileres){
            listado += a.toString() + "\n";;
            sumatoria += a.getMonto();
        }
        return listado + "\nEl monto total de todos los alquileres es de: " + sumatoria;
    }

    public String mostrarAlquileresPorCliente(int idCliente){
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            return cliente.toString() + "\n" + cliente.informeAlquileres();
        } else {
            return "Cliente no existe";
        }
    }

}