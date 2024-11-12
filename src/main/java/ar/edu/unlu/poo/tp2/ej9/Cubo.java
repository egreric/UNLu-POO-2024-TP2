package ar.edu.unlu.poo.tp2.ej9;

public class Cubo extends FiguraTresDimensiones{
    private double arista;

    public Cubo(double arista){
        this.arista = arista;
    }

    public double getArista() {
        return arista;
    }

    @Override
    public double getArea(){
        return 6 * Math.pow(arista,2);
    }

    @Override
    public double getVolumen(){
        return Math.pow(arista,3);
    }
}
