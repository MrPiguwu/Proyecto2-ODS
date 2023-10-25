// Clase Presupuesto
import java.util.ArrayList;
public class Presupuesto {

    private double montoTotal;
    private double montoUtilizado;

    public Presupuesto(double montoTotal) {
        this.montoTotal = montoTotal;
        this.montoUtilizado = 0;
    }

    public void gastar(double monto) {
        montoUtilizado += monto;
    }

    public double consultarDisponible() {
        return montoTotal - montoUtilizado;
    }

    // Otros métodos para consultar, reportar, etc.

}