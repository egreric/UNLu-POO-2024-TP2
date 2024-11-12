package ar.edu.unlu.poo.tp2;

import ar.edu.unlu.poo.tp2.ej9.*;

import java.util.ArrayList;

public class mainEj9 {
    public static void main(String[] args) {

        ArrayList<Figura> figuras = new ArrayList<>();
        // Agrego figuras de dos dimensiones
        figuras.add(new Circulo(5));
        figuras.add(new Rectangulo(5,3));
        figuras.add(new Cuadrado(5));
        figuras.add(new Triangulo(5,3));
        // Agrego figuras de tres dimensiones
        figuras.add(new Esfera(5));
        figuras.add(new Paralelepipedo(5,3,4));
        figuras.add(new Cubo(5));
        figuras.add(new Tetraedro(5));

        for(Figura f:figuras){
            System.out.print("Tipo Figura: " + f.getClass().getSimpleName() + " - Area: " + String.format("%.2f",f.getArea()));
            if (f instanceof FiguraTresDimensiones){
                System.out.print(" - Volumen: " + String.format("%.2f",((FiguraTresDimensiones) f).getVolumen()));
            }
            System.out.println();
        }
        
     }

}
