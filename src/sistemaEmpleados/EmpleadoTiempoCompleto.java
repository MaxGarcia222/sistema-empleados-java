package sistemaEmpleados;

public class EmpleadoTiempoCompleto extends  Empleado{

    private double sueldoBasico;
    private int anioAntiguedad;

    public EmpleadoTiempoCompleto(String nombre, String dni, double sueldoBasico, int anioAntiguedad) {
        super(nombre, dni);
        this.sueldoBasico = sueldoBasico;
        this.anioAntiguedad = anioAntiguedad;
    }

    public EmpleadoTiempoCompleto() {
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }


    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getAnioAntiguedad() {
        return anioAntiguedad;
    }

    public void setAnioAntiguedad(int anioAntiguedad) {
        this.anioAntiguedad = anioAntiguedad;
    }

    @Override
    public String toString() {
        return "EmpleadoTiempoCompleto{" +
                "sueldoBasico=" + sueldoBasico +
                ", anioAntiguedad=" + anioAntiguedad +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    @Override
    public double calcularSalario() {
        if (anioAntiguedad < 2) {
            return sueldoBasico;
        } else if (anioAntiguedad <= 5) {
            return sueldoBasico * 1.05;
        } else if (anioAntiguedad <= 10) {
            return sueldoBasico * 1.10;
        } else if (anioAntiguedad <= 15) {
            return sueldoBasico * 1.15;
        } else {
            return sueldoBasico * 1.20;
        }
    }
}
