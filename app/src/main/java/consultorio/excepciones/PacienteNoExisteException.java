package consultorio.excepciones;

public class PacienteNoExisteException extends RuntimeException {
    public PacienteNoExisteException(){
        super("El paciente no existe");
    }
}
