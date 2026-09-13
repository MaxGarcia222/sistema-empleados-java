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
        if (this.anioAntiguedad < 2){
            return sueldoBasico;
        } else if (this.anioAntiguedad <= 5 && this.anioAntiguedad >= 2){
            return sueldoBasico + (sueldoBasico*0.05);
        } else if (this.anioAntiguedad >= 6 && this.anioAntiguedad <= 10){
            return sueldoBasico + (sueldoBasico*0.1);
        } else if (this.anioAntiguedad >= 11 && this.anioAntiguedad <= 15){
            return sueldoBasico + (sueldoBasico*0.15);
        } else {
            return sueldoBasico + (sueldoBasico*0.2);
        }
    }
}
