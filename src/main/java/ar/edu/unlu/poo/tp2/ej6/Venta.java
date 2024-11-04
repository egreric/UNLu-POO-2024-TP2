package ar.edu.unlu.poo.tp2.ej6;

import java.time.LocalDate;

public class Venta {
    private Cliente cliente;
    private String patente;
    private Vendedor vendedor;
    private LocalDate fecha;
    private TipoCombustible tipoCombustible;
    private double monto;
    private double cantidadLitros;


    /* el atributo fecha no deberia pasarse como parametro a la hora de crear el constructor, ya que la venta se
    * cargaria con la fecha del dia que se vendio (es decir con LocalDate.now()), pero para practicar con distintas
    * fechas lo pasamos por parametro
    */
    public Venta(Cliente cliente, String patente, Vendedor vendedor, Surtidor surtidor, LocalDate fecha, double cantidadLitros){
        this.cliente = cliente;
        this.patente = patente;
        this.vendedor = vendedor;
        this.fecha = fecha;
        this.tipoCombustible = surtidor.getTipoCombustible();
        this.cantidadLitros = cantidadLitros;
        this.monto = surtidor.getPrecioCombustiblePorLitro() * cantidadLitros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public double getMonto() {
        return monto;
    }

    public double getCantidadLitros() {
        return cantidadLitros;
    }

    @Override
    public String toString(){
        return  "Fecha: " + getFecha() +
                " | Cliente: " + getCliente().toString() +
                " | Vendedor: " + getVendedor().toString() +
                " | Monto: " + getMonto() +
                " | Litros: " + getCantidadLitros() +
                " | Tipo Combustible: " + getTipoCombustible();
    }
}
