package Ejercicio90;

import java.util.*;

public class AgendaTelefonica {
    private List<Individuo> registro; 

    public AgendaTelefonica(){
        this.registro = new ArrayList<Individuo>();
    }

    public AgendaTelefonica(Individuo[] personas){
        this.registro = new ArrayList<Individuo>();
        for (Individuo persona: personas){
            registro.add(persona);
        }
    }

    public AgendaTelefonica(List<Individuo> personas){
        this.registro = personas;

    }

    public List<Individuo> getRegistro() {
            return registro;
    }

    public void addIndividuo(Individuo persona){
        registro.add(persona);
    }

    public Object[] buscarInfo(String nombre){
        Object[] dato = new Object[2];

        for (Individuo persona : registro){
            if(persona.getNombre() == nombre){
                dato[0] = persona.getDireccion();
                dato[1] = persona.getTelefono();
            }
        }

        if (dato[0] == null && dato[1] == null){
            throw new IllegalArgumentException("No tiene una persdona registrada con es enombre");
        } else {
            return dato;
        }
    }

    public void removeIndividuo(Individuo persona){
            if (registro.contains(persona)){
                registro.remove(persona);
            } else {
                throw new IllegalArgumentException("No existe ese individuo en el registro");
            }
    }

    public void removeIndividuo(String nombre){
        for(Individuo persona : registro){
            if (persona.getNombre() == nombre){
                removeIndividuo(persona);
            }
        }
    }

}
