package consultorio;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import consultorio.clasesApp.Agenda;
import consultorio.clasesApp.IntAgenda;
import consultorio.clasesApp.Paciente;
import consultorio.clasesApp.Turno;
import consultorio.clasesApp.TurnoSinAtencion;
import consultorio.excepciones.TurnoNoCargadoException;
import consultorio.excepciones.TurnoNoExisteException;

public class AgendaTest {
    @Test
    public void agregarTurnoTest() {
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 30); // ... a las 18:30 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Se anota el turno en la agenda;

        assertEquals(1, agenda1.getTurnos().size());

        LocalTime horaEsperada = LocalTime.of(19, 00); //Compruebo que se cree un turno de 30min de duracion

        assertEquals(horaEsperada, turno1.getHoraFin());
    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void turnoNoCargadoExceptionTestUno() {
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 23); // Pide turno para el dia 23/10/2021 (FIN DE SEMANA)
        LocalTime horaInicio = LocalTime.of(18, 00); // ... a las 18:00 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // No se anota ya que es domingo.

        assertEquals(turno1, agenda1.getTurnos().get(0)); // Deberia dar excepcion de que no cargo el turno
    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void turnoNoCargadoExceptionTestDos() {
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (DIA DE SEMANA)
        LocalTime horaInicio = LocalTime.of(23, 00); // ... a las 23:00 horas, lo cual no esta permitido
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // No se anota ya que a esa hora no se atiende a los pacientes.

        assertEquals(turno1, agenda1.getTurnos().get(0)); // Deberia dar excepcion de que no cargo el turno
    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void turnoNoCargadoExceptionTestTres() {
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 23); // Pide turno para el dia 23/10/2021 (FIN DE SEMANA)
        LocalTime horaInicio = LocalTime.of(23, 00); // ... a las 23:00 horas, lo cual no esta permitido
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // No se anota ya que en esa fecha y a esa hora no se atiende a los pacientes.

        assertEquals(turno1, agenda1.getTurnos().get(0)); // Deberia dar excepcion de que no cargo el turno
    }

    @Test
    public void agregarTurnoSinAtencionTest(){
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // El odontologo no atendera ese dia...
        LocalTime horaInicio = LocalTime.of(17, 00); // ... desde las 17:00 horas
        LocalTime horaFin = LocalTime.of(19, 00); // ...hasta las 19:00 horas
        IntAgenda agenda1 = new Agenda();
        TurnoSinAtencion turnoSinAtencion1 = new TurnoSinAtencion(fecha1, horaInicio, horaFin); 

        agenda1.agregarTurnoSinAtencion(turnoSinAtencion1); // Se anota el turno en el que no se atendera en la agenda

        assertEquals(1, agenda1.getTurnosSinAtencion().size());
    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void agregarTurnoEnHorarioDeNoAtencionTest(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(17, 00); // ... a las 17:00 horas

        LocalDate fechaNoAtencion = LocalDate.of(2021, 10, 22); // El odontologo no atendera ese dia...
        LocalTime horaInicioNoAtencion = LocalTime.of(17, 00); // ... desde las 17:00 horas
        LocalTime horaFinNoAtencion = LocalTime.of(19, 00); // ...hasta las 19:00 horas

        IntAgenda agenda1 = new Agenda();

        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno
        TurnoSinAtencion turnoSinAtencion1 = new TurnoSinAtencion(fechaNoAtencion, horaInicioNoAtencion, horaFinNoAtencion);

        agenda1.agregarTurnoSinAtencion(turnoSinAtencion1); // Se anota el turno en el que no se atendera en la agenda;
        agenda1.agregarTurno(turno1, false); // Se intenta anotar el turno en la agenda.

        assertEquals(turno1, agenda1.getTurnos().get(0)); // Deberia dar excepcion de que no cargo el turno
    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void agregarTurnoEnHorarioDeNoAtencionTestDos(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 00); // ... a las 18:00 horas

        LocalDate fechaNoAtencion = LocalDate.of(2021, 10, 22); // El odontologo no atendera ese dia...
        LocalTime horaInicioNoAtencion = LocalTime.of(17, 00); // ... desde las 17:00 horas
        LocalTime horaFinNoAtencion = LocalTime.of(19, 00); // ...hasta las 19:00 horas

        IntAgenda agenda1 = new Agenda();

        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno
        TurnoSinAtencion turnoSinAtencion1 = new TurnoSinAtencion(fechaNoAtencion, horaInicioNoAtencion, horaFinNoAtencion);

        agenda1.agregarTurnoSinAtencion(turnoSinAtencion1); // Se anota el turno en el que no se atendera en la agenda;
        agenda1.agregarTurno(turno1, false); // Se intenta anotar el turno en la agenda.

        assertEquals(turno1, agenda1.getTurnos().get(0)); // Deberia dar excepcion de que no cargo el turno
    }

    @Test
    public void agregarTurnoEnHorarioDeNoAtencionTestTres(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 00); // ... a las 18:00 horas

        LocalDate fechaNoAtencion = LocalDate.of(2021, 10, 23); // El odontologo no atendera ese dia...
        LocalTime horaInicioNoAtencion = LocalTime.of(17, 00); // ... desde las 17:00 horas
        LocalTime horaFinNoAtencion = LocalTime.of(19, 00); // ...hasta las 19:00 horas

        IntAgenda agenda1 = new Agenda();

        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno
        TurnoSinAtencion turnoSinAtencion1 = new TurnoSinAtencion(fechaNoAtencion, horaInicioNoAtencion, horaFinNoAtencion);

        agenda1.agregarTurnoSinAtencion(turnoSinAtencion1); // Se anota el turno en el que no se atendera en la agenda;
        agenda1.agregarTurno(turno1, false); // Se intenta anotar el turno en la agenda.

        assertEquals(turno1, agenda1.getTurnos().get(0)); 
    }

    @Test
    public void agregarTurnoEnHorarioDeNoAtencionTestCuatro(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(19, 00); // ... a las 19:00 horas

        LocalDate fechaNoAtencion = LocalDate.of(2021, 10, 22); // El odontologo no atendera ese dia...
        LocalTime horaInicioNoAtencion = LocalTime.of(17, 00); // ... desde las 17:00 horas
        LocalTime horaFinNoAtencion = LocalTime.of(19, 00); // ...hasta las 19:00 horas

        IntAgenda agenda1 = new Agenda();

        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno
        TurnoSinAtencion turnoSinAtencion1 = new TurnoSinAtencion(fechaNoAtencion, horaInicioNoAtencion, horaFinNoAtencion);

        agenda1.agregarTurnoSinAtencion(turnoSinAtencion1); // Se anota el turno en el que no se atendera en la agenda;
        agenda1.agregarTurno(turno1, false); // Se intenta anotar el turno en la agenda.

        assertEquals(turno1, agenda1.getTurnos().get(0)); 
    }

    @Test
    public void buscarTurnoTest() {
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 ...
        LocalTime horaInicio = LocalTime.of(18, 00); // ... a las 18:00 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Se agrega el turno
        Turno turnoEsperado = agenda1.buscarTurno(41475272);
        assertEquals(turno1, turnoEsperado);
    }

    @Test
    (expected = TurnoNoExisteException.class)
    public void turnoNoExisteExceptionTest(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 ...
        LocalTime horaInicio = LocalTime.of(18, 00); // ... a las 18:00 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Se agrega el turno

        Turno turnoEsperado = agenda1.buscarTurno(41566999); //Pruebo el metodo con un dni inexistente
    }

    @Test
    public void modificarTurno(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 30); // ... a las 18:30 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Se anota el turno en la agenda;

        agenda1.modificarTurno(41475272, LocalDate.of(2021, 11, 22), LocalTime.of(18, 00), "Tratamiento", true);

        LocalDate fechaEsperada = LocalDate.of(2021, 11, 22);
        LocalTime horaInicioEsperada = LocalTime.of(18, 00);
        LocalTime horaFinEsperada = LocalTime.of(19, 00);
        String motivoEsperado = "Tratamiento";

        assertEquals(fechaEsperada, agenda1.getTurnos().get(0).getFecha());
        assertEquals(horaInicioEsperada, agenda1.getTurnos().get(0).getHoraInicio());
        assertEquals(horaFinEsperada, agenda1.getTurnos().get(0).getHoraFin());
        assertEquals(motivoEsperado, agenda1.getTurnos().get(0).getMotivo());

    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void modificarTurnoFalla(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 30); // ... a las 18:30 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Se anota el turno en la agenda;

        agenda1.modificarTurno(41475272, LocalDate.of(2021, 11, 20), LocalTime.of(18, 00), "Tratamiento", true);
        //Modifico el turno con un dia del fin de semana (Arroja excepcion)
    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void modificarTurnoFallaDos(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 30); // ... a las 18:30 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Se anota el turno en la agenda;

        agenda1.modificarTurno(41475272, LocalDate.of(2021, 11, 22), LocalTime.of(23, 00), "Tratamiento", true);
        //Modifico el turno con un horario fuera de rango (Arroja excepcion)
    }

    @Test
    (expected = TurnoNoCargadoException.class)
    public void modificarTurnoFallaTres(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 30); // ... a las 18:30 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Se anota el turno en la agenda;

        agenda1.modificarTurno(41475272, LocalDate.of(2021, 11, 20), LocalTime.of(23, 00), "Tratamiento", true);
        //Modifico el turno con un dia de fin de semana, y un horario fuera de rango (Arroja excepcion)
    }

    @Test
    public void eliminarTurnoTest() {
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 ...
        LocalTime horaInicio = LocalTime.of(18, 00); // ... a las 18:00 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno1, false); // Agrego el turno
        agenda1.eliminarTurno(41475272); // Busco el turno por DNI y lo elimino

        assertEquals(true, agenda1.getTurnos().isEmpty()); // Comparo la agenda que deberia estar vacia
    }

    @Test
    public void mostrarTurnosTest(){
        Paciente paciente1 = new Paciente("Carlos", "Perez", 41475272); // Paciente 1 ingresa al
                                                                                       // consultorio
        LocalDate fecha1 = LocalDate.of(2021, 10, 22); // Pide turno para el dia 22/10/2021 (Dia de Semana)
        LocalTime horaInicio = LocalTime.of(18, 00); // ... a las 18:00 horas
        IntAgenda agenda1 = new Agenda();
        Turno turno1 = new Turno(paciente1, fecha1, horaInicio, "Consulta"); // Se crea el turno

        Paciente paciente2 = new Paciente("Juan", "Gomez", 41475272); // Paciente 2 ingresa al
                                                                                       // consultorio
        LocalDate fecha2 = LocalDate.of(2021, 10, 25); // Pide turno para el dia 25/10/2021 (Dia de Semana)
        LocalTime horaInicio2 = LocalTime.of(19, 00); // ... a las 19:00 horas
        
        Turno turno2 = new Turno(paciente2, fecha2, horaInicio2, "Consulta"); // Se crea el turno

        agenda1.agregarTurno(turno2, false); // Se anota el turno2 en la agenda; (primero en el array)
        agenda1.agregarTurno(turno1, false); // Se anota el turno1 en la agenda; (segundo en el array)

        //en orden deberian mostrarse primero el turno1 y luego el turno2

        assertEquals(turno1, agenda1.mostrarTurnos().get(0)); //pido el turno de la primera posicion (o)
        
        assertEquals(turno2, agenda1.mostrarTurnos().get(1)); //pido el turno de la segunda posicion (1)
    }
}
