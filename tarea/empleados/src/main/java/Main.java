import Dao.EmpleadoDao;
import Dao.CargoDao;
import Dao.AsignacionDao;
import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmpleadoDao empleadoDAO = new EmpleadoDao();
        CargoDao cargoDAO = new CargoDao();
        AsignacionDao asignacionDAO = new AsignacionDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1) Crear Empleado");
            System.out.println("2) Crear Cargo");
            System.out.println("3) Crear Asignación");
            System.out.println("4) Listar todo");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");
            String opt = sc.nextLine().trim();

            switch (opt) {
                case "1": {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine().trim();
                    Empleado e = new Empleado();
                    e.setNombre(nombre);
                    e.setApellido(apellido);
                    empleadoDAO.guardarEmpleado(e);
                    System.out.println("Empleado guardado.");
                    break;
                }
                case "2": {
                    System.out.print("Nombre del cargo: ");
                    String cn = sc.nextLine().trim();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine().trim();
                    Cargo c = new Cargo();
                    c.setNombre(cn);
                    c.setDescripcion(desc);
                    cargoDAO.guardarCargo(c);
                    System.out.println("Cargo guardado.");
                    break;
                }
                case "3": {
                    List<Empleado> empleados = empleadoDAO.listar();
                    List<Cargo> cargos = cargoDAO.listar();
                    if (empleados == null || empleados.isEmpty()) {
                        System.out.println("No hay empleados para asignar.");
                        break;
                    }
                    if (cargos == null || cargos.isEmpty()) {
                        System.out.println("No hay cargos para asignar.");
                        break;
                    }
                    System.out.println("Empleados:");
                    for (int i = 0; i < empleados.size(); i++) {
                        Empleado emp = empleados.get(i);
                        System.out.println((i + 1) + ") " + emp.getNombre() + " " + emp.getApellido());
                    }
                    System.out.print("Selecciona empleado (número): ");
                    int ei = parseIndex(sc.nextLine(), empleados.size());
                    if (ei < 0) { System.out.println("Selección inválida."); break; }

                    System.out.println("Cargos:");
                    for (int i = 0; i < cargos.size(); i++) {
                        Cargo cg = cargos.get(i);
                        System.out.println((i + 1) + ") " + cg.getNombre());
                    }
                    System.out.print("Selecciona cargo (número): ");
                    int ci = parseIndex(sc.nextLine(), cargos.size());
                    if (ci < 0) { System.out.println("Selección inválida."); break; }

                    Asignacion a = new Asignacion();
                    a.setEmpleado(empleados.get(ei));
                    a.setCargo(cargos.get(ci));
                    asignacionDAO.asignar(a);
                    System.out.println("Asignación creada.");
                    break;
                }
                case "4": {
                    System.out.println("\nEmpleados:");
                    List<Empleado> empleados = empleadoDAO.listar();
                    if (empleados == null || empleados.isEmpty()) {
                        System.out.println("- (ninguno)");
                    } else {
                        for (Empleado e : empleados) {
                            System.out.println("- " + (e != null ? e.getNombre() + " " + e.getApellido() : "null"));
                        }
                    }

                    System.out.println("\nCargos:");
                    List<Cargo> cargos = cargoDAO.listar();
                    if (cargos == null || cargos.isEmpty()) {
                        System.out.println("- (ninguno)");
                    } else {
                        for (Cargo c : cargos) {
                            System.out.println("- " + (c != null ? c.getNombre() : "null"));
                        }
                    }

                    System.out.println("\nAsignaciones:");
                    List<Asignacion> asignaciones = asignacionDAO.listar();
                    if (asignaciones == null || asignaciones.isEmpty()) {
                        System.out.println("- (ninguna)");
                    } else {
                        for (Asignacion asg : asignaciones) {
                            String en = asg != null && asg.getEmpleado() != null ? asg.getEmpleado().getNombre() : "null";
                            String cn = asg != null && asg.getCargo() != null ? asg.getCargo().getNombre() : "null";
                            System.out.println("- " + en + " -> " + cn);
                        }
                    }
                    break;
                }
                case "0":
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static int parseIndex(String input, int size) {
        try {
            int idx = Integer.parseInt(input.trim()) - 1;
            if (idx < 0 || idx >= size) return -1;
            return idx;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
