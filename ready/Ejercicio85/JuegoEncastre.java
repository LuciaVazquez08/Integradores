package ready.Ejercicio85;

import java.util.List;

public class JuegoEncastre {
    private List<Bloque> bloques;
    private List<Hueco> huecos;

    public JuegoEncastre(List<Bloque> bloques , List<Hueco> huecos){
        this.bloques = bloques;
        this.huecos = huecos;
    }

    public boolean checkLargo(Bloque bloque, Hueco hueco){
        if (bloque.getLargo() == hueco.getLargo()){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAncho(Bloque bloque, Hueco hueco){
        if (bloque.getAncho() == hueco.getAncho()){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkVol(Bloque bloque, Hueco hueco){
        if (bloque.getAltura() == hueco.getProfundidad()){
            return true;
        } else {
            return false;
        }
    }

    public boolean encastre(Bloque bloque, Hueco hueco){
        return (checkAncho(bloque, hueco) && checkLargo(bloque, hueco) && checkVol(bloque, hueco));
    }

    public int jugar(){
        if (bloques.size() != huecos.size()){
            throw new IllegalArgumentException("No coincide la cantidad de bloques con la cantidad de huecos");
        } else {
            int matches = 0;
            int largo = bloques.size();
            int intentos = 0;
            while (matches < largo){
                for (Bloque bloque: bloques){
                    for (Hueco hueco: huecos){
                        intentos++;
                        if (encastre(bloque, hueco)) {
                            bloques.remove(bloque);
                            huecos.remove(hueco);
                        }
                    }
                }  
            }
        return intentos;
        }
    }
}