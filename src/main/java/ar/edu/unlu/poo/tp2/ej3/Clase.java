package ar.edu.unlu.poo.tp2.ej3;

import java.time.LocalTime;
import java.util.ArrayList;

public class Clase {
    private Nivel nivel;
    private Disciplina disciplina;
    private double precio;
    private Dia dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Profesor profesor;
    private ArrayList<Alumno> alumnosInscriptos;

    public Clase(Nivel nivel, Disciplina disciplina, double precio, Dia dia, LocalTime horaInicio, LocalTime horaFin, Profesor profesor) {
        this.nivel = nivel;
        this.disciplina = disciplina;
        this.precio = precio;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.profesor = profesor;
        alumnosInscriptos = new ArrayList<>();
    }

    public void inscribirAlumno(Alumno alumno){
        alumnosInscriptos.add(alumno);
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public double getPrecio() {
        return precio;
    }

    public Dia getDia() {
        return dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public int cantidadAlumnosInscriptos(){
        return alumnosInscriptos.size();
    }

    public boolean existeAlumno(Alumno alumno){
        return alumnosInscriptos.contains(alumno);
    }

}
