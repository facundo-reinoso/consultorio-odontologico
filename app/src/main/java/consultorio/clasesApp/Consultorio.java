package consultorio.clasesApp;

import java.util.ArrayList;

import consultorio.excepciones.*;
import java.util.List;

public class Consultorio {

    private static Consultorio singleton;

    private List<Odontologo> arrayOdontologos = new ArrayList<>();
    private List<Paciente> arrayPacientes = new ArrayList<>();

    private Consultorio() {
    }

    public static Consultorio singleton() {
        if (singleton == null) {
            singleton = new Consultorio();
        }
        return singleton;
    }

    public void agregarOdontologo(Odontologo odontologo) {
        arrayOdontologos.add(odontologo);
    }
    
    public List<Odontologo> getArrayOdontologos() {
        return arrayOdontologos;
    }

    public Odontologo buscarOdontologo(Integer matricula) {
        Odontologo odontologoEncontrado = null;
        for (Odontologo i : arrayOdontologos) {
            if (i.getMatricula().equals(matricula)) {
                odontologoEncontrado = i;
            }
        }

        if(odontologoEncontrado==null){
            throw new OdontologoNoExisteException();
        }

        return odontologoEncontrado;
    }

    public void modificarOdontologo(Integer matricula, String nombre, String apellido, Integer documento, Integer matriculaNueva){
        Odontologo odontologoEncontrado = null;
        for(Odontologo i: arrayOdontologos){
            if(i.getMatricula().equals(matricula)){
                i.setNombre(nombre);
                i.setApellido(apellido);
                i.setDni(documento);
                i.setMatricula(matriculaNueva);
                
                odontologoEncontrado = i;
            }
        }
        
        if(odontologoEncontrado == null){
            throw new OdontologoNoExisteException();
        }
    }

    public void eliminarOdontologo(Integer matricula) {
        Odontologo odontologoAEliminar = buscarOdontologo(matricula);
        if (odontologoAEliminar != null) {
            this.arrayOdontologos.remove(buscarOdontologo(matricula));
        }else{
            throw new OdontologoNoExisteException();
        }
    }

    public void agregarPaciente(Paciente paciente) {
        arrayPacientes.add(paciente);
    }

    public List<Paciente> getArrayPacientes() {
        return arrayPacientes;
    }

    public Paciente buscarPaciente(Integer dni) {
        Paciente pacienteEncontrado = null;
        for (Paciente i : arrayPacientes) {
            if (i.getDni().equals(dni)) {
                pacienteEncontrado = i;
            }
        }

        if(pacienteEncontrado==null){
            throw new PacienteNoExisteException();
        }

        return pacienteEncontrado;
    }

    public void modificarPaciente(Integer documento, String nombre, String apellido, Integer documentoNuevo){
        Paciente pacienteEncontrado = null;
        for(Paciente i: arrayPacientes){
            if(i.getDni().equals(documento)){
                i.setNombre(nombre);
                i.setApellido(apellido);
                i.setDni(documentoNuevo);
                
                pacienteEncontrado = i;
            }
        }
        
        if(pacienteEncontrado == null){
            throw new PacienteNoExisteException();
        }
    }

    public void eliminarPaciente(Integer dni) {
        Paciente pacienteAEliminar = buscarPaciente(dni);
        if (pacienteAEliminar != null) {
            this.arrayPacientes.remove(buscarPaciente(dni));
        }else{
            throw new PacienteNoExisteException();
        }
    }

}
