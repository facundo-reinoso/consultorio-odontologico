package consultorio.excepciones;

public class TurnoNoCargadoException extends RuntimeException{
    public TurnoNoCargadoException(){
        super("El turno no se cargo correctamente");
    }
}
