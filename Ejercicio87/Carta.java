package Ejercicio87;

public class Carta{
    public String valor;
    public String palo;
    public String color;

    public Carta(String valor, String palo){
        this.palo = palo;
        this.valor = valor;
        
        if(palo == "C" || palo == "D"){
            this.color = "R";
        } else {
            this.color = "N";
        }
    }
}
