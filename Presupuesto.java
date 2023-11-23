// Clase Presupuesto
public class Presupuesto {

    public static String montoUsado;
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
        double MontoUsado= montoTotal - montoUtilizado;
        return MontoUsado;
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

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
