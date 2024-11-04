package ar.edu.unlu.poo.tp2.ej1;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Club {
    private ArrayList<Socio> listadoSocios;
    private ArrayList<Actividad> listadoActividades;

    public Club(){
        listadoSocios = new ArrayList<>();
        listadoActividades = new ArrayList<>();
    }

    public void registrarSocio(Socio socio){
        listadoSocios.add(socio);
    }

    public void registrarActividad(Actividad actividad){
        listadoActividades.add(actividad);
    }

    public String reporteNuevosSocios(){
        String listado = "--- REPORTE DE NUEVOS INSCRIPTOS DEL MES ---\n";
        Month mesActual = LocalDate.now().getMonth();
        for (Socio s:listadoSocios){
            if (s.getFechaInscripcion().getMonth() == mesActual){
                listado += ("Nombre: " + s.getNombre() + " - Direccion: " + s.getDireccion() + " - E-mail: " + s.getEmail()
                        + " - Fecha Inscripcion: " + s.getFechaInscripcion() + " - Tipo Inscripcion: " + s.getTipoSuscripcion() + "\n");
            }
        }
        if (listado.equals("--- REPORTE DE NUEVOS INSCRIPTOS DEL MES ---\n")){
            return ("No hay socios nuevos este mes.");
        } else {
            return listado;
        }
    }

    public String reporteActividadesPorTipoSuscripcion(){
        String actividadesBasicas = "ACTIVIDADES BASICAS:\n";
        String actividadesIntermedias = "ACTIVIDADES INTERMEDIAS:\n";
        String actividadesDestacadas = "ACTIVIDADES DESTACADAS:\n";
        for (Actividad a: listadoActividades){
            if (a.getSuscripcionRequerida().equals(TipoSuscripcion.BASICA))
                actividadesBasicas += a.getDescripcion() + "\n";
            if (a.getSuscripcionRequerida().equals(TipoSuscripcion.INTERMEDIA))
                actividadesIntermedias += a.getDescripcion() + "\n";
            if (a.getSuscripcionRequerida().equals(TipoSuscripcion.DESTACADA))
                actividadesDestacadas += a.getDescripcion() + "\n";
        }
        return "--- REPORTE DE ACTIVIDADES POR TIPO DE SUSCRIPCION ---\n" + actividadesBasicas + "\n" + actividadesIntermedias + "\n" + actividadesDestacadas;
    }

    public String listadoSociosPorTipoSuscripcion(){
        String sociosBasicos = "SOCIOS BASICOS: \n";
        String sociosIntermedios = "SOCIOS INTERMEDIOS: \n";
        String sociosDestacados = "SOCIOS DESTACADOS: \n";
        String datosSocio = "";
        for (Socio s: listadoSocios){
            datosSocio = ("Nombre: " + s.getNombre() + " - Direccion: " + s.getDireccion() + " - E-mail: " + s.getEmail()
                    + " - Fecha Inscripcion: " + s.getFechaInscripcion() + "\n");
            if (s.getTipoSuscripcion().equals(TipoSuscripcion.BASICA))
                sociosBasicos += datosSocio;
            if (s.getTipoSuscripcion().equals(TipoSuscripcion.INTERMEDIA))
                sociosIntermedios += datosSocio;
            if (s.getTipoSuscripcion().equals(TipoSuscripcion.DESTACADA))
                sociosDestacados += datosSocio;

        }
        return "--- REPORTE DE SOCIOS POR TIPO DE SUSCRIPCION ---\n" + sociosBasicos + "\n" + sociosIntermedios + "\n" + sociosDestacados;
    }

}


