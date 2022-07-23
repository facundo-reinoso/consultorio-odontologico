package consultorio.clasesApp;

public class Paciente extends Persona {

    public Paciente(String nombre, String apellido, Integer dni) {
        super(nombre, apellido, dni);
    }
    
    @Override
    public String toString(){
        return this.getNombre()+" "+this.getApellido();
    }
}
