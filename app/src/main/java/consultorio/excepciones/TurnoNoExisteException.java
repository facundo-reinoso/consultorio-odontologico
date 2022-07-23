package consultorio.excepciones;

public class TurnoNoExisteException extends RuntimeException{
    public TurnoNoExisteException(){
        super("El turno no existe");
    }
}
