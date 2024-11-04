package ar.edu.unlu.poo.tp2.ej4y5;

public class Cliente {
    private String nombre;
    private String dni;
    private CuentaNormal cuenta;
    private CuentaCredito cuentaCredito;

    public Cliente(String nombre, String dni, CuentaNormal cuentaNormal){
        this.nombre = nombre;
        this.dni = dni;
        this.cuenta = cuentaNormal;
        this.cuentaCredito = null;
    }

    public Cliente(String nombre, String dni, CuentaNormal cuentaNormal, CuentaCredito cuentaCredito){
        this.nombre = nombre;
        this.dni = dni;
        this.cuenta = cuentaNormal;
        this.cuentaCredito = cuentaCredito;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public boolean realizarGasto(double monto){
        double saldo = this.cuenta.getSaldo();
        if (cuenta.isPrecanceladoAutomatico()){
            saldo += cuenta.getInteresGanado() + cuenta.getMontoInvertido();
        }
        if(monto > saldo) {
            System.out.println("No se puede realizar el gasto, se va a girar en descubierto..");
            return false;
        }else {
            return this.cuenta.gastar(monto);
        }
    }

    public boolean realizarGastoYGirar(double monto) {
        return this.cuenta.gastar(monto);
    }


    public void depositar(double monto){
        this.cuenta.depositar(monto);
    }

    public boolean recuperarInversion(){
        return this.cuenta.retirarInversion();
    }

    public boolean comprarConCredito(double monto){
        return this.cuentaCredito.comprar(monto);
    }

    public boolean pagarDeudaCredito(int indiceCompra, double monto){
        return this.cuentaCredito.pagar(indiceCompra, monto);
    }

    public boolean realizarInversion(double monto){
        return this.cuenta.invertir(monto);
    }

    public String mostrarEstado(){
        String estado = "--- Cuenta Saldo ----\n";
        estado += "Saldo: " + this.cuenta.getSaldo();
        estado += " - Giro en descubierto: " + this.cuenta.getLimiteGiroDescubierto() + "(" + this.cuenta.getGiroDescubierto() + ")";
        estado += " - Inversiones: " + this.cuenta.getMontoInvertido() + "(" + this.cuenta.getInteresAGanar() + ")\n";
        estado += "--- Cuenta crédito ----\n";
        estado += "Disponible para compras: " + this.cuentaCredito.getSaldoDisponible();
        estado += " - Saldo deudor: " + this.cuentaCredito.getSaldoDeudor();
        return estado;
    }
}
