import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int SALIR = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Zona> zonas = new ArrayList<>();

        int opcion = -1;

        while (opcion != SALIR) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear zona");
            System.out.println("2. Asignar presupuesto");
            System.out.println("3. Consultar presupuesto disponible");
            System.out.println("4. Simular mes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear zona
                    System.out.print("Ingrese el nombre de la zona: ");
                    String nombreZona = scanner.next();
                    Zona nuevaZona = new Zona(nombreZona);
                    zonas.add(nuevaZona);
                    System.out.println("Zona creada con éxito.");
                    break;

                case 2:
                    // Asignar presupuesto
                    System.out.print("Ingrese el nombre de la zona a la que asignar presupuesto: ");
                    String nombreZonaAsignar = scanner.next();
                    Zona zonaAsignar = buscarZona(zonas, nombreZonaAsignar);

                    if (zonaAsignar != null) {
                        System.out.print("Ingrese el monto a asignar: ");
                        double monto = scanner.nextDouble();
                        zonaAsignar.asignarPresupuesto(monto);
                        System.out.println("Presupuesto asignado con éxito.");
                    } else {
                        System.out.println("Zona no encontrada.");
                    }
                    break;

                case 3:
                    // Consultar presupuesto disponible
                    System.out.print("Ingrese el nombre de la zona a consultar: ");
                    String nombreZonaConsultar = scanner.next();
                    Zona zonaConsultar = buscarZona(zonas, nombreZonaConsultar);

                    if (zonaConsultar != null) {
                        System.out.println("Presupuesto disponible en " + zonaConsultar.getNombre() + ": $" + zonaConsultar.consultarDisponible());
                    } else {
                        System.out.println("Zona no encontrada.");
                    }
                    break;

                case 4:
                    // Simular mes
                    for (Zona zona : zonas) {
                        zona.simularMes();
                    }
                    System.out.println("Se ha simulado un mes de gastos.");
                    break;

                case SALIR:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static Zona buscarZona(ArrayList<Zona> zonas, String nombre) {
        for (Zona zona : zonas) {
            if (zona.getNombre().equals(nombre)) {
                return zona;
            }
        }
        return null;
    }
}
