package ready.Ejercicio89;
import java.util.*;

public class Estanteria {
    private List<Estante> estantes;
   
    public Estanteria(){
        estantes = new ArrayList<>();
    }

    public Estanteria(int cant_estantes){
        estantes = new ArrayList<>(cant_estantes);
    }

    public List<Estante> getEstantes() {
            return estantes;
    }

    public void addEstante(Estante estante){
        estantes.add(estante);
    }

    public void addLibro(Estante estante, Libro libro){
        if (estantes.contains(estante)){
            estante.addLibro(libro);
        } else {
            addEstante(estante);
            estantes.get(estantes.size()-1).addLibro(libro);
        }
    }

    public void addLibro(int estante, Libro libro){
        if (estante > 0 && estante < estantes.size()){
            estantes.get(estante).addLibro(libro);            
        } else {
           throw new IndexOutOfBoundsException();
        }
    }

    public void removeLibro(Libro libro){
        for (Estante estante : estantes){
            if (estante.contains(libro)){
                estante.removeLibro(libro);
            }
        }
    }

    public void removeLibro(Estante estante, Libro libro){
        if (estantes.contains(estante)){
            if (estante.contains(libro)){
                estante.removeLibro(libro);
            } else {
                throw new IllegalArgumentException("No esta en esa estanteria");
            }
        } else {
            throw new IllegalArgumentException("no existe esa estanteria");
        }
    }

    public Object[] buscarLibro(Libro libro){
        Object[] ret = new Object[2];

        boolean is_found = false;
        Estante est = null;

        while (!is_found){
           for (Estante estante : estantes){
            for (Libro book : estante.getLibros()){
                if (book.equals(libro)){
                    est = estante;
                    is_found = true;
                    }
                }
           } 
        }

        if (est == null){
           ret[0] = null;
           ret[1] = null;
           
        } else { 
            ret[0] = est;
            ret[1] = est.getPosicionLibro(libro);
        }
        return ret;       
    } 

    public List<String> listarLibros(Estante estante){
        List<String> ret = new ArrayList<>();

        for (Libro libro: estante.getLibros()){
            ret.add(libro.getName());
        }

        return ret;
    }

    public void mostrar(Iterable<?> iterable){
        for (Object objeto : iterable){
            System.out.println(objeto.toString());
        }
    }

    public void reorganizarLibros(Estante estante){
        Collections.shuffle(estante.getLibros());
    }

    public int edadPormedio(Estante estante){
        int acumulado = 0;
        for (Libro book : estante.getLibros()){
            acumulado += book.getFecha_publicacion();
        }
        return (acumulado / estante.getLibros().size());
    }

    public List<String> buscarporAutor(){
        return new ArrayList<String>();
    }

    public List<Libro> listarLibrosAutor(){
        return new ArrayList<Libro>();
    }

}
