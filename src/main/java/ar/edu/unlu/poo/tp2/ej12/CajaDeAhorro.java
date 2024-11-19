package ar.edu.unlu.poo.tp2.ej12;

public class CajaDeAhorro extends CuentaSaldo{
    public CajaDeAhorro(double saldo) {
        super(saldo);
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0){
            saldo += monto;
        }
    }

    // averiguar si puedo hacer la compra (preguntar antes si la cuenta es precanceladaAutoamticamente o no ya que eso me da mas monto disponible)
    // si la puedo hacer
    @Override
    public boolean comprar (double monto){
        boolean resultado = false;
        if (precanceladoAutomatico && (saldo + getInteresAGanar() + getMontoInvertido() >= monto) ) {
            if (saldo < monto) {
                retirarInversion();
            }
        }

        if (saldo >= monto) {
            saldo -= monto;
            resultado = true;
        }

        return resultado;
    }

}
