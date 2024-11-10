package ar.edu.unlu.poo.tp2.ej8;

public abstract class Publicacion {

    protected String nombre;
    protected String editor;
    protected String telefonoContacto;

    public Publicacion(String nombre, String editor, String telefonoContacto){
        this.nombre = nombre;
        this.editor = editor;
        this.telefonoContacto = telefonoContacto;
    }

    public String getNombre() { return nombre; }

    public String getEditor() {
        return editor;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }
}
