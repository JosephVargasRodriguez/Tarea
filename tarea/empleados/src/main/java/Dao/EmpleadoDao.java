package Dao;
import models.Empleado;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {
    private final List<Empleado> almacen = new ArrayList<>();

    public EmpleadoDao() {}

    public void guardarEmpleado(Empleado empleado) {
        if (empleado != null) {
            almacen.add(empleado);
        }
    }
    public List<Empleado> listar() {
        return new ArrayList<>(almacen);
    }
}
