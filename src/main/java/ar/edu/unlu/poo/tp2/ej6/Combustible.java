package ar.edu.unlu.poo.tp2.ej6;

public class Combustible {
    private TipoCombustible tipoCombustible;
    private double precioLitro;

    public Combustible(TipoCombustible tipoCombustible, double precioLitro){
        this.tipoCombustible = tipoCombustible;
        this.precioLitro = precioLitro;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public double getPrecioLitro() {
        return precioLitro;
    }

    public void setPrecioLitro(double precioLitro) {
        this.precioLitro = precioLitro;
    }
}
