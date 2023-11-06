package Ejercicio94;

import java.util.*;

public class Hotel {
    String nombre;
    List<Habitacion> habitaciones;
    int cant_habitaciones;
    Map<Integer, List<String>> disponibilidad;
    
    private Hotel(String nombre){
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.cant_habitaciones = 0;
        this.disponibilidad = new LinkedHashMap<>();
    }
    
    private void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
        cant_habitaciones++;
        disponibilidad.put(cant_habitaciones, new ArrayList<String>());
    }

    public Hotel construirHotel(String nombre, int cant_habitaciones, int[] cant_ocupantes, int[] precios){
        Hotel hotel = new Hotel(nombre);
        for (int i = 0; i < cant_habitaciones; i++){
            hotel.agregarHabitacion( new Habitacion(i, cant_ocupantes[i], precios[i]));
        }
        return hotel;
    }

}
