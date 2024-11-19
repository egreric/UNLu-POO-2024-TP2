package ar.edu.unlu.poo.tp2.ej14;

public class MedioTransporte extends Proveedor {
    private TipoTransporte tipoTransporte;

    public MedioTransporte(String nombre, String telefono, double precioBase, TipoTransporte tipoTransporte) {
        super(nombre, telefono, precioBase);
        this.tipoTransporte = tipoTransporte;
    }


    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    @Override
    public double calcularMontoExtra(int maxClientes) {
        return maxClientes * (getPrecioBase() * 0.003);
    }
}
