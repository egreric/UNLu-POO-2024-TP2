package ar.edu.unlu.poo.tp2.ej8;

public class Revista extends PublicacionPrestable{
    private String issn;
    private int numero;
    private int anioPublicacion;

    public Revista(String nombre, String editor, String telefonoContacto, int totalEjemplares, String issn, int numero, int anioPublicacion){
        super(nombre,editor,telefonoContacto,totalEjemplares);
        this.issn = issn;
        this.numero = numero;
        this.anioPublicacion = anioPublicacion;
    }

    public String getIssn() {
        return issn;
    }

    public int getNumero() {
        return numero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
}
