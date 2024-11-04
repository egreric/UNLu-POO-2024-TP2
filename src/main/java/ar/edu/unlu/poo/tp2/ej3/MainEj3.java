package ar.edu.unlu.poo.tp2.ej3;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainEj3 {
    public static void main(String[] args){
        Academia academia = new Academia("Baile Total");

        // GENERO ALUMNOS
        Alumno alumno1 = new Alumno("Carlos","23.444.221");
        Alumno alumno2 = new Alumno("Javier","11.251.453");
        Alumno alumno3 = new Alumno("Pedro","31.231.123");
        Alumno alumno4 = new Alumno("Juan","41.842.312");
        Alumno alumno5 = new Alumno("Gustavo","24.735.902");

        // AGREGO ALUMNOS A MI ACADEMIA
        academia.agregarAlumno(alumno1);
        academia.agregarAlumno(alumno2);
        academia.agregarAlumno(alumno3);
        academia.agregarAlumno(alumno4);
        academia.agregarAlumno(alumno5);

        // GENERO PROFESORES
        Profesor profesor1 = new Profesor("Matias","16.321.288");
        Profesor profesor2 = new Profesor("Pablo","18.247.775");
        Profesor profesor3 = new Profesor("Ernesto","29.786.536");
        Profesor profesor4 = new Profesor("Marcos","18.358.956");

        // AGREGO PROFESORES A MI ACADEMIA
        academia.agregarProfesor(profesor1);
        academia.agregarProfesor(profesor2);
        academia.agregarProfesor(profesor3);
        academia.agregarProfesor(profesor4);

        // GENERO CLASES
        Clase clase1 = new Clase(Nivel.INICIAL, Disciplina.CLASICO, 2000, Dia.MARTES, LocalTime.of(17,30), LocalTime.of(19,30),profesor1);
        Clase clase2 = new Clase(Nivel.INICIAL, Disciplina.BACHATA, 3000, Dia.MIERCOLES, LocalTime.of(17,30), LocalTime.of(19,30),profesor1);
        Clase clase3 = new Clase(Nivel.INTERMEDIO, Disciplina.CLASICO, 1500, Dia.LUNES, LocalTime.of(18, 0), LocalTime.of(19,0),profesor2);
        Clase clase4 = new Clase(Nivel.AVANZADO, Disciplina.SALSA, 4500, Dia.JUEVES, LocalTime.of(20,0), LocalTime.of(21,30),profesor3);
        Clase clase5 = new Clase(Nivel.INICIAL, Disciplina.CONTEMPORANEO, 7000, Dia.JUEVES, LocalTime.of(9,0), LocalTime.of(12,0),profesor2);
        Clase clase6 = new Clase(Nivel.INTERMEDIO, Disciplina.TANGO, 3000, Dia.VIERNES, LocalTime.of(12,0), LocalTime.of(14,0),profesor3);
        Clase clase7 = new Clase(Nivel.INTERMEDIO, Disciplina.STRETCHING, 2000, Dia.MARTES, LocalTime.of(14,0), LocalTime.of(15,30),profesor2);
        Clase clase8 = new Clase(Nivel.AVANZADO, Disciplina.ARABE, 1000, Dia.SABADO, LocalTime.of(18,30), LocalTime.of(19,30),profesor1);
        Clase clase9 = new Clase(Nivel.AVANZADO, Disciplina.BACHATA, 1500, Dia.VIERNES, LocalTime.of(15,0), LocalTime.of(16,30),profesor2);
        Clase clase10 = new Clase(Nivel.INTERMEDIO, Disciplina.CLASICO, 2500, Dia.MIERCOLES, LocalTime.of(11,30), LocalTime.of(13,0),profesor1);
        Clase clase11 = new Clase(Nivel.INTERMEDIO, Disciplina.CONTEMPORANEO, 3500, Dia.JUEVES, LocalTime.of(10,30), LocalTime.of(11,30),profesor1);
        Clase clase12 = new Clase(Nivel.INICIAL, Disciplina.CONTEMPORANEO, 5000, Dia.SABADO, LocalTime.of(10,30), LocalTime.of(12,30),profesor2);
        Clase clase13 = new Clase(Nivel.INTERMEDIO, Disciplina.STRETCHING, 4000, Dia.MIERCOLES, LocalTime.of(9,0), LocalTime.of(11,0),profesor3);
        Clase clase14 = new Clase(Nivel.AVANZADO, Disciplina.CLASICO, 2500, Dia.VIERNES, LocalTime.of(17,0), LocalTime.of(19,0),profesor1);
        Clase clase15 = new Clase(Nivel.INTERMEDIO, Disciplina.SALSA, 2000, Dia.MARTES, LocalTime.of(20,0), LocalTime.of(21,0),profesor4);

        // AGREGO CLASES A MI ACADEMIA
        academia.agregarClase(clase1);
        academia.agregarClase(clase2);
        academia.agregarClase(clase3);
        academia.agregarClase(clase4);
        academia.agregarClase(clase5);
        academia.agregarClase(clase6);
        academia.agregarClase(clase7);
        academia.agregarClase(clase8);
        academia.agregarClase(clase9);
        academia.agregarClase(clase10);
        academia.agregarClase(clase11);
        academia.agregarClase(clase12);
        academia.agregarClase(clase13);
        academia.agregarClase(clase14);
        academia.agregarClase(clase15);

        // INSCRIBO ALUMNOS A CLASES EN MI AGENCIA
        academia.inscribirAlumno(alumno1,clase1);
        academia.inscribirAlumno(alumno1,clase2);
        academia.inscribirAlumno(alumno1,clase13);

        academia.inscribirAlumno(alumno2,clase4);
        academia.inscribirAlumno(alumno2,clase3);
        academia.inscribirAlumno(alumno2,clase5);

        academia.inscribirAlumno(alumno3,clase6);
        academia.inscribirAlumno(alumno3,clase1);
        academia.inscribirAlumno(alumno3,clase2);
        academia.inscribirAlumno(alumno3,clase12);
        academia.inscribirAlumno(alumno3,clase10);


        academia.inscribirAlumno(alumno4,clase3);
        academia.inscribirAlumno(alumno4,clase9);
        academia.inscribirAlumno(alumno4,clase14);
        academia.inscribirAlumno(alumno4,clase1);

        academia.inscribirAlumno(alumno5,clase7);
        academia.inscribirAlumno(alumno5,clase8);
        academia.inscribirAlumno(alumno5,clase11);
        academia.inscribirAlumno(alumno5,clase15);
        academia.inscribirAlumno(alumno5,clase10);

        // REGISTRO ASISTENCIA DE ALUMNOS EN LAS CLASES
        academia.registrarAsistencia(clase1,alumno1, LocalDate.now());                                      // TRUE
        academia.registrarAsistencia(clase2,alumno1, LocalDate.of(2024,9,20));       // TRUE
        academia.registrarAsistencia(clase13,alumno1, LocalDate.of(2024,10,15));     // TRUE
        academia.registrarAsistencia(clase4,alumno1, LocalDate.of(2024,10,12));      // FALSE
        academia.registrarAsistencia(clase4,alumno2, LocalDate.of(2024,10,22));      // TRUE
        academia.registrarAsistencia(clase3,alumno2, LocalDate.of(2024,9,11));       // TRUE
        academia.registrarAsistencia(clase3,alumno2, LocalDate.of(2024,9,7));        // TRUE
        academia.registrarAsistencia(clase1,alumno3, LocalDate.of(2024,10,5));       // TRUE
        academia.registrarAsistencia(clase6,alumno3, LocalDate.of(2024,10,9));       // TRUE
        academia.registrarAsistencia(clase10,alumno3, LocalDate.of(2024,9,12));      // TRUE
        academia.registrarAsistencia(clase3,alumno4, LocalDate.of(2024,10,24));      // TRUE
        academia.registrarAsistencia(clase3,alumno4, LocalDate.of(2024,10,21));      // TRUE
        academia.registrarAsistencia(clase4,alumno4, LocalDate.of(2024,9,30));       // FALSE
        academia.registrarAsistencia(clase8,alumno5, LocalDate.of(2024,10,15));      // TRUE
        academia.registrarAsistencia(clase2,alumno5, LocalDate.of(2024,10,5));       // FALSE
        academia.registrarAsistencia(clase14,alumno5, LocalDate.of(2024,9,8));       // FALSE

        System.out.println(academia.generarInformeDePagoAProfesores());

        // CLASES FACTURADAS: 1(CLASICO)($2000) - 2(BACHATA)($3000) - 3(CLASICO)($1500) - 4(SALSA)($4500) - 6(TANGO)($3000) - 8(ARABE)($1000) - 10(CLASICO)($2500) - 13(STRETCHING)($4000)
        System.out.println(academia.disciplinaMasReditua());
    }
}
