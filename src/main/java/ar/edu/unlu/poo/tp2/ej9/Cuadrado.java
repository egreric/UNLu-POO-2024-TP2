package ar.edu.unlu.poo.tp2.ej9;

public class Cuadrado extends FiguraDosDimensiones{
    private double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }

    public double getLado(){
        return lado;
    }

    @Override
    public double getArea(){
        return lado * lado;
    }
}
