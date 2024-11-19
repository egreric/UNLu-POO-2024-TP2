package ar.edu.unlu.poo.tp2.ej13.metodoOriginal;


import java.util.ArrayList;

public class Tripulante extends Persona {
    private String cargo;
    private ArrayList<ReciboSueldo> recibosDeSueldo;

    public Tripulante(String nombre, String telefono, String direccion, String cargo) {
        super(nombre, telefono, direccion);
        this.cargo = cargo;
        recibosDeSueldo = new ArrayList<>();
    }

    public String getCargo() {
        return cargo;
    }

    public void agregarReciboSueldo(int valor){
        recibosDeSueldo.add(new ReciboSueldo(valor));
    }

    public String informeRecibosDeSueldo(){
        String s = "----- RECIBOS DE SUELDO (IMPORTES) -----";
        int i = 1;
        if (!recibosDeSueldo.isEmpty()){
            for (ReciboSueldo r: recibosDeSueldo){
                s += "Recibo " + i + ": $" + r.getValor();
                i++;
            }
        }
        return s;
    }

    @Override
    public String toString(){
        return super.toString() + " - Cargo: " + getCargo();
    }

}


