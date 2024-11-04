package ar.edu.unlu.poo.tp2.ej3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Academia {
    private String nombre;
    private ArrayList<Alumno> listadoAlumnos;
    private ArrayList<Clase> listadoClases;
    private ArrayList<Profesor> listadoProfesores;
    private ArrayList<Asistencia> listadoAsistencias;

    public Academia(String nombre){
        this.nombre = nombre;
        listadoAlumnos = new ArrayList<>();
        listadoClases = new ArrayList<>();
        listadoProfesores = new ArrayList<>();
        listadoAsistencias = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno){
        listadoAlumnos.add(alumno);
    }

    public void agregarClase(Clase clase){
        listadoClases.add(clase);
    }

    public void agregarProfesor(Profesor profesor){
        listadoProfesores.add(profesor);
    }

    public void registrarAsistencia(Clase clase, Alumno alumno, LocalDate fecha){
        if (listadoClases.contains(clase) && listadoAlumnos.contains(alumno)) {
            if (clase.existeAlumno(alumno)) {
                listadoAsistencias.add(new Asistencia(clase, alumno, fecha));
            }
        }
    }

    public String generarInformeDePagoAProfesores(){
        String listado = "Listado para los Profesores: \n";
        Map<String, Integer> asistenciasPorProfesor = new HashMap<>();
        String nombreProfesor;
        for (Asistencia a: listadoAsistencias){
            nombreProfesor = a.getClase().getProfesor().getNombre();
            asistenciasPorProfesor.put(nombreProfesor, asistenciasPorProfesor.getOrDefault(nombreProfesor,0) + 1);
        }

        double gananciaPorAlumno = 10.0;
        for (Map.Entry<String, Integer> entrada: asistenciasPorProfesor.entrySet()){
            listado += "Profesor: " + entrada.getKey() + " - Total a pagarle: $" + (entrada.getValue()*gananciaPorAlumno) + " (" + entrada.getValue() + " Alumnos)\n";
        }

        return listado;
    }

    public void inscribirAlumno(Alumno alumno, Clase clase) {
        if (listadoClases.contains(clase) && listadoAlumnos.contains(alumno)){
            clase.inscribirAlumno(alumno);
        }
    }

    public String disciplinaMasReditua() {
        Map<Disciplina, Double> ventasPorDisciplina = new HashMap<>();
        Disciplina disciplina;
        for (Clase c:listadoClases){
            disciplina = c.getDisciplina();
            ventasPorDisciplina.put(disciplina, ventasPorDisciplina.getOrDefault(disciplina,0.0) + c.getPrecio()*c.cantidadAlumnosInscriptos());
        }

        Disciplina disciplinaMayorIngreso = null;
        double ingresoMaximo = -1;
        for (Map.Entry<Disciplina, Double> entrada: ventasPorDisciplina.entrySet()){
            if (entrada.getValue() > ingresoMaximo){
                disciplinaMayorIngreso = entrada.getKey();
                ingresoMaximo = entrada.getValue();
            }
        }
        return "La Disciplina que mayor ingreso tuvo fue: " + disciplinaMayorIngreso + " Con un total de $" + ingresoMaximo + " Ingresados";
    }
}
