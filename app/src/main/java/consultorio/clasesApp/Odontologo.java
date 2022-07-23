package consultorio.clasesApp;

public class Odontologo extends Persona {
    private Integer matricula;
    private IntAgenda agendaPersonal;

    public Odontologo(String nombre, String apellido, Integer dni, Integer matricula, IntAgenda agendaPersonal) {
        super(nombre, apellido, dni);
        this.setMatricula(matricula);
        this.setAgendaPersonal(agendaPersonal);
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public IntAgenda getAgendaPersonal() {
        return agendaPersonal;
    }

    public void setAgendaPersonal(IntAgenda agendaPersonal) {
        this.agendaPersonal = agendaPersonal;
    }
    
    @Override
    public String toString(){
        return this.getNombre()+" "+this.getApellido();
    }
}
