// File: `src/main/java/models/Asignacion.java`
package models;

public class Asignacion {
    private Long id;
    private Empleado empleado;
    private Cargo cargo;

    public Asignacion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    @Override
    public String toString() {
        String en = empleado != null ? empleado.getNombre() + " " + empleado.getApellido() : "null";
        String cn = cargo != null ? cargo.getNombre() : "null";
        return en + " -> " + cn;
    }
}
