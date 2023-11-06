package Ejercicio94;

public class Reserva {
    private Hotel hotel;
    private Habitacion habitacion;
    

    private String fechaEntrada;
    private String fechaSalida;

    public Reserva(Hotel hotel,String fechaEntrada, String fechaSalida) {
        this.hotel = hotel;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Hotel getHotel() {
            return hotel;
        }
    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
}
