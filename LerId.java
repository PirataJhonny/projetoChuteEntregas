

package tratativas;

import java.util.Scanner;

/**
 * A classe LerId é responsável por ler e validar um ID digitado pelo usuário.
 */
public class LerId {
    private static final Scanner ler = new Scanner(System.in);

    /**
     * Valida um ID digitado pelo usuário.
     * @return O ID validado.
     */
    public static String validaId() {
        String id;
        while (true) {
            id = ler.nextLine().toUpperCase(); // Converte a entrada para maiúsculas

            // Verificar se o ID está no formato especificado
            if (id.matches("[A-Z]{2}-\\d{8}-\\d{4}-\\d{2,}-\\d{2}")) {
                break; // Sai do loop se o ID estiver no formato padrão
            } else if (id.matches("[A-Z]{2}\\d{8}\\d{4}\\d{2,}\\d{2}")) {
                // Adicionar traços se não estiverem presentes
                id = id.substring(0, 2) + "-" + id.substring(2, 10) + "-" + id.substring(10, 14) + "-" + id.substring(14, id.length() - 2) + "-" + id.substring(id.length() - 2);
                break;
            } else {
                System.out.println("ID inválido. Deve estar no formato padrão (RR-03062024-0309-50-50 ou RR-03062024-0309-5045-50).");
            }
        }

        return id;
    }
}
