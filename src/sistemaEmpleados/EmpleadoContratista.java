package sistemaEmpleados;

public class EmpleadoContratista extends Empleado {

    private int horasTrabajadas;
    private double cobroHora;
    private String proyecto;

    public EmpleadoContratista(String nombre, String dni, int horasTrabajadas,
                               double cobroHora, String proyecto) {

        super(nombre, dni);

        this.horasTrabajadas = horasTrabajadas;
        this.cobroHora = cobroHora;
        this.proyecto = proyecto;
    }

    public EmpleadoContratista() {
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

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "EmpleadoContratista{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", cobroHora=" + cobroHora +
                ", proyecto='" + proyecto + '\'' +
                '}';
    }

    @Override
    public double calcularSalario() {
        return cobroHora * horasTrabajadas;
    }
}