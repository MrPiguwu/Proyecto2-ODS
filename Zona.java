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

    // Otros métodos
}
