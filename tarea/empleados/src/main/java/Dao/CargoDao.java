package Dao;

import models.Cargo;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CargoDao {
    private final List<Cargo> almacen = new ArrayList<>();

    public CargoDao() {}

    public void guardarCargo(Cargo cargo) {
        if (cargo != null) {
            almacen.add(cargo);
        }
    }
    public List<Cargo> listar() {
        return new ArrayList<>(almacen);
    }
}