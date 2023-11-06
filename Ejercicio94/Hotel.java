package Ejercicio94;

import java.util.*;

public class Hotel {
    String nombre;
    Map<Habitacion, List<Reserva>> habitaciones;
    int cant_habitaciones;
    List<Integer> tipos;

    
    private Hotel(String nombre){
        this.nombre = nombre;
        this.habitaciones = new LinkedHashMap<>();
        this.cant_habitaciones = 0;
    }
    
    private void agregarHabitacion(Habitacion habitacion){
        habitaciones.put(habitacion, new ArrayList<>());
        cant_habitaciones++;
    }

    private void setTipos(int[] tipos) {
        List<Integer> tipo = new ArrayList<>(tipos.length); 
        for (int valor : tipos) {
            tipo.add(valor);
        }
        this.tipos = tipo;
    }
    

    public Hotel construirHotel(String nombre, int cant_habitaciones, int[] cant_ocupantes, int[] precios){
        if ( cant_habitaciones == cant_ocupantes.length && cant_habitaciones == precios.length){
            Hotel hotel = new Hotel(nombre);
            for (int i = 0; i < cant_habitaciones; i++){
                hotel.agregarHabitacion( new Habitacion(i, cant_ocupantes[i], precios[i]));
            }
            hotel.setTipos(cant_ocupantes);
            return hotel;  
        } else {
            throw new IllegalArgumentException();
        }   
    }

    public  Map<Habitacion, List<Reserva>> getHabitaciones(){
        return this.habitaciones;
    }

    public List<Integer>  getTipos(){
        return this.tipos;
    }

    public boolean verDisponibilidad(int cant_ocupantes, String fechaEntrada, String fechaSalida) {
        if (tipos.contains(cant_ocupantes)) {
            for (Habitacion habitacion : habitaciones.keySet()) {
                if (habitacion.getOcupantes() == cant_ocupantes) {
                    boolean disponible = true;
                    for (Reserva reserva : habitaciones.get(habitacion)) {
                        String reserva_entrada = reserva.getFechaEntrada();
                        String reserva_salida = reserva.getFechaSalida();
    
                        if (!(fechaEntrada.compareTo(reserva_salida) >= 0 || fechaSalida.compareTo(reserva_entrada) <= 0)) {
                            disponible = false;
                            break;
                        }
                    }
                    if (disponible) {
                        return true;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("Tipo de habitación no válido");
        }
    }

    public void guardarReserva(Reserva reserva_nueva, int cant_ocupantes) {
        boolean asignada = false;
        if (tipos.contains(cant_ocupantes)) {
            for (Habitacion habitacion : habitaciones.keySet()) {
                if (habitacion.getOcupantes() == cant_ocupantes) {
                    for (Reserva reserva : habitaciones.get(habitacion)) {
                        String reserva_entrada = reserva.getFechaEntrada();
                        String reserva_salida = reserva.getFechaSalida();
    
                        if (!(reserva_nueva.getFechaEntrada().compareTo(reserva_salida) >= 0 || reserva_nueva.getFechaSalida().compareTo(reserva_entrada) <= 0)) {
                            asignada = true;
                            break;
                        }
                    }
                    if (!asignada) {
                        habitaciones.get(habitacion).add(reserva_nueva);
                        break; // Una vez asignada, salimos del bucle
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Tipo de habitación no válido");
        }
    }    

}
