import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zona {
    private String nombre;
    private Presupuesto presupuesto;

    public Zona(String nombre) {
        this.nombre = nombre;
        save();
    }

    public Zona(String nombre, double monto) {
        this.nombre = nombre;
        this.presupuesto = new Presupuesto(monto);
    }

    public static ArrayList<Zona> loadZonas(String path) throws IOException {
        ArrayList<Zona> zonas = new ArrayList<>();
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nombre = parts[0];
                double monto = parts.length > 1 && !parts[1].isEmpty() ? Double.parseDouble(parts[1]) : 0;
                Zona zona = new Zona(nombre, monto);
                zonas.add(zona);
            }
        }
        return zonas;
    }


    public void asignarPresupuesto(double monto) throws IOException {
        presupuesto = new Presupuesto(monto);
        updatePresupuestoInFile(monto);
    }

    private void updatePresupuestoInFile(double monto) throws IOException {
        File file = new File("zonas.csv");
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(nombre)) {
                    line = nombre + "," + Presupuesto.montoUsado;
                }
                lines.add(line);
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

    public double consultarDisponible() {
        return presupuesto.consultarDisponible();
    }

    public String getNombre() {
        return nombre;
    }

    public void simularMes() {
        double gastoAgua = 100.0;
        double gastoElectricidad = 150.0;

        if (presupuesto != null) {
            presupuesto.gastar(gastoAgua + gastoElectricidad);
        }
    }

    private void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("zonas.csv", true))) {
            writer.println(nombre + ",");
        } catch (IOException e) {
            System.out.println("Error al guardar la zona: " + e.getMessage());
        }
    }
}
