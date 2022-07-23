package consultorio.excepciones;

public class OdontologoNoExisteException extends RuntimeException {
    public OdontologoNoExisteException(){
        super("El odontologo no existe");
    }
}
