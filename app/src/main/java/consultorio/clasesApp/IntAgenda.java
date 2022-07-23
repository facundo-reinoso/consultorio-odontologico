package consultorio.clasesApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IntAgenda {

    public List<Turno> getTurnos();
    
    public List<TurnoSinAtencion> getTurnosSinAtencion();

    public void agregarTurno(Turno turno, Boolean dobleTurno);

    public void agregarTurnoSinAtencion(TurnoSinAtencion turnoSinAtencion);

    public List<Turno> mostrarTurnos();

    public Turno buscarTurno(Integer dni);

    public void modificarTurno(Integer dni, LocalDate fecha, LocalTime horaInicio, String motivo, Boolean dobleTurno);

    public void eliminarTurno(Integer dni);

}
