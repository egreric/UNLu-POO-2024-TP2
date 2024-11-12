package ar.edu.unlu.poo.tp2.ej9;

public class Triangulo extends FiguraDosDimensiones {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double getArea(){
        return (base * altura)/2;
    }


}
