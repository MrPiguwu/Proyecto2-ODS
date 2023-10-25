import java.util.ArrayList;

// Clase Zona

public class Zona {
    private String nombre;
    private Presupuesto presupuesto;

    public Zona(String nombre) {
        this.nombre = nombre;
    }

    public void asignarPresupuesto(double monto) {
        presupuesto = new Presupuesto(monto);
    }

    public double consultarDisponible() {
        return presupuesto.consultarDisponible();
    }

    public String getNombre() {
        return nombre;
    }

    public void simularMes() {
        // Simular gastos de agua y electricidad para un mes
        double gastoAgua = 100.0; // Gasto fijo de agua para un mes
        double gastoElectricidad = 150.0; // Gasto fijo de electricidad para un mes

        // Restar los gastos del presupuesto
        if (presupuesto != null) {
            presupuesto.gastar(gastoAgua + gastoElectricidad);
        }
    }
}
