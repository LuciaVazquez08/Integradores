package Ejercicio85;

public class Bloque {
    private int largo;
    private int ancho;
    private int altura;

    public Bloque(int largo, int ancho, int altura){
        this.altura = altura;
        this.largo = largo;
        this.ancho = ancho;
    }

    public int getLargo(){
        return largo;
    }

    public int getAncho(){
        return ancho;
    }

    public int getAltura(){
        return altura;
    }

}
