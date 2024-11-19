package ar.edu.unlu.poo.tp2.ej14;

public class Hospedaje extends Proveedor {
    private int minimoClientes;

    private TipoHospedaje tipoHospedaje;

    public Hospedaje(String nombre, String telefono, double precioBase, TipoHospedaje tipoHospedaje, int minimoClientes) {
        super(nombre, telefono, precioBase);
        this.tipoHospedaje = tipoHospedaje;
        this.minimoClientes = minimoClientes;
    }

    public TipoHospedaje getTipoHospedaje() {
        return tipoHospedaje;
    }

    @Override
    public double calcularMontoExtra(int maxClientes) {
        if (maxClientes > minimoClientes){
            return -(getPrecioBase() * (maxClientes - minimoClientes) * 0.005);
        } else {
            return 0;
        }
    }
}
