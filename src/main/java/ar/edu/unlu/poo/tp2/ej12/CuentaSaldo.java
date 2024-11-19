package ar.edu.unlu.poo.tp2.ej12;

import java.time.LocalDate;

public abstract class CuentaSaldo extends Cuenta {
    protected double saldo;
    protected double saldoInvertido;
    public static final double INTERES_POR_INVERSION_MAXIMO = 0.4;
    public static final double INTERES_POR_INVERSION_MINIMO = 0.05;
    public static final int PLAZO_DIAS_INVERSION_MINIMO = 30;
    public static final int PLAZO_DIAS_INVERSION_MAXIMO = 120;
    protected LocalDate fechaInversion;
    protected boolean precanceladoAutomatico;

    public CuentaSaldo(double saldo){
        this.saldo = saldo;
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

    public abstract void depositar(double monto);

    public abstract boolean comprar (double monto);

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

    public boolean isPrecanceladoAutomatico() {
        return precanceladoAutomatico;
    }

}
