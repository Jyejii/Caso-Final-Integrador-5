public class CombinacionesGeneticas {

    public static int calcularCombinacionesGeneticas(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return calcularCombinacionesGeneticas(n - 1, k - 1) + calcularCombinacionesGeneticas(n - 1, k);
        }
    }

    public static void main(String[] args) {
        int n = 5; // Número total de elementos
        int k = 3; // Número de elementos a elegir
        int combinaciones = calcularCombinacionesGeneticas(n, k);
        System.out.println("Número de combinaciones genéticas: " + combinaciones);
    }
}
