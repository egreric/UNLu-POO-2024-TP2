package ar.edu.unlu.poo.tp2.ej9;

public class Circulo extends FiguraDosDimensiones{
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public double getRadio(){
        return this.radio;
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(radio,2);
    }
}
