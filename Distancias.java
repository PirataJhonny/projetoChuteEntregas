import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar distâncias entre estados e validar siglas de estados.
 */
public class Distancias {
    private static final Map<String, Integer> DISTANCIAS;
    private static final Set<String> SIGLAS_ESTADOS_VALIDAS;
    private static final Scanner ler = new Scanner(System.in);

    // Inicializa o mapa de distâncias e o conjunto de siglas de estados válidas
    static {
        DISTANCIAS = new HashMap<>();
        DISTANCIAS.put("RJ", 434);
        DISTANCIAS.put("MG", 586);
        DISTANCIAS.put("ES", 879);
        DISTANCIAS.put("PR", 408);
        DISTANCIAS.put("RS", 1110);
        DISTANCIAS.put("SC", 705);
        DISTANCIAS.put("MS", 1013);
        DISTANCIAS.put("GO", 926);
        DISTANCIAS.put("DF", 1015);
        DISTANCIAS.put("BA", 1959);
        DISTANCIAS.put("AL", 2231);
        DISTANCIAS.put("SE", 2141);
        DISTANCIAS.put("PE", 2616);
        DISTANCIAS.put("PB", 2735);
        DISTANCIAS.put("RN", 2995);
        DISTANCIAS.put("CE", 3134);
        DISTANCIAS.put("PI", 2714);
        DISTANCIAS.put("MA", 3024);
        DISTANCIAS.put("PA", 2940);
        DISTANCIAS.put("TO", 1842);
        DISTANCIAS.put("AM", 3869);
        DISTANCIAS.put("RR", 4561);
        DISTANCIAS.put("AC", 3488);
        DISTANCIAS.put("RO", 3097);
        DISTANCIAS.put("MT", 1637);
        DISTANCIAS.put("AP", 2959);

        SIGLAS_ESTADOS_VALIDAS = DISTANCIAS.keySet();
    }

    /**
     * Solicita ao usuário a sigla de um estado e valida a entrada.
     *
     * @return a sigla do estado validada
     */
    public static String validaSiglaEstado() {
        String sigla;
        while (true) {
            System.out.print("Estado do destinatário (opções: " + String.join(", ", SIGLAS_ESTADOS_VALIDAS) + "): ");
            sigla = ler.nextLine().trim().toUpperCase();
            if (SIGLAS_ESTADOS_VALIDAS.contains(sigla)) {
                break;
            } else {
                System.out.println("Sigla inválida. Tente novamente.");
            }
        }
        return sigla;
    }

    /**
     * Obtém a distância até um estado dado sua sigla.
     *
     * @param estado a sigla do estado
     * @return a distância em quilômetros até o estado ou 0 se a sigla não for encontrada
     */
    public static int getDistancia(String estado) {
        return DISTANCIAS.getOrDefault(estado.toUpperCase(), 0);
    }
}
