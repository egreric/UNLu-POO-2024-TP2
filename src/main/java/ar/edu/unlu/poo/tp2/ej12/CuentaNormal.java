package ar.edu.unlu.poo.tp2.ej12;

import java.time.LocalDate;

public class CuentaNormal extends CuentaSaldo{
    private double limiteGiroDescubierto;
    private double giroDescubierto;


    public CuentaNormal(double saldo, double limiteGiroDescubierto){
        super(saldo);
        this.limiteGiroDescubierto = limiteGiroDescubierto;
        this.giroDescubierto = 0;
    }

    @Override
    public void depositar(double monto){
        // Veo si hay giroDescubierto para cubrir
        if (giroDescubierto > 0){
            if (monto > giroDescubierto){
                monto -= giroDescubierto;
                giroDescubierto = 0;
            } else {
                giroDescubierto -= monto;
            }
        }
        if (monto > 0){
            saldo += monto;
        }
    }

    @Override
    public boolean comprar (double monto){
        boolean resultado = false;
        // Averiguo si tengo fondos para hacer la compra (saldo disponible + saldo de GiroDescubierto disponible + montoInvertido + interesesInversion, este
        // ultimo se tiene en cuenta si tengo habilitado el precancelar), si voy a necesitar de la inversion para completar la compra la retiro y actualizo mi saldo
        if (precanceladoAutomatico && (saldo + getInteresAGanar() + getMontoInvertido() + (limiteGiroDescubierto - giroDescubierto) >= monto) ) {
            if (saldo < monto) {
                retirarInversion();
            }
        }

        // Vuelvo a preguntar si tengo fondos para la compra, ya que la anterior comprobacion era para saber si necesito retirar mi inversion o no
        // si solo mi saldo alcanza descuento el monto sobre el, si el monto es mayor, dejo a saldo en 0 y descuento el restante a giroDescubierto(monto - saldo)
        if ((saldo + (limiteGiroDescubierto - giroDescubierto)) >= monto) {
            if (saldo < monto) {
                giroDescubierto += (monto - saldo);
                saldo = 0;
            } else {
                saldo -= monto;
            }
            resultado = true;
        }
        return resultado;
    }

    public double getLimiteGiroDescubierto() {
        return limiteGiroDescubierto;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

}
