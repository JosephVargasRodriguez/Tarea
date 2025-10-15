// File: `src/main/java/models/Empleado.java`
package models;

public class Empleado {
    private Long id;
    private String nombre;
    private String apellido;

    public Empleado() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
