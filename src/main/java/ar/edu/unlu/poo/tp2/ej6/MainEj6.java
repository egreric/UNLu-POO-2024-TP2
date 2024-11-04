package ar.edu.unlu.poo.tp2.ej6;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class MainEj6 {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Carlos","23.359.312");
        Cliente cliente2 = new Cliente("Pedro","16.244.523");
        Cliente cliente3 = new Cliente("Roberto","31.953.221");
        Cliente cliente4 = new Cliente("Lucas","19.004.523");
        Cliente cliente5 = new Cliente("Ezequiel","32.455.211");
        Cliente cliente6 = new Cliente("Hugo","26.834.970");
        Cliente cliente7 = new Cliente("Gaston","21.441.444");
        Cliente cliente8 = new Cliente("Gonzalo","20.296.562");
        Cliente cliente9 = new Cliente("Ernesto","18.907.217");
        Cliente cliente10 = new Cliente("Lorenzo","19.054.056");


        Vendedor vendedor1 = new Vendedor("Pablo","15.342.567");
        Vendedor vendedor2 = new Vendedor("Martin","31.579.346");
        Vendedor vendedor3 = new Vendedor("Joaquin","18.831.812");


        Combustible combustible1 = new Combustible(TipoCombustible.NAFTA, 2950.50);
        Combustible combustible2 = new Combustible(TipoCombustible.KEROSENE, 3420.30);
        Combustible combustible3 = new Combustible(TipoCombustible.GASOIL, 4320.20);


        Surtidor surtidor1 = new Surtidor(1, combustible1);
        Surtidor surtidor2 = new Surtidor(2, combustible2);
        Surtidor surtidor3 = new Surtidor(3, combustible3);
        Surtidor surtidor4 = new Surtidor(4, combustible1);
        Surtidor surtidor5 = new Surtidor(5, combustible2);




        EstacionServicio es = new EstacionServicio("Estacion Ruta 8");

        es.agregarVendedor(vendedor1);
        es.agregarVendedor(vendedor2);
        es.agregarVendedor(vendedor3);
        es.agregarVendedor(vendedor3);
        es.agregarVendedor(vendedor2);

        es.agregarSurtidor(surtidor1);
        es.agregarSurtidor(surtidor2);
        es.agregarSurtidor(surtidor3);
        es.agregarSurtidor(surtidor4);
        es.agregarSurtidor(surtidor4);
        es.agregarSurtidor(surtidor5);
        es.agregarSurtidor(surtidor1);
        es.agregarSurtidor(surtidor5);


        es.realizarVenta(cliente1,"ISE 344", vendedor1, surtidor1, LocalDate.now(),12);
        es.realizarVenta(cliente2,"DFG 436", vendedor2, surtidor2, LocalDate.now(),32);
        es.realizarVenta(cliente3,"JUR 842", vendedor3, surtidor3, LocalDate.now(),40);
        es.realizarVenta(cliente4,"WRT 522", vendedor1, surtidor4, LocalDate.now(),15);
        es.realizarVenta(cliente5,"JXE 896", vendedor1, surtidor5, LocalDate.now(),17);
        es.realizarVenta(cliente6,"SSD 125", vendedor2, surtidor1, LocalDate.now(),18);
        es.realizarVenta(cliente7,"ASO 167", vendedor2, surtidor1, LocalDate.now(),21);
        es.realizarVenta(cliente8,"BGE 789", vendedor3, surtidor2, LocalDate.now(),25);
        es.realizarVenta(cliente9,"IPO 990", vendedor3, surtidor2, LocalDate.now(),33);
        es.realizarVenta(cliente10,"ALO 666", vendedor3, surtidor3, LocalDate.now(),31);
        es.realizarVenta(cliente3,"IRE 234", vendedor3, surtidor3, LocalDate.now(),29);
        es.realizarVenta(cliente4,"EFE 121", vendedor2, surtidor4, LocalDate.now(),32);
        es.realizarVenta(cliente5,"DVX 079", vendedor1, surtidor4, LocalDate.now(),30);
        es.realizarVenta(cliente7,"VFF 672", vendedor1, surtidor5, LocalDate.now(),16);
        es.realizarVenta(cliente10,"AAX 561", vendedor2, surtidor5, LocalDate.now(),15);
        es.realizarVenta(cliente10,"AAJ 890", vendedor3, surtidor5, LocalDate.now(),25);
        es.realizarVenta(cliente2,"SDD 003", vendedor1, surtidor5, LocalDate.now(),20);
        es.realizarVenta(cliente7,"JLA 412", vendedor3, surtidor3, LocalDate.now(),19);
        es.realizarVenta(cliente4,"CAL 167", vendedor3, surtidor2, LocalDate.now(),24);
        es.realizarVenta(cliente3,"PIC 593", vendedor2, surtidor4, LocalDate.now(),23);
        es.realizarVenta(cliente2, "FEG 178", vendedor2, surtidor1, LocalDate.now(),23);

        System.out.println(es.getNombre() + "\n");
        System.out.println(es.getClientes());
        System.out.println(es.getVendedores());
        System.out.println(es.getSurtidores());
        System.out.println(es.getVentas());
        System.out.println(es.getListadoProporcionVentasPorTipoCombustible());

    }
}
