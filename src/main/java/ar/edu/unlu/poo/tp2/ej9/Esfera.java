package ar.edu.unlu.poo.tp2.ej9;

public class Esfera extends FiguraTresDimensiones{

    private double radio;

    public Esfera(double radio){
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double getArea(){
        return 4 * Math.PI * Math.pow(radio,2);
    }

    @Override
    public double getVolumen(){
        return (4.0/3.0) * Math.PI * Math.pow(radio,3);
    }
}
