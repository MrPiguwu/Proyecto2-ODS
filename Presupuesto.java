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
    private double montoAgua;
    private double montoElectricidad;

    public void asignarPresupuestoAgua(double monto) {
        montoAgua = monto;
    }

    public void asignarPresupuestoElectricidad(double monto) {
        montoElectricidad = monto;
    }

    public void gastarEnAgua(double monto) {
        montoAgua -= monto;
    }

    public void gastarEnElectricidad(double monto) {
        montoElectricidad -= monto;
    }

}
