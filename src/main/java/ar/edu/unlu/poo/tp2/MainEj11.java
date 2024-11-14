package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej11.*;

import java.time.LocalDate;

public class MainEj11 {
    public static void main(String[] args) {

        SistemaAlquiler sa = new SistemaAlquiler();

        sa.registrarCliente("Carlos", "23.235.642");
        sa.registrarCliente("Pedro", "17.244.121");
        sa.registrarCliente("Juan", "32.667.128");

        AutoPasajero autoPasajero = new AutoPasajero("GJD 123",4);
        AutoVip autoVip = new AutoVip("ABC 224", 4);
        Combi combi = new Combi("JPE 443");
        Camioneta camioneta = new Camioneta("ASD 644",20);
        Camion camion = new Camion("JJK 334");
        sa.registrarVehiculo(autoPasajero);
        sa.registrarVehiculo(autoVip);
        sa.registrarVehiculo(combi);
        sa.registrarVehiculo(camioneta);
        sa.registrarVehiculo(camion);

        sa.generarPresupuesto(1,5);
        sa.generarPresupuesto(2,10);
        sa.generarPresupuesto(3,7);
        sa.generarPresupuesto(4,4);
        sa.generarPresupuesto(5,14);

        System.out.println(sa.mostrarClientes());
        System.out.println(sa.mostrarVehiculos());

        sa.generarAlquiler(1,1, LocalDate.now().plusDays(2));
        sa.generarAlquiler(2,2, LocalDate.now().plusDays(10));
        sa.generarAlquiler(3,3, LocalDate.now().plusDays(4));
        sa.generarAlquiler(1,3, LocalDate.now().plusDays(5));
        sa.generarAlquiler(2,4, LocalDate.now().plusDays(3));
        sa.generarAlquiler(1,5, LocalDate.now().plusDays(2));
        sa.generarAlquiler(1,5, LocalDate.now().plusDays(2));
        sa.generarAlquiler(1,2, LocalDate.now().plusDays(9));
        System.out.println(sa.mostrarAlquileres());
        System.out.println();

        System.out.println(sa.mostrarAlquileresPorCliente(1));
        System.out.println(sa.mostrarAlquileresPorCliente(2));
        System.out.println(sa.mostrarAlquileresPorCliente(3));
        System.out.println(sa.mostrarAlquileresPorCliente(4));



    }

}
