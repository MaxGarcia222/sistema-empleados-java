package sistemaEmpleados;

public class EmpleadoPorHoras extends Empleado {

    private int horasTrabajadas;
    private double cobroHora;

    public EmpleadoPorHoras(String nombre, String dni, int horasTrabajadas, double cobroHora) {
        super(nombre, dni);
        this.horasTrabajadas = horasTrabajadas;
        this.cobroHora = cobroHora;
    }

    public EmpleadoPorHoras() {
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getCobroHora() {
        return cobroHora;
    }

    public void setCobroHora(double cobroHora) {
        this.cobroHora = cobroHora;
    }

    @Override
    public String toString() {
        return "EmpleadoPorHoras{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", cobroHora=" + cobroHora +
                '}';
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * cobroHora;
    }
}