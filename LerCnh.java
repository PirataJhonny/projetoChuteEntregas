package tratativas;

import java.util.Scanner;

/**
 * A classe LerCnh é responsável por ler e validar um número de CNH digitado pelo usuário.
 */
public class LerCnh {

    private static final Scanner ler = new Scanner(System.in);

    /**
     * Valida um número de CNH digitado pelo usuário.
     * @return O número da CNH validado.
     */
    public static String validaCnh() {
        
        String cnh;

        // Solicitar ao usuário que digite o CNH até que ele seja válido
        while (true) {
            cnh = ler.nextLine();

            // Verificar se o CNH está no formato padrão
            if (cnh.matches("[0-9]+") && cnh.length() == 11) {
                break;
            } else {
                System.out.println("CNH inválido. Deve ser composto apenas por números e ter 11 dígitos.");
            }
        }

        return cnh; // Retorna o CNH validado
    }
}
