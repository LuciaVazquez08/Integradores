package Ejercicio94;

public class NoHayDisponibilidadException extends RuntimeException{
    public NoHayDisponibilidadException(){
        super();
    }
     public NoHayDisponibilidadException(String error_message){
        super(error_message);
    }
}
