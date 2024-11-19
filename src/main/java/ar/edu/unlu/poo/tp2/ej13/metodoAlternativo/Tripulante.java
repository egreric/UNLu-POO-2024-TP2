package ar.edu.unlu.poo.tp2.ej13.metodoAlternativo;

import java.util.ArrayList;

public class Tripulante extends Rol {
    private String cargo;
    private ArrayList<ReciboSueldo> recibosDeSueldo;

    public Tripulante(String cargo) {
        this.cargo = cargo;
        recibosDeSueldo = new ArrayList<>();
    }

    public String getCargo() {
        return cargo;
    }

    public void agregarReciboSueldo(int valor) {
        recibosDeSueldo.add(new ReciboSueldo(valor));
    }

    public String informeRecibosDeSueldo() {
        String s = "----- RECIBOS DE SUELDO (IMPORTES) -----";
        int i = 1;
        if (!recibosDeSueldo.isEmpty()) {
            for (ReciboSueldo r : recibosDeSueldo) {
                s += "Recibo " + i + ": $" + r.getValor();
                i++;
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return "Cargo: " + getCargo();
    }
}


