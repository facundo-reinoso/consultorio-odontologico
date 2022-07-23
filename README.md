public class Principal{
    
}

public class Paciente{
    private String nombre;
    private Integer dni;
    private Integer telefono;
    private String patologia;
}

public class Odontologo{
    private String nombre;
    private Integer matricula;
    private Agenda agendaPersonal;
}

public class Agenda{
    private Turnos turno;
}

public class Turnos{
    private Odontologo dueño;
    private Integer mes;
    private Integer dia;
    private Integer hora;
    private Paciente paciente;
}
