package ar.edu.unlu.poo.tp2.ej14;

public class PaqueteTurismo {
    private String destino;
    private MedioTransporte medioTransporte;
    private Hospedaje hospedaje;
    private GuiaTurismo guiaTurismo;
    private int maximoClientes;


    public PaqueteTurismo(String destino, MedioTransporte medioTransporte, Hospedaje hospedaje, GuiaTurismo guiaTurismo, int maximoClientes) {
        this.destino = destino;
        this.medioTransporte = medioTransporte;
        this.hospedaje = hospedaje;
        this.guiaTurismo = guiaTurismo;
        this.maximoClientes = maximoClientes;
    }

    public double getPrecioPaquetePorPersona(){
        return getPrecioPaqueteTotal()/maximoClientes;
    }

    public double getPrecioPaqueteTotal(){
        return medioTransporte.calcularTotal(maximoClientes) + hospedaje.calcularTotal(maximoClientes) + guiaTurismo.calcularTotal(maximoClientes);
    }



    public String getDestino() {
        return destino;
    }

    public MedioTransporte getMedioTransporte() {
        return medioTransporte;
    }

    public Hospedaje getHospedaje() {
        return hospedaje;
    }

    public GuiaTurismo getGuiaTurismo() {
        return guiaTurismo;
    }
}
