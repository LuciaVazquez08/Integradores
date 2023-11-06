package Ejercicio94;

import java.util.*;

public class Hotel {
    String nombre;
    List<Habitacion> habitaciones;
    int cant_habitaciones;
    List<Integer> tipos;
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

    private void setTipos(int[] tipos) {
        List<Integer> tipo = new ArrayList<>(tipos.length); 
        for (int valor : tipos) {
            tipo.add(valor);
        }
        this.tipos = tipo;
    }
    

    public Hotel construirHotel(String nombre, int cant_habitaciones, int[] cant_ocupantes, int[] precios){
        //TODO: validar tamaños
        Hotel hotel = new Hotel(nombre);
        for (int i = 0; i < cant_habitaciones; i++){
            hotel.agregarHabitacion( new Habitacion(i, cant_ocupantes[i], precios[i]));
        }
        hotel.setTipos(cant_ocupantes);
        return hotel;
    }

    public List<Habitacion> getHabitaciones(){
        return this.habitaciones;
    }

    public List<Integer>  getTipos(){
        return this.tipos;
    }

    public boolean disponible(int cant_ocupantes, String fechaEntrada, String fechaSalida) {
        List<Integer> posibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones){
            if(habitacion.getOcupantes() == cant_ocupantes){
                posibles.add(habitacion.getNumero());
            }
        }
        for(Integer posible : posibles){
            List<String> disponible = disponibilidad.get(posible);
            for (String periodo : disponible){
                if (!periodo.equals(formato(fechaEntrada, fechaSalida))){
                    disponible.add(formato(fechaEntrada,fechaSalida));
                    return true;
                }
            }
        }
        return false;
    }

    private String formato(String fechaEntrada, String fechaSalida) {
        return fechaEntrada+"-"+fechaSalida;
    }

}
