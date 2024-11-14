package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej10.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainEj10 {
    public static void main(String[] args){
        // Crear empleados de cada tipo
        Empleado empleadoAsalariado = new EmpleadoAsalariado("Juan", "Perez", "123456789", "20-12345678-9", LocalDate.of(1992, 11, 4), 5000);
        Empleado empleadoPorComision = new EmpleadoPorComision("Ana", "Gomez", "987654321", "20-87654321-0", LocalDate.of(1992, 11, 4), 100000, 10);
        Empleado empleadoPorComisionConSalarioBase = new EmpleadoPorComisionConSalario("Carlos", "Lopez", "1122334455", "20-11223344-5", LocalDate.of(1992, 11, 4), 80000, 20, 20000);
        Empleado empleadoPorHora = new EmpleadoPorHora("Lucia", "Martinez", "3344556677", "20-33445566-7", LocalDate.of(1992, 11, 4), 160, 250);
        Empleado pasante = new Pasante("Mario", "Suarez", "5566778899", "20-55667788-9", LocalDate.of(1992, 11, 4));

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(empleadoAsalariado);
        empleados.add(empleadoPorComision);
        empleados.add(empleadoPorComisionConSalarioBase);
        empleados.add(empleadoPorHora);
        empleados.add(pasante);

        // Calcular y mostrar sueldos
        for (Empleado e: empleados){
            System.out.println("Sueldo del empleado " + e.getClass().getSimpleName() + ": $" + e.calcularSueldo());
        }
        System.out.println();System.out.println();
    }
}
