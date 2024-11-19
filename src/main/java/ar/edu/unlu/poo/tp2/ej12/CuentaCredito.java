package ar.edu.unlu.poo.tp2.ej12;

import java.util.ArrayList;

public class CuentaCredito {
    private double limiteSaldo;
    private static final double RECARGO_FIJO = 0.05;
    private ArrayList<Double> compras;

    private ArrayList<Double> pagos;

    public CuentaCredito(double limiteSaldo){
        this.limiteSaldo = limiteSaldo;
        compras = new ArrayList<>();
        pagos = new ArrayList<>();
    }

    public boolean comprar(double monto){
        boolean resultado = false;
        if (monto <= getSaldoDisponible()){
            compras.add(monto);
            pagos.add(0.0);
            resultado = true;
        }
        return resultado;
    }

    public boolean pagar(int indiceCompra, double monto){
        boolean resultado = false;
        if (indiceCompra <= this.compras.size()){
            if (monto <= getSaldoDeudorPorCompra(indiceCompra)){
                pagos.set(indiceCompra-1, (pagos.get(indiceCompra-1) + monto));
                resultado = true;
            }
        }
        return resultado;
    }

    public double getSaldoDeudor(){
        double total = 0;
        for (int i = 0; i < compras.size(); i++){
            total += getSaldoDeudorPorCompra(i+1);
        }
        return total;
    }

    public double getSaldoDeudorPorCompra(int indiceCompra) {
        return (compras.get(indiceCompra-1) * (1 + RECARGO_FIJO)) - pagos.get(indiceCompra-1);
    }

    // Primero calculo todas mis deudas(sin tener en cuenta el interes) y luego se lo resto a mi limite de compra, eso me da el saldo actual disponible para compras
    public double getSaldoDisponible() {
        double deudaSinInteres = 0;
        for (int i = 0; i < compras.size(); i++){
            if (pagos.get(i) < compras.get(i)){
                deudaSinInteres += (compras.get(i) - pagos.get(i));
            }
        }
        return (limiteSaldo - deudaSinInteres);
    }




}
