package ar.edu.unlu.poo.tp2.ej4y5;

public class MainEj4 {
    public static void main(String[] args){
        CuentaNormal cuentaNormal = new CuentaNormal(10000,5000);
        cuentaNormal.activarPrecanceladoAutomatico();
        CuentaCredito cuentaCredito = new CuentaCredito(20000);
        Cliente u = new Cliente("Carlos","16.233.521",cuentaNormal,cuentaCredito);

        System.out.println("\nESTADIO INICIAL DE LAS CUENTAS ANTES DE REALIZAR ALGUNA OPERACION");
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("HAGO UN GASTO SIN GIRO POR $9350");
        u.realizarGasto(9350);
        u.depositar(9350);
        u.realizarInversion(9350);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("HAGO UN GASTO SIN GIRO POR $2500");
        u.realizarGasto(2500);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("VUELVO A INTENTAR EL GASTO PERO AHORA CON GIRO POR $2500");
        u.realizarGastoYGirar(2500);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");


        System.out.println("HAGO UNA INVERSION POR $1000");
        u.realizarInversion(1000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("NO PUDE HACER INVERSION (NO TENGO SALDO)");
        System.out.println("HAGO UN DEPOSITO POR $10000");
        u.depositar(10000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("HAGO UNA INVERSION POR $5000");
        u.realizarInversion(5000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("INTENTO RECUPERAR LA INVERSION INMEDIATAMENTE");
        u.recuperarInversion();
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("NO SE PUEDE RECUPERAR LA INVERSION (NO PASARON LOS DIAS SUFICIENTES)");
        System.out.println("REALIZO UNA COMPRA CON CREDITO POR $10000");
        u.comprarConCredito(10000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("REALIZO UNA COMPRA CON CREDITO POR $15000");
        u.comprarConCredito(15000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("NO PUEDO HACER LA COMPRA (NO TENIA CREDITO DISPONIBLE)");
        System.out.println("REALIZO UNA COMPRA CON CREDITO POR $3000");
        u.comprarConCredito(3000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("REALIZO PAGO DE MI SEGUNDA COMPRA ($2000)");
        u.pagarDeudaCredito(2,2000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("REALIZO PAGO DE MI SEGUNDA COMPRA (LO QUE RESTA, $1150)");
        u.pagarDeudaCredito(2,1150);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("REALIZO PAGO DE MI PRIMERA COMPRA SIN LOS INTERESES ($10000)");
        u.pagarDeudaCredito(1,10000);
        System.out.println(u.mostrarEstado());
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("REALIZO PAGO DE INTERESES DE MI PRIMERA COMPRA ($500)");
        u.pagarDeudaCredito(1,500);
        System.out.println(u.mostrarEstado());System.out.println("-------------------------------------------------------------------\n");

    }
}
