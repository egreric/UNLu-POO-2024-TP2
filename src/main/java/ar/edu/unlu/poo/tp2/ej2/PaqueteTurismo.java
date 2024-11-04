package ar.edu.unlu.poo.tp2.ej2;

public class PaqueteTurismo {
    private String destino;
    private MedioTransporte medioTransporte;
    private Hospedaje hospedaje;
    private GuiaTurismo guiaTurismo;

    public PaqueteTurismo(String destino, MedioTransporte medioTransporte, Hospedaje hospedaje, GuiaTurismo guiaTurismo) {
        this.destino = destino;
        this.medioTransporte = medioTransporte;
        this.hospedaje = hospedaje;
        this.guiaTurismo = guiaTurismo;
    }

    public double getPrecioPaquete(){
        return medioTransporte.getPrecio() + hospedaje.getPrecio() + guiaTurismo.getPrecio();
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
