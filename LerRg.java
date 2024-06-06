package tratativas;
import java.util.Scanner;

/**
 * A classe LerRg é responsável por ler e validar um número de RG digitado pelo usuário.
 */
public class LerRg {

    /**
     * Valida um número de RG digitado pelo usuário.
     * @return O número de RG validado.
     */
    public static String validaRg() {
        @SuppressWarnings("resource")
        Scanner ler = new Scanner(System.in);
        String rg;

        // Solicitar ao usuário que digite o RG até que ele seja válido
        while (true) {
            rg = ler.nextLine();

            // Verificar se o RG está no formato padrão
            if (rg.matches("\\d{2,}")) {
                // RG já está formatado no formato padrão, não é necessário fazer nada
                break; // Sai do loop se o RG estiver no formato padrão
            } else if (rg.matches("[0-9]+") && rg.length() == 9) {
                // Formatar o RG se não estiver no formato padrão
                rg = rg.substring(0, 2) + "." + rg.substring(2, 5) + "." + rg.substring(5, 8) + "-" + rg.substring(8);
                break;
            } else {
                System.out.println("RG inválido.");
            }
        }

        System.out.println("RG digitado: " + rg);
        return rg; // Retorna o RG validado
    }
}
