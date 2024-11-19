package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej1.Actividad;
import ar.edu.unlu.poo.tp2.ej1.Club;
import ar.edu.unlu.poo.tp2.ej1.Socio;
import ar.edu.unlu.poo.tp2.ej1.TipoSuscripcion;

import java.time.LocalDate;

public class MainEj1 {
    public static void main(String[] args){
        Club club = new Club();

        club.registrarSocio(new Socio("Juan Pérez", "Calle Falsa 123", "juanperez@gmail.com",
                LocalDate.of(2024, 10, 5), TipoSuscripcion.BASICA));
        club.registrarSocio(new Socio("Maria García", "Calle Real 456", "mariagarcia@gmail.com",
                LocalDate.of(2024, 9, 15), TipoSuscripcion.INTERMEDIA));
        club.registrarSocio(new Socio("Luis Martínez","Avenida Central 789", "luismartinez@gmail.com",
                LocalDate.of(2024, 10, 1), TipoSuscripcion.DESTACADA));
        club.registrarSocio(new Socio("Carlos Sanchez", "Avellaneda 1523", "cjsanchez@gmail.com",
                LocalDate.of(2024, 8, 2), TipoSuscripcion.BASICA));
        club.registrarSocio(new Socio("Javier Paz", "Lamadrid 675", "jpazz@gmail.com",
                LocalDate.of(2024, 7, 2), TipoSuscripcion.DESTACADA));
        club.registrarSocio(new Socio("Marcelo Melo", "Italia 1441", "mmelo@gmail.com",
                LocalDate.of(2024, 10, 1), TipoSuscripcion.DESTACADA));

        club.registrarActividad(new Actividad("Natacion", TipoSuscripcion.BASICA));
        club.registrarActividad(new Actividad("Gimnasio", TipoSuscripcion.INTERMEDIA));
        club.registrarActividad(new Actividad("Yoga", TipoSuscripcion.DESTACADA));
        club.registrarActividad(new Actividad("Spinning", TipoSuscripcion.INTERMEDIA));
        club.registrarActividad(new Actividad("Funcional", TipoSuscripcion.DESTACADA));
        club.registrarActividad(new Actividad("Crossfit", TipoSuscripcion.BASICA));

        System.out.println(club.reporteNuevosSocios());
        System.out.println(club.reporteActividadesPorTipoSuscripcion());
        System.out.println(club.listadoSociosPorTipoSuscripcion());
    }
}