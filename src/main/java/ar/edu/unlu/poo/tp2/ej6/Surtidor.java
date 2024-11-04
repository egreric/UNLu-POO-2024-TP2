package ar.edu.unlu.poo.tp2.ej6;

public class Surtidor {
    private int codigo;
    private Combustible combustible;

    public Surtidor (int codigo, Combustible combustible){
        this.codigo = codigo;
        this.combustible = combustible;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public double getPrecioCombustiblePorLitro(){
        return this.combustible.getPrecioLitro();
    }

    public TipoCombustible getTipoCombustible(){
        return this.combustible.getTipoCombustible();
    }

    @Override
    public String toString(){
        return "Codigo: " + getCodigo() + " - Tipo Combustible: " + getTipoCombustible() + " - Precio Litro: $" + getPrecioCombustiblePorLitro();
    }
}
