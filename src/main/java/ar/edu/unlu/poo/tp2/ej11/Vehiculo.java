package ar.edu.unlu.poo.tp2.ej11;

public abstract class Vehiculo {
    protected String patente;
    protected double precioBase = 3000;
    protected boolean prestado;

    public Vehiculo(String patente){
        this.patente = patente;
        prestado = false;
    }

    public String getPatente() {
        return patente;
    }

    public double calcularCostoAlquiler(int cantidadDias) {
        return precioBase * cantidadDias;
    }

    public void prestar(){
        prestado = true;
    }

    public void devolver(){
        prestado = false;
    }

    public boolean estaPrestado(){
        return prestado;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        return (this.patente.equals(((Vehiculo) obj).patente));

    }

    @Override
    public String toString(){
        return "TIPO: " + this.getClass().getSimpleName() + " - Patente: " + getPatente();
    }
}
