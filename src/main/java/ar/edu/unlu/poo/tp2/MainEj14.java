package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej14.*;

public class MainEj14 {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Kevin Rodriguez","23.233.332");
        Cliente cliente2 = new Cliente("Javier Gonzalez","12.123.566");
        Cliente cliente3 = new Cliente("Gaston Garcia","31.234.788");
        Cliente cliente4 = new Cliente("Pablo Soto","16.214.477");

        Hospedaje hospedaje1 = new Hospedaje("Luxzor", "2323456743", 20000.00, TipoHospedaje.HOTEL,30);
        Hospedaje hospedaje2 = new Hospedaje("Bungalo IV", "2324541287", 15800.00, TipoHospedaje.BUNGALO,50);
        Hospedaje hospedaje3 = new Hospedaje("Hosteria LINO", "1134560921", 30000, TipoHospedaje.HOSTERIA,100);
        Hospedaje hospedaje4 = new Hospedaje("Hotel SAN JAVIER", "3223238942", 42900.00, TipoHospedaje.HOTEL,80);

        MedioTransporte medioTransporte1 = new MedioTransporte("Volare", "2323432156", 15000, TipoTransporte.AEREO);
        MedioTransporte medioTransporte2 = new MedioTransporte("Aguas Rapidas", "2122984563", 15000, TipoTransporte.MARITIMO);
        MedioTransporte medioTransporte3 = new MedioTransporte("Fast BUS", "1178452144", 15000, TipoTransporte.TERRESTRE);
        MedioTransporte medioTransporte4 = new MedioTransporte("Low Truck", "1156569900", 15000, TipoTransporte.TERRESTRE);

        Excursion excursion1 = new Excursion("Visita guiada al museo", 6600.00);
        Excursion excursion2 = new Excursion("Ida Parque diversiones", 10500.00);
        Excursion excursion3 = new Excursion("Vuelta a la ciudad en BUS", 3500.00);
        Excursion excursion4 = new Excursion("Salida a comer (cena)", 12000.00);
        Excursion excursion5 = new Excursion("Entrada parque nacional", 10000.00);
        Excursion excursion6 = new Excursion("Tirada en paracaidas", 20300.00);

        GuiaTurismo guiaTurismo1 = new GuiaTurismo("Turismisimo IX", "1134667999");
        guiaTurismo1.agregarExcursion(excursion1);
        guiaTurismo1.agregarExcursion(excursion2);

        GuiaTurismo guiaTurismo2 = new GuiaTurismo("Turismo Total", "2323458899");
        guiaTurismo2.agregarExcursion(excursion2);
        guiaTurismo2.agregarExcursion(excursion3);

        GuiaTurismo guiaTurismo3 = new GuiaTurismo("Soy Turismo", "1125441103");
        guiaTurismo3.agregarExcursion(excursion4);
        guiaTurismo3.agregarExcursion(excursion5);

        GuiaTurismo guiaTurismo4 = new GuiaTurismo("Puras vueltas", "2324099044");
        guiaTurismo4.agregarExcursion(excursion6);
        guiaTurismo4.agregarExcursion(excursion1);

        PaqueteTurismo paqueteTurismo1 = new PaqueteTurismo("Argentina", medioTransporte1, hospedaje1, guiaTurismo1,15);
        PaqueteTurismo paqueteTurismo2 = new PaqueteTurismo("Brasil", medioTransporte2, hospedaje2, guiaTurismo1,50);
        PaqueteTurismo paqueteTurismo3 = new PaqueteTurismo("Colombia", medioTransporte2, hospedaje1, guiaTurismo2,200);
        PaqueteTurismo paqueteTurismo4 = new PaqueteTurismo("Espania", medioTransporte4, hospedaje4, guiaTurismo3,100);
        PaqueteTurismo paqueteTurismo5 = new PaqueteTurismo("Argentina", medioTransporte3, hospedaje3, guiaTurismo4,40);
        PaqueteTurismo paqueteTurismo6 = new PaqueteTurismo("Argentina", medioTransporte1, hospedaje3, guiaTurismo4,40);
        PaqueteTurismo paqueteTurismo7 = new PaqueteTurismo("Mexico", medioTransporte2, hospedaje2, guiaTurismo4,230);
        PaqueteTurismo paqueteTurismo8 = new PaqueteTurismo("Uruguay", medioTransporte1, hospedaje3, guiaTurismo3,25);
        PaqueteTurismo paqueteTurismo9 = new PaqueteTurismo("Peru", medioTransporte4, hospedaje4, guiaTurismo3,20);
        PaqueteTurismo paqueteTurismo10 = new PaqueteTurismo("Chile", medioTransporte4, hospedaje3, guiaTurismo3,50);

        Agencia agencia = new Agencia("Agencia VACAN");

        agencia.agregarCliente(cliente1);
        agencia.agregarCliente(cliente2);
        agencia.agregarCliente(cliente3);
        agencia.agregarCliente(cliente4);

        agencia.agregarProveedor(hospedaje1);
        agencia.agregarProveedor(hospedaje2);
        agencia.agregarProveedor(hospedaje3);
        agencia.agregarProveedor(hospedaje4);

        agencia.agregarProveedor(medioTransporte1);
        agencia.agregarProveedor(medioTransporte2);
        agencia.agregarProveedor(medioTransporte3);
        agencia.agregarProveedor(medioTransporte4);

        agencia.agregarProveedor(guiaTurismo1);
        agencia.agregarProveedor(guiaTurismo2);
        agencia.agregarProveedor(guiaTurismo3);
        agencia.agregarProveedor(guiaTurismo4);

        agencia.agregarPaquete(paqueteTurismo1);
        agencia.agregarPaquete(paqueteTurismo2);
        agencia.agregarPaquete(paqueteTurismo3);
        agencia.agregarPaquete(paqueteTurismo4);
        agencia.agregarPaquete(paqueteTurismo5);
        agencia.agregarPaquete(paqueteTurismo6);
        agencia.agregarPaquete(paqueteTurismo7);
        agencia.agregarPaquete(paqueteTurismo8);
        agencia.agregarPaquete(paqueteTurismo9);
        agencia.agregarPaquete(paqueteTurismo10);

        agencia.registrarVenta(cliente1, paqueteTurismo1);
        agencia.registrarVenta(cliente2, paqueteTurismo3);
        agencia.registrarVenta(cliente3, paqueteTurismo4);
        agencia.registrarVenta(cliente4, paqueteTurismo1);
        agencia.registrarVenta(cliente1, paqueteTurismo2);
        agencia.registrarVenta(cliente1, paqueteTurismo5);
        agencia.registrarVenta(cliente2, paqueteTurismo6);
        agencia.registrarVenta(cliente2, paqueteTurismo7);
        agencia.registrarVenta(cliente2, paqueteTurismo8);
        agencia.registrarVenta(cliente3, paqueteTurismo3);
        agencia.registrarVenta(cliente4, paqueteTurismo10);
        agencia.registrarVenta(cliente4, paqueteTurismo9);
        agencia.registrarVenta(cliente2, paqueteTurismo4);

        System.out.println(agencia.generarInformeVentas() + "\n");
        System.out.println(agencia.getDestinoFavorito() + "\n");
        System.out.println(agencia.getListadoProveedores());
    }
}
