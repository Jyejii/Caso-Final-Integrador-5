import java.io.*;
import java.util.*;

public class Organizador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el nombre del archivo de entrada
        System.out.print("Ingrese el nombre del archivo de entrada: ");
        String archivoEntrada = scanner.nextLine();

        try {
            // Abrir el archivo de entrada para lectura
            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));

            // Leer las líneas del archivo y almacenarlas en una lista
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineas.add(linea);
            }
            lector.close();

            // Ordenar alfabéticamente las líneas
            Collections.sort(lineas);

            // Obtener el nombre del archivo de salida
            String archivoSalida = obtenerNombreArchivoSalida(archivoEntrada);

            // Abrir el archivo de salida para escritura
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

            // Escribir las líneas ordenadas en el archivo de salida
            for (String lineaOrdenada : lineas) {
                escritor.write(lineaOrdenada);
                escritor.newLine();
            }
            escritor.close();

            System.out.println("Las líneas se han ordenado alfabéticamente y guardado en " + archivoSalida);

        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }
    private static String obtenerNombreArchivoSalida(String archivoEntrada) {
        int puntoIndex = archivoEntrada.lastIndexOf('.');
        String nombreSinExtension = (puntoIndex == -1) ? archivoEntrada : archivoEntrada.substring(0, puntoIndex);
        return nombreSinExtension + "_ordenado.txt";
    }
}
