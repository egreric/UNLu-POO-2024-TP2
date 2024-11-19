package ar.edu.unlu.poo.tp2.ej14;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agencia {
    private String nombre;
    private ArrayList<Cliente> listadoClientes;
    private ArrayList<GuiaTurismo> listadoGuiasTurismo;
    private ArrayList<Hospedaje> listadoHospedajes;
    private ArrayList<MedioTransporte> listadoMediosTransporte;
    private ArrayList<PaqueteTurismo> listadoPaquetesTurismo;
    private ArrayList<Compra> listadoVentas;

    public Agencia(String nombre){
        this.nombre = nombre;
        listadoClientes = new ArrayList<>();
        listadoGuiasTurismo = new ArrayList<>();
        listadoHospedajes = new ArrayList<>();
        listadoMediosTransporte = new ArrayList<>();
        listadoPaquetesTurismo = new ArrayList<>();
        listadoVentas = new ArrayList<>();
    }

    public void agregarProveedor(MedioTransporte medioTransporte){
        listadoMediosTransporte.add(medioTransporte);
    }

    public void agregarProveedor(GuiaTurismo guiaTurismo){
        listadoGuiasTurismo.add(guiaTurismo);
    }

    public void agregarProveedor(Hospedaje hospedaje){
        listadoHospedajes.add(hospedaje);
    }

    public void agregarCliente(Cliente cliente){
        listadoClientes.add(cliente);
    }

    public void agregarPaquete(PaqueteTurismo paqueteTurismo){
        if (listadoGuiasTurismo.contains(paqueteTurismo.getGuiaTurismo()) &&
                listadoHospedajes.contains(paqueteTurismo.getHospedaje()) &&
                listadoMediosTransporte.contains(paqueteTurismo.getMedioTransporte())){
            listadoPaquetesTurismo.add(paqueteTurismo);
        }
    }

    public void registrarVenta(Cliente cliente, PaqueteTurismo paqueteTurismo){
        if (listadoClientes.contains(cliente) && listadoPaquetesTurismo.contains(paqueteTurismo)){
            Compra compra = new Compra(paqueteTurismo,paqueteTurismo.getPrecioPaquetePorPersona(), LocalDate.now());
            listadoVentas.add(compra);
            cliente.registrarCompra(compra);
        }
    }

    public String generarInformeVentas(){
        String informe = "Informe de Ventas (Ordenado por Destino)\n";

        Map<String, ArrayList<Compra>> ventasPorDestino = new HashMap<>();
        for (Compra v: listadoVentas){
            String destino = v.paqueteTurismo().getDestino();
            ventasPorDestino.putIfAbsent(destino, new ArrayList<>()); // Si no existe la lista de esa clave la creo
            ventasPorDestino.get(destino).add(v);
        }

        ArrayList<Map.Entry<String, ArrayList<Compra>>> listaEntradas = new ArrayList<>(ventasPorDestino.entrySet()); // creo una lista con cada una de las entradas de mi HashMap
        listaEntradas.sort(Map.Entry.comparingByKey()); // comparingByKey me ordena alfabeticamente segun el valor de la clave(key) -si comento esta linea me muestra el listado pero sin ordenar-
        for (Map.Entry<String, ArrayList<Compra>> entrada: listaEntradas){ // esta es la forma de poder recorrer cada entrada (osea cada destino)
            informe += "Destino: " + entrada.getKey() + "\n";
            for (Compra c: entrada.getValue()){
                informe += "- Medio Transporte: " + c.paqueteTurismo().getMedioTransporte().getNombre() + " - ";
                informe += "Hospedaje: " + c.paqueteTurismo().getHospedaje().getNombre() + " - ";
                informe += "Guia de Turismo: " + c.paqueteTurismo().getGuiaTurismo().getNombre() + ".\n";
            }
        }

        return informe;
    }

    public String getDestinoFavorito(){
        Map<String, Integer> ventasPorDestino = new HashMap<>();
        for (Compra v: listadoVentas){
            String destino = v.paqueteTurismo().getDestino();
            ventasPorDestino.put(destino, ventasPorDestino.getOrDefault(destino,0) + 1);
        }

        String destinoFavorito = "";
        int maxVentas = -1;
        for (Map.Entry<String, Integer> entrada: ventasPorDestino.entrySet()){ // esta es la forma de poder recorrer cada entrada (osea cada destino)
            if (entrada.getValue() > maxVentas){
                destinoFavorito = entrada.getKey();
                maxVentas = entrada.getValue();
            }
        }

        return "El destino con mas ventas fue: " + destinoFavorito + ", Con " + maxVentas + " ventas.";
    }

    public String getListadoProveedores() {
        String listado = "----- LISTADO DE PROVEEDORES -----\n";
        ArrayList<Proveedor> listadoProveedores = new ArrayList<>(listadoHospedajes);
        listadoProveedores.addAll(listadoGuiasTurismo);
        listadoProveedores.addAll(listadoMediosTransporte);
        for (Proveedor p: listadoProveedores){
            listado += "Tipo: " + p.getClass().getSimpleName() + " - Nombre: " + p.getNombre() + " - Telefono: " + p.getTelefono() + " - Precio Base: $" + p.getPrecioBase() + "\n";
        }

        return listado;
    }
}
