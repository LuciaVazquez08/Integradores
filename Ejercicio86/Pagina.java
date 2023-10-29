package Ejercicio86;

public class Pagina {
    private int numero;
    private String contenido;
    private String referencia;

    

    public Pagina(int numero, String contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }

    public int getNumero() {
        return numero;
    }

    public String getContenido() {
        return contenido;
    }
    
    public String getReferencia() {
        return referencia;
    }

    public void addReferencia(String texto){
        if (referencia == null){
            this.referencia = texto;
        }
    }
}
