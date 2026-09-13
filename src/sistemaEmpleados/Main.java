package sistemaEmpleados;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Empleado[] empleados = new Empleado[100];
        int cantidadEmpleados = 0;
        int seleccion = -1;
        int posicion;

        while (seleccion != 0) {

            System.out.println("========= SISTEMA DE EMPLEADOS =========\n" +
                    "\n" +
                    "        1. Cargar empleado tiempo completo\n" +
                    "        2. Cargar empleado por horas\n" +
                    "        3. Cargar empleado contratista\n" +
                    "        4. Mostrar todos los empleados\n" +
                    "        5. Calcular salario de un empleado\n" +
                    "        6. Mostrar salarios de todos\n" +
                    "        7. Buscar empleado\n" +
                    "        8. Mostrar empleado con mayor salario\n" +
                    "\n" +
                    "        0. Salir");

            seleccion = scan.nextInt();
            scan.nextLine();

            switch (seleccion) {

                case 1:
                    if (cantidadEmpleados >= empleados.length) {
                        System.out.println("No hay espacio para cargar más empleados.");
                        break;
                    }

                    empleados[cantidadEmpleados] =
                            cargarEmpleadoTiempoCompleto(
                                    scan,
                                    empleados,
                                    cantidadEmpleados
                            );

                    System.out.println("Su salario es de: $" +
                            empleados[cantidadEmpleados].calcularSalario());

                    cantidadEmpleados++;
                    break;

                case 2:
                    if (cantidadEmpleados >= empleados.length) {
                        System.out.println("No hay espacio para cargar más empleados.");
                        break;
                    }

                    empleados[cantidadEmpleados] =
                            cargarEmpleadoPorHoras(scan, empleados, cantidadEmpleados);

                    System.out.println("Su salario es de: $" +
                            empleados[cantidadEmpleados].calcularSalario());

                    cantidadEmpleados++;
                    break;

                case 3:
                    if (cantidadEmpleados >= empleados.length) {
                        System.out.println("No hay espacio para cargar más empleados.");
                        break;
                    }

                    empleados[cantidadEmpleados] =
                            cargarEmpleadoContratista(scan, empleados, cantidadEmpleados);

                    System.out.println("Su salario es de: $" +
                            empleados[cantidadEmpleados].calcularSalario());

                    cantidadEmpleados++;
                    break;

                case 4:
                    if (cantidadEmpleados == 0) {
                        System.out.println("No hay empleados cargados.");
                    } else {
                        mostrarEmpleados(empleados, cantidadEmpleados);
                    }
                    break;

                case 5:
                    if (cantidadEmpleados == 0) {
                        System.out.println("No hay empleados cargados.");
                        break;
                    }

                    System.out.println("Ingrese el DNI del empleado: ");
                    String dni = scan.nextLine().trim();

                    Empleado empleado =
                            buscarEmpleadoPorDni(empleados, cantidadEmpleados, dni);

                    if (empleado != null) {

                        System.out.println("Empleado: " + empleado.getNombre());

                        System.out.println("Salario: $" +
                                empleado.calcularSalario());

                    } else {

                        System.out.println("Empleado no encontrado.");
                    }

                    break;

                case 6:
                    if (cantidadEmpleados == 0) {
                        System.out.println("No hay empleados cargados.");
                    } else {
                        mostrarSalarios(empleados, cantidadEmpleados);
                    }
                    break;

                case 7:
                    if (cantidadEmpleados == 0) {
                        System.out.println("No hay empleados cargados.");
                        break;
                    }

                    System.out.println("Ingrese el DNI del empleado que desea buscar: ");
                    String dniBuscado = scan.nextLine().trim();

                    Empleado empleadoEncontrado =
                            buscarEmpleadoPorDni(empleados, cantidadEmpleados, dniBuscado);

                    if (empleadoEncontrado != null) {
                        System.out.println("Empleado encontrado:");
                        System.out.println(empleadoEncontrado);
                    } else {
                        System.out.println("No se encontró ningún empleado con ese DNI.");
                    }

                    break;

                case 8:
                    if (cantidadEmpleados == 0) {
                        System.out.println("No hay empleados cargados.");
                    } else {
                        posicion = mayorSalario(empleados, cantidadEmpleados);
                        System.out.println("Empleado con mayor salario: " + empleados[posicion].getNombre()
                                + " Salario: $" + empleados[posicion].calcularSalario());
                    }

                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
    }

    public static String cargarDniValido(
            Scanner scan,
            Empleado[] empleados,
            int cantidadEmpleados) {

        String dni;
        Empleado encontrado;

        do {
            System.out.println("Ingrese DNI: ");
            dni = scan.nextLine().trim();
            //.trim sirve para eliminar espacios en blanco al principio y al final de un String
            if (dni.isEmpty()) {
                System.out.println("El DNI no puede estar vacío.");
                encontrado = null;
            } else {
                encontrado = buscarEmpleadoPorDni(
                        empleados,
                        cantidadEmpleados,
                        dni
                );

                if (encontrado != null) {
                    System.out.println("Ese DNI ya pertenece a otro empleado.");
                }
            }

        } while (dni.isEmpty() || encontrado != null);

        return dni;
    }

    public static double cargarDecimalPositivo(Scanner scan, String mensaje) {
        double numero;

        do {
            System.out.println(mensaje);
            numero = scan.nextDouble();

            if (numero < 0) {
                System.out.println("El valor no puede ser negativo.");
            }

        } while (numero < 0);

        return numero;
    }

    public static int cargarEnteroPositivo(Scanner scan, String mensaje) {
        int numero;

        do {
            System.out.println(mensaje);
            numero = scan.nextInt();

            if (numero < 0) {
                System.out.println("El valor no puede ser negativo.");
            }

        } while (numero < 0);

        return numero;
    }

    public static String cargarTextoNoVacio(Scanner scan, String mensaje) {
        String texto;

        do {
            System.out.println(mensaje);
            texto = scan.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("El valor no puede estar vacío.");
            }

        } while (texto.isEmpty());

        return texto;
    }

    public static EmpleadoTiempoCompleto cargarEmpleadoTiempoCompleto(
            Scanner scan,
            Empleado[] empleados,
            int cantidadEmpleados) {

        String nombre = cargarTextoNoVacio(scan, "Ingrese un nombre: ");

        String dni = cargarDniValido(
                scan,
                empleados,
                cantidadEmpleados
        );

        double sueldoBasico = cargarDecimalPositivo(
                scan,
                "Ingrese sueldo básico: "
        );

        int antiguedad = cargarEnteroPositivo(
                scan,
                "Ingrese antigüedad: "
        );

        scan.nextLine();

        return new EmpleadoTiempoCompleto(
                nombre,
                dni,
                sueldoBasico,
                antiguedad
        );
    }

    public static EmpleadoPorHoras cargarEmpleadoPorHoras(
            Scanner scan,
            Empleado[] empleados,
            int cantidadEmpleados) {

        String nombre = cargarTextoNoVacio(scan, "Ingrese un nombre: ");

        String dni = cargarDniValido(
                scan,
                empleados,
                cantidadEmpleados
        );

        int horasTrabajadas = cargarEnteroPositivo(
                scan,
                "Ingrese horas trabajadas: "
        );

        double precioHora = cargarDecimalPositivo(
                scan,
                "Ingrese precio por hora: "
        );

        scan.nextLine();

        return new EmpleadoPorHoras(
                nombre,
                dni,
                horasTrabajadas,
                precioHora
        );
    }

    public static EmpleadoContratista cargarEmpleadoContratista(
            Scanner scan,
            Empleado[] empleados,
            int cantidadEmpleados) {

        String nombre = cargarTextoNoVacio(scan, "Ingrese un nombre: ");

        String dni = cargarDniValido(
                scan,
                empleados,
                cantidadEmpleados
        );

        int horasTrabajadas = cargarEnteroPositivo(
                scan,
                "Ingrese horas trabajadas: "
        );

        double tarifaHora = cargarDecimalPositivo(
                scan,
                "Ingrese tarifa por hora: "
        );

        scan.nextLine();

        String proyecto = cargarTextoNoVacio(scan, "Ingrese el nombre del proyecto: ");

        return new EmpleadoContratista(
                nombre,
                dni,
                horasTrabajadas,
                tarifaHora,
                proyecto
        );
    }

    public static void mostrarEmpleados(
            Empleado[] empleados,
            int cantidadEmpleados) {

        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println(empleados[i]);
        }
    }

    public static Empleado buscarEmpleadoPorDni(
            Empleado[] empleados,
            int cantidadEmpleados,
            String dniBuscado) {

        for (int i = 0; i < cantidadEmpleados; i++) {

            if (empleados[i].getDni().equals(dniBuscado)) {
                return empleados[i];
            }
        }

        return null;
    }

    public static int mayorSalario(Empleado[] empleados, int cantidadEmpleados) {

        double salarioMayor = empleados[0].calcularSalario();
        int posicionEmpleado = 0;

        for (int i = 1; i < cantidadEmpleados; i++) {

            double salarioActual = empleados[i].calcularSalario();

            if (salarioActual > salarioMayor) {
                salarioMayor = salarioActual;
                posicionEmpleado = i;
            }
        }

        return posicionEmpleado;
    }

    public static void mostrarSalarios(Empleado[] empleados, int cantidadEmpleados) {

        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println("Empleado: " + empleados[i].getNombre());
            System.out.println("Salario: $" + empleados[i].calcularSalario());
        }
    }
}