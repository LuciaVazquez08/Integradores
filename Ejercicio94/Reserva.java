package Ejercicio94;

public class Reserva {
    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;
    private String fechaEntrada;
    private String fechaSalida;

    public Reserva(Cliente cliente, Hotel hotel, Habitacion habitacion, String fechaEntrada, String fechaSalida) {
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
}
