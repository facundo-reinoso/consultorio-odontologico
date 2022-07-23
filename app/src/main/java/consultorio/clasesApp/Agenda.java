package consultorio.clasesApp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import consultorio.excepciones.*;


public class Agenda implements IntAgenda {

    private LocalTime horaMinimaManana = LocalTime.of(8, 00);
    private LocalTime horaMaximaManana = LocalTime.of(12, 00);
    private LocalTime horaMinimaTarde = LocalTime.of(16, 00);
    private LocalTime horaMaximaTarde = LocalTime.of(20, 00);

    private List<Turno> arrayTurnos = new ArrayList<>();
    private List<TurnoSinAtencion> arrayTurnosSinAtencion = new ArrayList<>();

    public Agenda() {
    }

    @Override
    public List<Turno> getTurnos() {
        return arrayTurnos;
    }
    
    @Override
    public List<TurnoSinAtencion> getTurnosSinAtencion(){
        return arrayTurnosSinAtencion;
    }

    @Override
    public void agregarTurno(Turno turno, Boolean dobleTurno) {
        Boolean turnoCargado = null;
        if ((turno.getFecha().getDayOfWeek() != DayOfWeek.SATURDAY) && (turno.getFecha().getDayOfWeek() != DayOfWeek.SUNDAY)) {
            if( ((turno.getHoraInicio().compareTo(horaMinimaManana)>=0) && (turno.getHoraInicio().compareTo(horaMaximaManana)<=0)) || ((turno.getHoraInicio().compareTo(horaMinimaTarde)>=0) && (turno.getHoraInicio().compareTo(horaMaximaTarde)<=0)) ){
                if(arrayTurnosSinAtencion.isEmpty()){
                    if(dobleTurno==false){
                    turno.setHoraFin(turno.getHoraInicio().plusMinutes(30));
                    arrayTurnos.add(turno);
                    turnoCargado = true;
                    }else{
                        turno.setHoraFin(turno.getHoraInicio().plusMinutes(60));
                        arrayTurnos.add(turno);
                        turnoCargado = true;
                    }
                }else{
                    for(TurnoSinAtencion i: arrayTurnosSinAtencion){
                        if( (turno.getHoraInicio().compareTo(i.getHoraInicio()) >= 0) && (turno.getHoraInicio().compareTo(i.getHoraFin())< 0) && (turno.getFecha().equals(i.getFecha())) ){
                            turnoCargado = null;
                            break;
                        }else{
                            turnoCargado = true;
                        }
                    }
                    if(turnoCargado==null){
                        throw new TurnoNoCargadoException();
                    }else{
                        if(dobleTurno==false){
                                turno.setHoraFin(turno.getHoraInicio().plusMinutes(30));
                                arrayTurnos.add(turno);
                                turnoCargado = true;
                            }else{
                                turno.setHoraFin(turno.getHoraInicio().plusMinutes(60));
                                arrayTurnos.add(turno);
                                turnoCargado = true;
                            }
                    }
                }
            }else{
                throw new TurnoNoCargadoException();
            }
        }else{
            throw new TurnoNoCargadoException();
        }
    }

    @Override
    public void agregarTurnoSinAtencion(TurnoSinAtencion turnoSinAtencion){
        arrayTurnosSinAtencion.add(turnoSinAtencion);
    }

    @Override
    public List<Turno> mostrarTurnos() {
        List<Turno> listadoOrdenado = new ArrayList<>();
        for(Turno i: arrayTurnos){
            listadoOrdenado.add(i);
        }
        Collections.sort(listadoOrdenado, new TurnoComparador());
        return listadoOrdenado;
    }


    @Override
    public Turno buscarTurno(Integer dni) {
        Turno turnoEncontrado = null;
        for (Turno i : arrayTurnos) {
            if (i.getPaciente().getDni().equals(dni)) {
                turnoEncontrado = i;
            }
        }

        if(turnoEncontrado == null){
            throw new TurnoNoExisteException();
        }
        return turnoEncontrado;
    }

    @Override
    public void modificarTurno(Integer dni, LocalDate fecha, LocalTime horaInicio, String motivo, Boolean dobleTurno){  
        Turno turnoEncontrado = null;
        
        for(Turno i: arrayTurnos){

            LocalDate fechaOriginal = i.getFecha();
            LocalTime horaInicioOriginal = i.getHoraInicio();
            LocalTime horaFinOrinal = i.getHoraFin();
            String motivoOriginal = i.getMotivo();
            
            if(i.getPaciente().getDni().equals(dni)){
                i.setFecha(fecha);
                i.setHoraInicio(horaInicio);
                i.setMotivo(motivo);
                if(dobleTurno==false){
                    i.setHoraFin(i.getHoraInicio().plusMinutes(30));
                    
                }else{
                    i.setHoraFin(i.getHoraInicio().plusMinutes(60));
                } 
                
                turnoEncontrado = i;
            }
            
            if ((i.getFecha().getDayOfWeek() != DayOfWeek.SATURDAY) && (i.getFecha().getDayOfWeek() != DayOfWeek.SUNDAY)){
                if( ((i.getHoraInicio().compareTo(horaMinimaManana)>=0) && (i.getHoraInicio().compareTo(horaMaximaManana)<=0)) || ((i.getHoraInicio().compareTo(horaMinimaTarde)>=0) && (i.getHoraInicio().compareTo(horaMaximaTarde)<=0)) ){
                    //Hasta aca el turno se modifico correctamente
                }else{
                    i.setFecha(fechaOriginal);
                    i.setHoraInicio(horaInicioOriginal);
                    i.setHoraFin(horaFinOrinal);
                    i.setMotivo(motivoOriginal);

                    throw new TurnoNoCargadoException();
                }
            }else{
                i.setFecha(fechaOriginal);
                i.setHoraInicio(horaInicioOriginal);
                i.setHoraFin(horaFinOrinal);
                i.setMotivo(motivoOriginal);

                throw new TurnoNoCargadoException();
            }
        }
        if(turnoEncontrado==null){
                throw new TurnoNoExisteException();
            }
    }

    @Override
    public void eliminarTurno(Integer dni) {
        Turno turnoAEliminar = buscarTurno(dni);
        if(turnoAEliminar != null){
            this.arrayTurnos.remove(buscarTurno(dni));
        }else{
            throw new TurnoNoExisteException();
        }
    }

}
