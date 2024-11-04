package ar.edu.unlu.poo.tp2.ej3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Asistencia {
    private Clase clase;
    private Alumno alumno;
    private LocalDate fecha;

    public Asistencia(Clase clase, Alumno alumno, LocalDate fecha){
        this.clase = clase;
        this.fecha = fecha;
        this.alumno = alumno;
    }

    public Clase getClase() {
        return clase;
    }

    public Alumno getAlumno(){
        return alumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
