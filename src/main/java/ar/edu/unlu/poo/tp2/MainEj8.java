package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej8.Biblioteca;
import ar.edu.unlu.poo.tp2.ej8.Libro;
import ar.edu.unlu.poo.tp2.ej8.Publicacion;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainEj8 {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Local Lujan");

        biblioteca.agregarLibro("Cien Años de Soledad", "Editorial ABC", "123456789", "978-3-16-148410-0", 1967, "Gabriel Garcia Marquez", 3);
        biblioteca.agregarLibro("El Gran Gatsby", "Editorial Naranja", "2323568723", "345-1-15-3453-0", 1974, "F. Scott Fitzgerald", 10);
        biblioteca.agregarLibro("1984", "Editorial Naranja", "2323568723", "345-1-15-212322-0", 1974, "George Orwell", 8);
        biblioteca.agregarLibro("To Kill a Mockingbird", "Editorial Roja", "2323568723", "22-1-32-144-0", 1994, "Harper Lee", 12);
        biblioteca.agregarLibro("Matar un ruiseñor", "Editorial Roja", "2323568723","978-3-16-148410-0",1933,"Harper Lee", 9);
        biblioteca.agregarLibro("Dune", "Editorial Roja", "32434343434","142141-3-16-148410-0",2004,"Frank Herbert", 8);
        biblioteca.agregarLibro("Fundación", "Editorial Roja", "32434343434","78678-3-16-678678-0",2003,"Isaac Asimov", 10);
        biblioteca.agregarLibro("Fundación", "Editorial Roja", "32434343434","78678-3-16-678678-0",2003,"Isaac Asimov", 10);
        biblioteca.agregarLibro("Segunda Fundación", "Editorial Roja", "32434343434","12312-3-23-6572-0",2007,"Philip K. Dick", 7);
        biblioteca.agregarLibro("¿Sueñan los androides con ovejas eléctricas?", "Editorial Roja", "32434343434","12346-4-12-34343-3",1969,"Philip K. Dick", 9);

        biblioteca.agregarSocio("Mateo Rodriguez","27.894.093");
        biblioteca.agregarSocio("Pedro Perez","16.221.578");
        biblioteca.agregarSocio("Roberto Roca","1.251.856");
        biblioteca.agregarSocio("Julian Quintero","5.953.943");
        biblioteca.agregarSocio("Rodrigo Rodriguez","41.670.121");


        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("1. Mostrar listado de socios");
            System.out.println("2. Mostrar listado de libros");
            System.out.println("3. Mostrar listado de prestamos");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");

            System.out.println("0. Salir\n");
            System.out.print("Elija una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de linea
            int idLibro;
            int idSocio;
            String continuar;
            switch(opcion){
                case 1:
                    // Muestro listado de Socios
                    System.out.println(biblioteca.mostrarListadoSocios());
                    break;
                case 2:
                    // Muestro listado de Libros
                    System.out.println(biblioteca.mostrarListadoLibros());
                    break;
                case 3:
                    // Muestro los prestamos
                    System.out.println(biblioteca.mostrarListadoPrestamos());
                    break;
                case 4:
                    // Menu prestamo
                    // Primero selecciono el socio que quiere realizar el prestamo
                    do {
                        System.out.println(biblioteca.mostrarListadoSocios());
                        System.out.print("Elija el socio que solicita el prestamo: ");
                        idSocio = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de linea
                        if (idSocio < 1 || idSocio > biblioteca.getCantidadSocios()) {
                            System.out.println("Opcion invalida, elija una opcion valida...");
                        }
                    } while (idSocio < 1 || idSocio > biblioteca.getCantidadSocios());

                    // Luego selecciono el libro a prestar de mi listado
                    do {
                        System.out.println("Socio que pide el prestamo --> " + biblioteca.mostrarSocioPorId(idSocio)); // Muestro el socio que pide el prestamo
                        System.out.println(biblioteca.mostrarListadoLibros());
                        System.out.print("Elija el libro solicitado: ");
                        idLibro = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de linea
                        if (idLibro < 1 || idLibro > biblioteca.getCantidadLibros()) {
                            System.out.println("Opcion invalida, elija una opcion valida...");
                        }
                    } while (idLibro < 1 || idLibro > biblioteca.getCantidadLibros());

                    // Muestro datos del prestamo y pregunto si quiere confirmar el prestamo
                    System.out.println("\n----- DATOS DEL PRESTAMO ------");
                    System.out.println("Libro Seleccionado --> " + biblioteca.mostrarLibroPorId(idLibro)); // Muestro el libro a prestar
                    System.out.println("Socio que solicita prestamo --> " + biblioteca.mostrarSocioPorId(idSocio)); // Muestro el socio al que prestar
                    System.out.print("Desea continuar con el prestamo? S/N: ");
                    continuar = sc.nextLine();
                    if (continuar.equalsIgnoreCase("s")){
                        if (biblioteca.existePrestamo(idLibro,idSocio)){
                            System.out.println("Este libro ya fue prestado a este cliente!. Presione una tecla para continuar...");
                        } else {
                            if (biblioteca.quedanEjemplaresParaPrestar(idLibro)) {
                                biblioteca.prestarLibro(idLibro, idSocio);
                                System.out.println("El prestamo se ha realizado!. Presione una tecla para continuar...");
                            } else {
                                System.out.println("No quedan ejemplares disponbles para prestar!. Presione una tecla para continuar...");
                            }
                        }
                    } else {
                        System.out.println("El prestamo se ha cancelado!. Presione una tecla para continuar...");
                    }
                    sc.nextLine();
                    break;
                case 5:
                    // Menu devolucion
                    // Primero selecciono el socio que quiere hacer la devolucion
                    do {
                        System.out.println(biblioteca.mostrarListadoSocios());
                        System.out.print("Elija el socio que hace la devolucion: ");
                        idSocio = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de linea
                        if (idSocio < 1 || idSocio > biblioteca.getCantidadSocios()) {
                            System.out.println("Opcion invalida, elija una opcion valida...");
                        }
                    } while (idSocio < 1 || idSocio > biblioteca.getCantidadSocios());

                    // Luego selecciono el libro que va a devolver
                    do {
                        System.out.println("Socio que hace la devolucion --> " + biblioteca.mostrarSocioPorId(idSocio)); // Muestro el socio que pide el prestamo
                        System.out.println(biblioteca.mostrarListadoLibros());
                        System.out.print("Elija el libro a devolver: ");
                        idLibro = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de linea
                        if (idLibro < 1 || idLibro > biblioteca.getCantidadLibros()) {
                            System.out.println("Opcion invalida, elija una opcion valida...");
                        }
                    } while (idLibro < 1 || idLibro > biblioteca.getCantidadLibros());

                    // Muestro datos de la devolucion y si quiere confirmarla
                    System.out.println("\n----- DATOS DE LA DEVOLUCION ------");
                    System.out.println("Socio que devuelve --> " + biblioteca.mostrarSocioPorId(idSocio)); // Muestro el socio que hace devolucion
                    System.out.println("Libro a devolver --> " + biblioteca.mostrarLibroPorId(idLibro)); // Muestro el libro a devolver
                    System.out.print("Desea continuar con la devolucion? S/N: ");
                    continuar = sc.nextLine();
                    if (continuar.equalsIgnoreCase("s")){
                        if (biblioteca.existePrestamo(idLibro,idSocio)) {
                            biblioteca.devolverLibro(idLibro, idSocio);
                            System.out.println("Se ha realizado la devolucion!. Presione una tecla para continuar...");
                        } else {
                            System.out.println("No se puede hacer una devolucion de un prestamo inexistente!. Presione una tecla para continuar...");
                        }

                    } else {
                        System.out.println("La devolucion se ha cancelado!. Presione una tecla para continuar...");

                    }
                    sc.nextLine();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema!");
                    System.exit(0);
                default:
                    System.out.println("Opcion invalida, elija una opcion valida...");
            }

        }




    }
}
