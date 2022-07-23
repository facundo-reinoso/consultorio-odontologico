package consultorio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import consultorio.clasesApp.Agenda;
import consultorio.clasesApp.Consultorio;
import consultorio.clasesApp.IntAgenda;
import consultorio.clasesApp.Odontologo;
import consultorio.clasesApp.Paciente;
import consultorio.excepciones.OdontologoNoExisteException;
import consultorio.excepciones.PacienteNoExisteException;

public class ConsultorioTest {
    @Test
    public void agregarOdontologoTest() {
        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        IntAgenda agenda1 = new Agenda();
        Odontologo odontologo1 = new Odontologo("Juan", "Perez", 41475272, 0123, agenda1); // Un medico y su agenda personal
                                                                                 // quiere
                                                                                 // ingresar

        consultorio1.agregarOdontologo(odontologo1); // El medico ingreso a trabajar en el establecimiento

        assertEquals(odontologo1, consultorio1.getArrayOdontologos().get(0));
    }

    @Test
    public void buscarOdontologoTest(){
        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        IntAgenda agenda1 = new Agenda();
        Odontologo odontologo1 = new Odontologo("Juan", "Perez", 41475272, 0123, agenda1); // Un medico y su agenda personal
                                                                                 // quiere
                                                                                 // ingresar

        consultorio1.agregarOdontologo(odontologo1); // El medico ingreso a trabajar en el establecimiento

        assertEquals(odontologo1, consultorio1.buscarOdontologo(0123)); //prueba metodo
    }

    @Test
    (expected = OdontologoNoExisteException.class)
    public void odontologoNoExisteExceptionTest(){
        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        IntAgenda agenda1 = new Agenda();
        Odontologo odontologo1 = new Odontologo("Juan", "Perez", 41475272, 0123, agenda1); // Un medico y su agenda personal
                                                                                 // quiere
                                                                                 // ingresar

        consultorio1.agregarOdontologo(odontologo1); // El medico ingreso a trabajar en el establecimiento

        Odontologo odontologoEsperado = consultorio1.buscarOdontologo(0555); //ingreso un matricula inexistente
    }

    @Test
    public void modificarOdontologoTest(){
        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        consultorio1.getArrayOdontologos().clear(); 
        IntAgenda agenda1 = new Agenda();
        Odontologo odontologo1 = new Odontologo("Juan", "Perez", 41475272, 0123, agenda1); // Un medico y su agenda personal
                                                                                 // quiere
                                                                                 // ingresar

        consultorio1.agregarOdontologo(odontologo1); // El medico ingreso a trabajar en el establecimiento

        consultorio1.modificarOdontologo(0123, "Jose", "Jerez", 41475222, 0124); //Modifico los datos

        Integer matriculaEsperada = 0124;
        Integer documentoEsperado = 41475222;
        String nombreEsperado = "Jose";

        assertEquals(matriculaEsperada , consultorio1.getArrayOdontologos().get(0).getMatricula());

        assertEquals(documentoEsperado, consultorio1.getArrayOdontologos().get(0).getDni());

        assertEquals(nombreEsperado, consultorio1.getArrayOdontologos().get(0).getNombre());
    }

    @Test
    public void eliminarOdontologoTest() {
        Consultorio consultorio1 = Consultorio.singleton(); // Un establecimiento de consultorios
        consultorio1.getArrayOdontologos().clear(); // Limpio el array para evitar errores en el assert(al usar el patron singleton la instancia queda cargada con el test anterior)
        Agenda agenda1 = new Agenda();
        Odontologo odontologo1 = new Odontologo("Juan", "Perez", 41475272, 0123, agenda1); // Medico que ya trabaja en el
                                                                                 // establecimiento
        Agenda agenda2 = new Agenda();
        Odontologo odontologo2 = new Odontologo("Luis", "Sanchez", 41475272, 0555, agenda2); // Medico que ya trabaja en el
                                                                                   // establecimiento

        consultorio1.agregarOdontologo(odontologo1);
        consultorio1.agregarOdontologo(odontologo2);

        consultorio1.eliminarOdontologo(0123); // Un medico fue despedido o renuncio (dado de baja)

        assertEquals(odontologo2, consultorio1.getArrayOdontologos().get(0)); // En la posicion 0 del array queda el Odontologo2
    }

    @Test
    public void agregarPacienteTest() {
        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        consultorio1.getArrayPacientes().clear();
        Paciente paciente1 = new Paciente("Jose", "Gomez", 41475272); // Un nuevo paciente

        consultorio1.agregarPaciente(paciente1); // El paciente esta cargado en el sistema

        assertEquals(paciente1, consultorio1.getArrayPacientes().get(0));
    }

    @Test
    public void buscarPacienteTest(){
        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        Paciente paciente1 = new Paciente("Jose", "Gomez", 41475272); // Un nuevo paciente

        consultorio1.agregarPaciente(paciente1); // El paciente esta cargado en el sistema

        assertEquals(paciente1, consultorio1.buscarPaciente(41475272));
    }

    @Test
    (expected = PacienteNoExisteException.class)
    public void pacienteNoExisteExceptionTest(){
        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        Paciente paciente1 = new Paciente("Jose", "Gomez", 41475272); // Un nuevo paciente

        consultorio1.agregarPaciente(paciente1); // El paciente esta cargado en el sistema

        Paciente pacienteEsperado = consultorio1.buscarPaciente(2200111); // pruebo el metodo con un dni inexistente
    }

    @Test
    public void modificarPacienteTest(){

        Consultorio consultorio1 = Consultorio.singleton(); // Un nuevo establecimiento de consultorios
        consultorio1.getArrayPacientes().clear();
        Paciente paciente1 = new Paciente("Jose", "Gomez", 41475272); // Un nuevo paciente

        consultorio1.agregarPaciente(paciente1); // El paciente esta cargado en el sistema

        consultorio1.modificarPaciente(41475272, "Juan", "Gomez", 41475222);
        
        Integer documentoEsperado = 41475222;
        String nombreEsperado = "Juan";

        assertEquals(documentoEsperado, consultorio1.getArrayPacientes().get(0).getDni());

        assertEquals(nombreEsperado, consultorio1.getArrayPacientes().get(0).getNombre());
    }

    @Test
    public void eliminarPacienteTest() {
        Consultorio consultorio1 = Consultorio.singleton(); // Un establecimiento de consultorios
        consultorio1.getArrayPacientes().clear();
        Paciente paciente1 = new Paciente("Jose", "Gomez", 41475272); // Paciente ya registrado
        Paciente paciente2 = new Paciente("Pedro", "Sanchez", 36639528); // Paciente ya registrado

        consultorio1.agregarPaciente(paciente1);
        consultorio1.agregarPaciente(paciente2);

        consultorio1.eliminarPaciente(41475272); // Un paciente fue dado de baja

        assertEquals(paciente2, consultorio1.getArrayPacientes().get(0)); // En la posicion 0 del array queda el paciente2
    }

}
