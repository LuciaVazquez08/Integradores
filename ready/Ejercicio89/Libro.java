package ready.Ejercicio89;

import java.util.Objects;

public class Libro {
    private String name;
    private String autor;
    private String editorial;
    private int fecha_publicacion;

    public void setFecha_publicacion(int fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public Libro(String name, String autor, String editorial,int fecha_publicacion){
        this.name = name;
        this.autor = autor;
        this.editorial = editorial;
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }
    
    public int getFecha_publicacion() {
        return fecha_publicacion;
    }

    @Override 
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Libro that = (Libro) other;
        return this.name.equals(that.name) && this.autor.equals(that.autor) && this.fecha_publicacion == that.fecha_publicacion && this.editorial.equals(that.editorial);
    }

    @Override
     public int hashCode() {
        return Objects.hash(super.hashCode(), name, autor, editorial,fecha_publicacion);
    }
}
