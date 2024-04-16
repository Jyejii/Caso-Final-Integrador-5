public class SumaLista {

    // Función recursiva para calcular la suma de los números naturales hasta n
    public static int sumaNaturales(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaNaturales(n - 1);
        }
    }

    // Función recursiva para listar números en un rango dado
    public static void listarNumeros(int inicio, int fin) {
        if (inicio <= fin) {
            System.out.print(inicio + " ");
            listarNumeros(inicio + 1, fin);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        int inicio = 1;
        int fin = 10;

        // Calculando la suma de los primeros 'numero' números naturales
        int suma = sumaNaturales(numero);
        System.out.println("La suma de los primeros " + numero + " números naturales es: " + suma);

        // Listando números en el rango de 'inicio' a 'fin'
        System.out.print("Los números en el rango de " + inicio + " a " + fin + " son: ");
        listarNumeros(inicio, fin);
    }
}
