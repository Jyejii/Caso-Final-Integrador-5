public class ContadorGenes {

    public static int contarGenes(String cadenaADN) {
        return buscarGen(cadenaADN, 0);
    }

    private static int buscarGen(String cadenaADN, int posicion) {
        int inicio = cadenaADN.indexOf("ATG", posicion);

        if (inicio != -1) {
            int finTAG = cadenaADN.indexOf("TAG", inicio + 3);
            int finTAA = cadenaADN.indexOf("TAA", inicio + 3);
            int finTGA = cadenaADN.indexOf("TGA", inicio + 3);

            int siguienteGen = -1;

            if (finTAG != -1 && (finTAG < finTAA || finTAA == -1) && (finTAG < finTGA || finTGA == -1)) {
                siguienteGen = finTAG;
            } else if (finTAA != -1 && (finTAA < finTAG || finTAG == -1) && (finTAA < finTGA || finTGA == -1)) {
                siguienteGen = finTAA;
            } else if (finTGA != -1 && (finTGA < finTAG || finTAG == -1) && (finTGA < finTAA || finTAA == -1)) {
                siguienteGen = finTGA;
            }

            if (siguienteGen != -1) {
                return 1 + buscarGen(cadenaADN, siguienteGen + 3);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String cadenaADN = "ATGCGATAGATGCTAG";
        int cantidadGenes = contarGenes(cadenaADN);
        System.out.println("Cantidad de genes encontrados: " + cantidadGenes);
    }
}


