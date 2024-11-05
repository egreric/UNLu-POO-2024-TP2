package ar.edu.unlu.poo.tp2.ej6y7;

import java.time.LocalDate;

public class Venta {
    private Cliente cliente;
    private String patente;
    private Vendedor vendedor;
    private LocalDate fecha;
    private Surtidor surtidor;
    private double monto;
    private double cantidadLitros;
    private double descuento;

    /* el atributo fecha no deberia pasarse como parametro a la hora de crear el constructor, ya que la venta se
    * cargaria con la fecha del dia que se vendio (es decir con LocalDate.now()), pero para practicar con distintas
    * fechas lo pasamos por parametro
    */
    public Venta(Cliente cliente, String patente, Vendedor vendedor, Surtidor surtidor, LocalDate fecha, double cantidadLitros, double descuento){
        this.cliente = cliente;
        this.patente = patente;
        this.vendedor = vendedor;
        this.fecha = fecha;
        this.surtidor = surtidor;
        this.cantidadLitros = cantidadLitros;
        this.descuento = descuento;
        this.monto = (surtidor.getPrecioCombustiblePorLitro() * cantidadLitros)*(1-(descuento/100));
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
        return this.surtidor.getTipoCombustible();
    }

    public int getCodigoSurtidor(){
        return this.surtidor.getCodigo();
    }

    public double getMonto() {
        return monto;
    }

    public double getCantidadLitros() {
        return cantidadLitros;
    }

    public double getDescuento(){ return descuento; }

    @Override
    public String toString(){
        return  "Fecha: " + getFecha() +
                " | Cliente: " + getCliente().toString() +
                " | Vendedor: " + getVendedor().toString() +
                " | Surtidor: " + getCodigoSurtidor() +
                " | Monto: " + getMonto() +
                " | Litros: " + getCantidadLitros() +
                " | Tipo Combustible: " + getTipoCombustible();
    }
}
