package Ejercicio87;

import java.util.*;

public class MazoPoker {
    private List<Carta> mazo;
    private List<String> orden;
    private Map<String, Integer> map;

    public MazoPoker(){
        mazo = new ArrayList<>();
        map = new HashMap<>();
        int posicion = 1;

        String[] palos = {"D", "C", "T", "P"};
        String[] valores = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos){
            for (String valor : valores){
                mazo.add(new Carta(valor, palo));
                map.put(palo+valor, posicion);
                posicion++;
            }
        }
        
        this.orden = (List<String>) map.keySet();
    }

    public void barajar1(){
        Collections.shuffle(orden);
        
    }

    public void barajar2(){
        Collections.shuffle(mazo);
    }

    public List<Carta> sacarCartasArriba(int cantidad){
        List<Carta> cartas = new ArrayList<>();
        if (cantidad <= mazo.size()){
            for (int i = 0; i < cantidad; i++){
                Carta carta = mazo.get(i);
                cartas.add(carta);
                map.remove(carta);
                orden.remove(carta);
                mazo.remove(i);
            }
        } else {
            throw new IllegalArgumentException("No hay suficientes cartas");
        }
        return cartas;
    }

    public List<Carta> sacarCartasAbajo(int cantidad){
        List<Carta> cartas = new ArrayList<>();
        if (cantidad <= mazo.size()){
            for (int i = 0; i < cantidad; i++){
                Carta carta = mazo.get(mazo.size() - 1 - i);
                cartas.add(carta);
                map.remove(carta);
                orden.remove(carta);
                mazo.remove(mazo.size() - 1 - i);
            }
        } else {
            throw new IllegalArgumentException("No hay suficientes cartas");
        }
        return cartas;
    }

    public void colocarCartasArriba(List<Carta> cartas){
        cartas.addAll(mazo);
        mazo.clear();
        mazo.addAll(cartas);

        
    }
}





