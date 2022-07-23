package consultorio.clasesApp;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer dni;

    public Persona(String nombre, String apellido, Integer dni) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
