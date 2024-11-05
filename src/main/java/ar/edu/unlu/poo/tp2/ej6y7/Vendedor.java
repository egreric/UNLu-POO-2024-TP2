package ar.edu.unlu.poo.tp2.ej6y7;

public class Vendedor {
    private String nombre;
    private String dni;
    private boolean aplicoDescuento;

    public Vendedor(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
        this.aplicoDescuento = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public boolean aplicoDescuento() {
        return aplicoDescuento;
    }

    public void aplicarDescuento(){
        this.aplicoDescuento = true;
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + " - DNI: " + getDni();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vendedor vendedor = (Vendedor) obj;

        return this.getNombre().equals(vendedor.getNombre()) && this.getDni().equals(vendedor.getDni());
    }

}
