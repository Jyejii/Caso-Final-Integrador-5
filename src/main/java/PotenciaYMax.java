
public class PotenciaYMax {

    // Función para calcular potencia mediante multiplicaciones sucesivas
    public static double potencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * potencia(base, exponente - 1);
        } else {
            return (1 / base) * potencia(base, exponente + 1);
        }
    }

    // Función para encontrar el valor máximo en un conjunto de datos numéricos
    public static double encontrarMaximo(double[] datos) {
        if (datos.length == 0) {
            return Double.NaN; // Si el conjunto de datos está vacío, devolver NaN (Not-a-Number)
        }
        return encontrarMaximo(datos, datos.length - 1, Double.NEGATIVE_INFINITY);
    }

    private static double encontrarMaximo(double[] datos, int indice, double maximoActual) {
        if (indice < 0) {
            return maximoActual;
        }
        return encontrarMaximo(datos, indice - 1, Math.max(maximoActual, datos[indice]));
    }

    public static void main(String[] args) {
        double base = 2;
        int exponente = 5;
        double[] datos = {3.4, -5.2, 7.8, 10.5, -1.0, 9.6};

        // Calculando potencia mediante multiplicaciones sucesivas
        double resultadoPotencia = potencia(base, exponente);
        System.out.println("El resultado de " + base + " elevado " + exponente + " es: " + resultadoPotencia);

        // Encontrando el valor máximo en el conjunto de datos
        double maximo = encontrarMaximo(datos);
        System.out.println("El valor máximo en el conjunto de datos es: " + maximo);
    }
}
