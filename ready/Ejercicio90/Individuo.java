package ready.Ejercicio90;

import java.util.Objects;

public class Individuo {
    private String nombre;
    private String direccion;
    private int telefono;
    
    
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getTelefono() {
        return telefono;
    }

    public Individuo(String nombre, String direccion, int telefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

    }

    @Override 
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Individuo that = (Individuo) other;
        return this.nombre.equals(that.nombre) && this.direccion.equals(that.direccion) && this.telefono == that.telefono;
    }

    @Override
     public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, direccion);
    }

}
