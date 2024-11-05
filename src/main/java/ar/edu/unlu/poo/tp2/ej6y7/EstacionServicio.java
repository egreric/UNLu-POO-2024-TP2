package ar.edu.unlu.poo.tp2.ej6y7;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EstacionServicio {
    private String nombre;
    private ArrayList<Cliente> listadoClientes;
    private ArrayList<Vendedor> listadoVendedores;
    private ArrayList<Surtidor> listadoSurtidores;
    private ArrayList<Venta> listadoVentas;

    public EstacionServicio(String nombre) {
        this.nombre = nombre;
        this.listadoClientes = new ArrayList<>();
        this.listadoVendedores = new ArrayList<>();
        this.listadoSurtidores = new ArrayList<>();
        this.listadoVentas = new ArrayList<>();
        // HARCODEO ALGUNAS ENTRADAS PARA HACER EL EJERCICIO 7
        Cliente cliente1 = new Cliente("Carlos", "23.359.312");
        Cliente cliente2 = new Cliente("Lorenzo", "19.054.056");
        Cliente cliente3 = new Cliente("Jonathan", "24.742.900");
        listadoClientes.add(cliente1);
        listadoClientes.add(cliente2);
        listadoClientes.add(cliente3);

        Vendedor vendedor = new Vendedor("Pablo", "15.342.567");
        listadoVendedores.add(vendedor);

        Surtidor surtidor = new Surtidor(1, new Combustible(TipoCombustible.NAFTA, 2950.50));
        listadoSurtidores.add(surtidor);

        Venta venta1 = new Venta(cliente1, "ALO 666", vendedor, surtidor, LocalDate.now().minusMonths(1), 12, 0);
        Venta venta2 = new Venta(cliente2, "ASD 212", vendedor, surtidor, LocalDate.now().minusMonths(1), 24, 0);
        Venta venta3 = new Venta(cliente3, "GDD 515", vendedor, surtidor, LocalDate.now().minusMonths(1), 15, 0);
        Venta venta4 = new Venta(cliente1, "WEQ 784", vendedor, surtidor, LocalDate.now().minusMonths(1), 13, 0);
        Venta venta5 = new Venta(cliente2, "QES 321", vendedor, surtidor, LocalDate.now().minusMonths(1), 32, 0);
        listadoVentas.add(venta1);
        listadoVentas.add(venta2);
        listadoVentas.add(venta3);
        listadoVentas.add(venta4);
        listadoVentas.add(venta5);

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

    public boolean realizarVenta(Cliente cliente, String patente, Vendedor vendedor, Surtidor surtidor, LocalDate fecha, double cantidadLitros, boolean quiereAplicarDescuento){
        if (listadoVendedores.contains(vendedor) && listadoSurtidores.contains(surtidor)){
            double descuento = 0;
            agregarCliente(cliente);
            if (clienteEsTop10MesAnterior(cliente)){
                descuento += 5;
                System.out.println(cliente.toString());
                System.out.println("DESCUENTO APLICADO DEL 5% -----------------------------------------------------");
            }
            if (!vendedor.aplicoDescuento() && quiereAplicarDescuento && vendedorEsTop10MesAnterior(vendedor)){
                descuento += 10;
                System.out.println(cliente.toString());
                System.out.println("DESCUENTO APLICADO DEL " + descuento + "% -----------------------------------------------------");
                vendedor.aplicarDescuento();
            }
            listadoVentas.add(new Venta(cliente, patente, vendedor, surtidor, fecha, cantidadLitros,descuento));
            return true;
        }
        return false;
    }

    private boolean vendedorEsTop10MesAnterior(Vendedor vendedor) {
        Map<Vendedor, Double> montoVentasPorVendedor = new HashMap<>();
        for (Venta v:listadoVentas){
            if (v.getFecha().getMonthValue() == LocalDate.now().minusMonths(1).getMonthValue()) {
                montoVentasPorVendedor.put(v.getVendedor(), montoVentasPorVendedor.getOrDefault(v.getVendedor(), 0.0) + v.getMonto());
            }
        }

        Map<Vendedor, Double> listaTop10 = montoVentasPorVendedor.entrySet()
                .stream()
                .sorted(Map.Entry.<Vendedor, Double>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        int numTop = 1;
        for (Map.Entry<Vendedor, Double> entrada:listaTop10.entrySet()){
            if (entrada.getKey().equals(vendedor)){
                return true;
            }
        }
        return false;
    }

    private boolean clienteEsTop10MesAnterior(Cliente cliente) {
                Map<Cliente, Double> montoComprasPorCliente = new HashMap<>();
        for (Venta v:listadoVentas){
            if (v.getFecha().getMonthValue() == LocalDate.now().minusMonths(1).getMonthValue()) {
                montoComprasPorCliente.put(v.getCliente(), montoComprasPorCliente.getOrDefault(v.getCliente(), 0.0) + v.getMonto());
            }
        }

        Map<Cliente, Double> listaTop10 = montoComprasPorCliente.entrySet()
                .stream()
                .sorted(Map.Entry.<Cliente, Double>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        int numTop = 1;
        for (Map.Entry<Cliente, Double> entrada:listaTop10.entrySet()){
            if (entrada.getKey().equals(cliente)){
                return true;
            }
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
    public String informeVentasXCombustible(){
        String listado = "--- LISTADO DE VENTAS POR COMBUSTIBLE ---\nSe realizaron un total de " + listadoVentas.size() + " ventas.\n";
        TipoCombustible tipoCombustible;
        Map<TipoCombustible, Integer> ventasPorTipoCombustible = new HashMap<>();
        for (Venta v: listadoVentas){
            ventasPorTipoCombustible.put(v.getTipoCombustible(), ventasPorTipoCombustible.getOrDefault(v.getTipoCombustible(),0) + 1);
        }

        Map<TipoCombustible, Integer> sortedMap = ventasPorTipoCombustible.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for (Map.Entry<TipoCombustible, Integer> entrada: ventasPorTipoCombustible.entrySet()){
            listado += "Tipo Combustible: " + entrada.getKey() + " - " + entrada.getValue() + " ventas (" + String.format("%.1f",((entrada.getValue()*100.0)/listadoVentas.size())) + "%)\n" ;
        }

        return listado;
    }


    public String infromeVentasXSurtidor(){
        String listado = "--- LISTADO DE SURTIDORES (ORDEN SEGUN MONTO DE VENTAS) ---\nSe realizaron un total de " + listadoVentas.size() + " ventas.\n";
        Map<Integer, Double> montoVentasPorSurtidores = new HashMap<>();
        for (Venta v: listadoVentas){
            montoVentasPorSurtidores.put(v.getCodigoSurtidor(), montoVentasPorSurtidores.getOrDefault(v.getCodigoSurtidor(),0.0) + v.getMonto());
        }



        // Manera de ordenar un HashMap segun sus valores (Se crea un nuevo listadoOrdenado y luego se utiliza este nuevo para recorrer y mostrar el informe)
        Map<Integer, Double> listadoOrdenado = montoVentasPorSurtidores.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // Clave
                        Map.Entry::getValue, // Valor
                        (e1, e2) -> e1, // Si hay colision, quedarnos con el primero
                        LinkedHashMap::new // Usar LinkedHashMap para mantener el orden
                ));

        for (Map.Entry<Integer, Double> entrada: listadoOrdenado.entrySet()){
            listado += "Surtidor " + entrada.getKey() + " - Monto total vendido: $" + String.format("%.2f",entrada.getValue()) + "\n";
        }
        return listado;
    }

    public String informeLitrosXSurtidor(){
        String listado = "--- LISTADO DE SURTIDORES (ORDEN SEGUN LITROS VENDIDOS) ---\n";
        Map<Integer, Double> litrosPorSurtidor = new HashMap<>();

        for (Venta v: listadoVentas){
            litrosPorSurtidor.put(v.getCodigoSurtidor(), litrosPorSurtidor.getOrDefault(v.getCodigoSurtidor(),0.0) + v.getCantidadLitros());
        }

        Map<Integer, Double> listadoOrdenado = litrosPorSurtidor.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for(Map.Entry<Integer, Double> entrada: listadoOrdenado.entrySet()){
            listado += "Surtidor " + entrada.getKey() + " - " + entrada.getValue() + " Lts. expendidos.\n";
        }
        return listado;
    }

    public String informeVentasXEmpleado(){
        String listado = "--- LISTADO DE VENDEDORES (ORDEN SEGUN MONTO VENDIDO) ---\n";
        Map<Vendedor, Double> montoVentasPorEmpleado = new HashMap<>();

        for (Venta v: listadoVentas){
            montoVentasPorEmpleado.put(v.getVendedor(), montoVentasPorEmpleado.getOrDefault(v.getVendedor(),0.0) + v.getMonto());
        }

        Map<Vendedor, Double> listadoOrdenado = montoVentasPorEmpleado.entrySet()
                .stream()
                .sorted(Map.Entry.<Vendedor, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for (Map.Entry<Vendedor, Double> entrada: listadoOrdenado.entrySet()){
            listado += entrada.getKey().toString() + " ($" + String.format("%.2f", entrada.getValue()) + " vendidos)\n";
        }

        return listado;
    }

    public String informeTop10Clientes(){
        String listado = "--- TOP 10 CLIENTES (SEGUN MONTO COMPRAS)---\n";
        Map<Cliente, Double> montoComprasPorCliente = new HashMap<>();
        for (Venta v:listadoVentas){
            montoComprasPorCliente.put(v.getCliente(), montoComprasPorCliente.getOrDefault(v.getCliente(),0.0) + v.getMonto());
        }

        Map<Cliente, Double> listaTop10 = montoComprasPorCliente.entrySet()
                .stream()
                .sorted(Map.Entry.<Cliente, Double>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        int numTop = 1;
        for (Map.Entry<Cliente, Double> entrada:listaTop10.entrySet()){
            listado += numTop + ". " + entrada.getKey().toString() + " ($ " + String.format("%.2f",entrada.getValue()) + " comprado)\n";
            numTop++;
        }

        return listado;
    }

}
