package Dao;

import models.Asignacion;
import jakarta.persistence.EntityManager;
import models.Cargo;
import models.Empleado;

import java.util.ArrayList;
import java.util.List;

public class AsignacionDao {
    private final List<Asignacion> almacen = new ArrayList<>();

    public AsignacionDao() {}

    public void asignar(Asignacion asignacion) {
        if (asignacion != null) {
            almacen.add(asignacion);
        }
    }
    public List<Asignacion> listar() {
        return new ArrayList<>(almacen);
    }
}