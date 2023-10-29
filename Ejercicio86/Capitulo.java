package Ejercicio86;

import java.util.List;

public class Capitulo {
    private String nombre;
    private List<Pagina> paginas;
    private int paginaInicial;
    private int paginaFinal;

    public Capitulo(String nombre, List<Pagina> paginas, int paginaInicial, int paginaFinal) {
        this.nombre = nombre;
        this.paginas = paginas;
        this.paginaInicial = paginaInicial;
        this.paginaFinal = paginaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public int getPaginaInicial() {
        return paginaInicial;
    }

    public int getPaginaFinal() {
        return paginaFinal;
    }
}
