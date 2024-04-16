import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Buscar {
    // Búsqueda lineal en un archivo de texto
    public static int linearSearch(String filename, String target) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (line.contains(target)) {
                reader.close();
                return lineNumber;
            }
        }
        reader.close();
        return -1;
    }

    // Búsqueda binaria en un archivo de texto (requiere que el archivo esté ordenado)
    public static int binarySearch(String filename, String target) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int low = 0;
        int high = getTotalLines(filename) - 1;
        int lineNumber = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String line = getLine(filename, mid);
            int compare = target.compareTo(line);
            if (compare < 0)
                high = mid - 1;
            else if (compare > 0)
                low = mid + 1;
            else {
                lineNumber = mid + 1;
                break;
            }
        }

        reader.close();
        return lineNumber;
    }

    // Obtener el número total de líneas en un archivo
    public static int getTotalLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lines = 0;
        while (reader.readLine() != null)
            lines++;
        reader.close();
        return lines;
    }

    // Obtener una línea específica de un archivo
    public static String getLine(String filename, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        for (int i = 0; i <= lineNumber; i++) {
            line = reader.readLine();
        }
        reader.close();
        return line;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo de texto:");
        String filename = scanner.nextLine();

        System.out.println("Ingrese la palabra objetivo a buscar:");
        String target = scanner.nextLine();

        try {
            // Prueba de búsqueda lineal
            int lineNumLinear = linearSearch(filename, target);
            if (lineNumLinear != -1) {
                System.out.println("Búsqueda lineal: La palabra '" + target + "' se encontró en la línea " + lineNumLinear);
            } else {
                System.out.println("Búsqueda lineal: La palabra '" + target + "' no se encontró en el archivo.");
            }

            // Prueba de búsqueda binaria
            int lineNumBinary = binarySearch(filename, target);
            if (lineNumBinary != -1) {
                System.out.println("Búsqueda binaria: La palabra '" + target + "' se encontró en la línea " + lineNumBinary);
            } else {
                System.out.println("Búsqueda binaria: La palabra '" + target + "' no se encontró en el archivo.");
            }
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


