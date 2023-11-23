import java.io.*;
import java.util.*;


public class Controller {
    private List<String[]> data = new ArrayList<>();

    public void loadData(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            data.add(line.split(","));
        }
        reader.close();
    }

    public void saveData(String path) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        for (String[] row : data) {
            writer.println(String.join(",", row));
        }
        writer.close();
    }

    public void editRow(int rowIndex, String[] newData) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            data.set(rowIndex, newData);
        }
    }

    private List<Zona> zonas = new ArrayList<>();

    public void loadZonas(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String nombre = parts[0];
            Zona zona = new Zona(nombre);
            zonas.add(zona);
        }
        reader.close();
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public String generarReporte() {

        try {
            loadData("zonas.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        double gastoTotal = 0;
        double presupuestoTotal = 0;

        for (String[] row : data) {

            String nombreZona = row[0];
            double montoInicial = Double.parseDouble(row[1]);

            Zona zona = buscarZona(nombreZona);

            double gastado = montoInicial - zona.consultarDisponible();
            gastoTotal += gastado;

            presupuestoTotal += montoInicial;

            // Más acumuladores
            int zonasTotales = 0;
            double minPresupuesto = 0;
            double maxPresupuesto = 0;

            // Acumular por zona
            zonasTotales++;
            if(montoInicial < minPresupuesto) {
                minPresupuesto = montoInicial;
            }
            if(montoInicial > maxPresupuesto) {
                maxPresupuesto = montoInicial;
            }

        }





        String tabla = "REPORTE DE PRESUPUESTOS\n\n";
        tabla += "| Zona | Gastado | Disponible | \n";

        return tabla;

    }

    private Zona buscarZona(String nombre) {

        for(Zona zona : zonas) {
            if(zona.getNombre().equals(nombre)) {
                return zona;
            }
        }

        return null;

    }

}
