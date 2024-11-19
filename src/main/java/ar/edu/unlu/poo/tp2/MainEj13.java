package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej13.metodoAlternativo.Rol;
import ar.edu.unlu.poo.tp2.ej13.metodoOriginal.Pasajero;
import ar.edu.unlu.poo.tp2.ej13.metodoOriginal.Persona;
import ar.edu.unlu.poo.tp2.ej13.metodoOriginal.Tripulante;

public class MainEj13 {
    public static void main(String[] args) {
        System.out.println("Respuestas a las reflexiones del ejercicio:\n");
        System.out.println("1 - Porque estan modeladas como clases independientes una de la otra(Pasajeros y Tripulantes), esto hace que una ");
        System.out.println("persona no pueda ser simultaneamente una instancia de ambas.\n");

        System.out.println("2 - Si las clases se diseñaron sin considerar casos de uso donde una persona pueda tener multiples roles (por ");
        System.out.println("ejemplo, ser tripulante y pasajero al mismo tiempo), se trata de un fallo de análisis.\n");

        System.out.println("3 - Una forma de solucionar este problema de diseño seria asignarle a cada persona un rol(o varios roles) y desde alli aplicar la herencia\n");

        System.out.println("----- MODELO ORIGINAL -----");
        System.out.println("* AGREGAMOS A UN NUEVO TRIPULANTE");
        Persona nuevoTripulante = new Tripulante("Carlos","2323452323","Avellaneda 1489","Copiloto");
        System.out.println("Datos del tripulante: " + nuevoTripulante.toString() + "\n");
        System.out.println("* SI QUISIERAMOS AGREGAR A ESTE TRIPULANTE COMO UN NUEVO PASAJERO, LA UNICA FORMA QUE TENEMOS" +
                "\nES VOLVIENDO A CARGAR TODOS SUS DATOS PARA GENERAR UNA INSTANCIA DE LA CLASE PASAJERO");
        Persona nuevoPasajero = new Pasajero("Carlos", "2323452323", "Avellaneda 1489", 24);
        System.out.println("Datos del pasajero: " + nuevoPasajero.toString() + "\n");


        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");


        System.out.println("----- MODELO ALTERNATIVO -----");
        System.out.println("* CREAMOS LA PERSONA");
        ar.edu.unlu.poo.tp2.ej13.metodoAlternativo.Persona persona = new ar.edu.unlu.poo.tp2.ej13.metodoAlternativo.Persona(
                "Carlos","2323452323","Avellaneda 1489");
        System.out.println(persona.toString());
        System.out.println("AHORA LE ASIGNAMOS EL ROL DE TRIPULANTE");
        persona.agregarRol(new ar.edu.unlu.poo.tp2.ej13.metodoAlternativo.Tripulante("Piloto"));
        System.out.println(persona.toString());
        System.out.println("AHORA LE ASIGNAMOS EL ROL DE PASAJERO (Con el numero 15)");
        persona.agregarRol(new ar.edu.unlu.poo.tp2.ej13.metodoAlternativo.Pasajero(15));
        System.out.println(persona.toString());
    }
}