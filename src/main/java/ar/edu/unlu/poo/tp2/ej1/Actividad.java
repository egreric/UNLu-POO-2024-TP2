package ar.edu.unlu.poo.tp2.ej1;

public class Actividad {
    private String descripcion;
    private TipoSuscripcion suscripcionRequerida;

    public Actividad(String descripcion, TipoSuscripcion tipoSuscripcion){
        this.descripcion = descripcion;
        this.suscripcionRequerida = tipoSuscripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoSuscripcion getSuscripcionRequerida(){
        return suscripcionRequerida;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSuscripcionRequerida(TipoSuscripcion suscripcionRequerida) {
        this.suscripcionRequerida = suscripcionRequerida;
    }
}
