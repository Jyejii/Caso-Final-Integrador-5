import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Evento {
    private int dia;
    private int mes;
    private int año;

    public Evento(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
}

public class Fecha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Evento> eventos = new ArrayList<>();

        System.out.println("Bienvenido al Gestor de Eventos!");

        // Loop para ingresar fechas
        while (true) {
            System.out.println("\nPor favor, introduzca una fecha (formato: DD MM AAAA), escriba 'listar' para ver las fechas ingresadas, o 'salir' para acabar:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("listar")) {
                if (eventos.isEmpty()) {
                    System.out.println("No se han ingresado fechas aún.");
                } else {
                    System.out.println("Fechas ingresadas:");
                    listarEventos(eventos);
                }
            } else if (input.equalsIgnoreCase("salir")) {
                break; // Salir del bucle si el usuario escribe 'salir'
            } else {
                try {
                    String[] partes = input.split(" ");
                    int dia = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int año = Integer.parseInt(partes[2]);

                    eventos.add(new Evento(dia, mes, año));
                    System.out.println("Fecha ingresada correctamente.");
                } catch (Exception e) {
                    System.out.println("Error: Formato de fecha incorrecto. Por favor, ingrese la fecha en el formato indicado.");
                }
            }
        }
        scanner.close(); // Cerrar el scanner al salir del bucle
    }

    // Método para listar los eventos ordenados
    public static void listarEventos(ArrayList<Evento> eventos) {
        // Ordenar los eventos utilizando un comparador personalizado
        Collections.sort(eventos, new Comparator<Evento>() {
            @Override
            public int compare(Evento e1, Evento e2) {
                if (e1.getAño() != e2.getAño()) {
                    return Integer.compare(e1.getAño(), e2.getAño());
                } else if (e1.getMes() != e2.getMes()) {
                    return Integer.compare(e1.getMes(), e2.getMes());
                } else {
                    return Integer.compare(e1.getDia(), e2.getDia());
                }
            }
        });

        // Imprimir los eventos ordenados
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }
}
