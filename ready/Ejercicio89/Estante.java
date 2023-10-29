package ready.Ejercicio89;

import java.util.*;

public class Estante {
    List<Libro> libros;
    Map<String,Integer> posicion;

    public Estante(){
        this.libros = new ArrayList<>();
    }

    public Estante(List<Libro> libros){
        libros = new ArrayList<>();
        for (Libro libro : libros){
            libros.add(libro);
            this.libros = libros;
        }
    }

    public void addLibro(Libro libro){
        libros.add(libro);
    }

    public void removeLibro(Libro libro){
        if (libros.contains(libro)){
           libros.remove(libro); 
        } else {
            throw new IllegalArgumentException("Este libro no esta en la estanteria");
        }
    }

    public boolean contains(Libro libro) {
        for (Libro book : libros){
            if (book.equals(libro)){
                return true;
            }
        }
        return false;
    }

    public List<Libro> getLibros() {
        return this.libros;
    }

    public int getPosicionLibro(Libro libro){
        for (int i = 0; i < libros.size(); i++){
            if(libros.get(i).equals(libro)){
                return i;
            }
        }
        return -1;
    }

}
