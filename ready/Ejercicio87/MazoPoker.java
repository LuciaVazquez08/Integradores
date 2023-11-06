package ready.Ejercicio87;

import java.util.*;

public class MazoPoker {
    private Deque<Carta> mazo;


    private MazoPoker(){
        mazo = new LinkedList<>();
        String[] palos = {"D", "C", "T", "P"};
        String[] valores = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos){
            for (String valor : valores){
                mazo.add(new Carta(valor, palo));
            }
        }
    }

    public MazoPoker crearMazoPoker(){
        return new MazoPoker();
    }

    public void barajar(){
        List<Carta> mazoLista = new ArrayList<>(mazo);
        Collections.shuffle(mazoLista);
        mazo = new LinkedList<>(mazoLista);
    }

    public List<Carta> sacarCartasArriba(int cantidad){
        List<Carta> cartas = new ArrayList<>();
        if (cantidad <= mazo.size()){
            for (int i = 0; i < cantidad; i++){
                cartas.add(mazo.removeFirst());
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
                cartas.add(mazo.removeLast());
            }
        } else {
            throw new IllegalArgumentException("No hay suficientes cartas");
        }
        return cartas;
    }

    public void colocarCartasArriba(List<Carta> cartas){
        Collections.reverse(cartas);
        for (Carta carta : cartas) {
           mazo.addFirst(carta); 
        }
    }

    public void colocarCartasAbajo(List<Carta> cartas){
        mazo.addAll(cartas);
    }

    public void ordenar(String[] orden_palos){
        List<Carta> ordenadas = new ArrayList<>(mazo);
        int n = mazo.size();
        boolean hubo_cambio;

        do {
            hubo_cambio = false;
            for (int i = 1; i < n; i++){
                Carta carta1 = ordenadas.get(i);
                Carta carta2 = ordenadas.get(i-1);

                if(comparacion(carta1, carta2, orden_palos) > 0){
                    ordenadas.set(i-1, carta1);
                    ordenadas.set(i, carta2);
                    hubo_cambio = true;
                }
            }
            n--;
        } while (hubo_cambio);

        mazo = new LinkedList<>(ordenadas);
    }

    private int comparacion(Carta carta1, Carta carta2, String[] orden_palos) {
        String palo1 = carta1.getPalo();
        int valor1 = carta1.getValorInt();

        String palo2 = carta2.getPalo();
        int valor2 = carta2.getValorInt();

        List<String> palos = new ArrayList<>(Arrays.asList(orden_palos));

        int comparacion = Integer.compare(palos.indexOf(palo1), palos.indexOf(palo2));
        
        if (comparacion == 0){
            return Integer.compare(valor1, valor2);
        }
        return comparacion;
    }
}





