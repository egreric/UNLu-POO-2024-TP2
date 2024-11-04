package ar.edu.unlu.poo.tp2.ej4y5;

import java.time.LocalDate;

public class CuentaNormal {
    private double saldo;
    private double limiteGiroDescubierto;
    private double giroDescubierto;
    private double saldoInvertido;
    public static final double INTERES_POR_INVERSION_MAXIMO = 0.4;
    public static final double INTERES_POR_INVERSION_MINIMO = 0.05;
    public static final int PLAZO_DIAS_INVERSION_MINIMO = 30;
    public static final int PLAZO_DIAS_INVERSION_MAXIMO = 120;
    private LocalDate fechaInversion;
    private boolean precanceladoAutomatico;

    public CuentaNormal(double saldo, double limiteGiroDescubierto){
        this.saldo = saldo;
        this.limiteGiroDescubierto = limiteGiroDescubierto;
        giroDescubierto = 0;
        saldoInvertido = 0;
        fechaInversion = null;
        precanceladoAutomatico = false;
    }

    public void activarPrecanceladoAutomatico(){
        precanceladoAutomatico = true;
    }

    public void desactivarPrecanceladoAutomatico(){
        precanceladoAutomatico = false;
    }

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

    public boolean invertir(double monto){
        boolean resultado = false;
        if (saldoInvertido == 0 && monto <= saldo){
            saldoInvertido = monto;
            fechaInversion = LocalDate.now();
            saldo -= monto;
            resultado = true;
        }
        return resultado;
    }

    // averiguar si puedo hacer la compra (preguntar antes si la cuenta es precanceladaAutoamticamente o no ya que eso me da mas monto disponible)
    // si la puedo hacer
    public boolean gastar(double monto){
        boolean resultado = false;
        if (precanceladoAutomatico && (saldo + getInteresAGanar() + getMontoInvertido() + (limiteGiroDescubierto - giroDescubierto) >= monto) ) {
            if (saldo < monto) {
                retirarInversion();
            }
        }

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

    public double getMontoInvertido(){
        return this.saldoInvertido;
    }

    public double getInteresAGanar(){
        if(fechaInversion != null) {
            return this.saldoInvertido * INTERES_POR_INVERSION_MAXIMO;
        }
        return 0.0;
    }

    public double getInteresGanado(){
        if(fechaInversion != null) {
            if (LocalDate.now().isAfter(fechaInversion.plusDays(PLAZO_DIAS_INVERSION_MINIMO))) {
                if (LocalDate.now().isAfter(fechaInversion.plusDays(PLAZO_DIAS_INVERSION_MAXIMO))) {
                    return saldoInvertido * INTERES_POR_INVERSION_MAXIMO;
                } else {
                    return saldoInvertido * INTERES_POR_INVERSION_MINIMO;
                }
            }
        }
        return 0.0;
    }

    /*  1 - Preguntar si cumplo con el plazo de dias minimo (para eso pregunto si la fecha de hoy es despues de la fecha
     *       de la inversion + la suma de dias minimos para obtenerla)
     *   2 - Sino cumplo con el minimo entonces no tengo interes por ganar)
     *   3 - Si cumplo con el minimo tengo que saber si cumplo con el maximo tambien
     *   4 - Si cumpli con el maximo plazo de dias retorno maximo interes, sino retorno el minimo
     */
    public boolean retirarInversion(){
        boolean resultado = false;
        if(fechaInversion != null) {
            saldo += saldoInvertido + getInteresGanado();
            saldoInvertido = 0;
            fechaInversion = null;
            resultado = true;
        }
        return resultado;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteGiroDescubierto() {
        return limiteGiroDescubierto;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public boolean isPrecanceladoAutomatico() {
        return precanceladoAutomatico;
    }
}
