package Ejercicio94;

import java.util.*;

public class Cliente {
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void reservar(Hotel hotel, int cant_ocupantes, String fechaEntrada, String fechaSalida){
        if (hotel.getTipos().contains(cant_ocupantes)){
            if (hotel.disponible(cant_ocupantes, fechaEntrada, fechaSalida)){
                Reserva reserva = new Reserva(hotel, fechaEntrada, fechaSalida);
                reservas.add(reserva);
            } else {
                throw new NoHayDisponibilidadException("No hay disponibilidad para esas fechas");
            }
        } else {
            throw new IllegalArgumentException();
        } 
    }

}
