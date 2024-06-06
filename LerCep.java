package tratativas;
import java.util.Scanner;

/**
 * A classe LerCep é responsável por ler e validar um CEP digitado pelo usuário.
 */
public class LerCep {
    
    private static final Scanner ler = new Scanner(System.in);

    /**
     * Valida um CEP digitado pelo usuário.
     * @return O CEP validado.
     */
    public static String validaCep() {

        String cep;

        // Solicitar ao usuário que digite o cep até que ele seja válido
        while (true) {
            cep = ler.nextLine();

            // Verificar se o cep está no formato padrão
            if (cep.matches("\\d{2}\\.\\d{3}-\\d{3}")) {
                // cep já está formatado no formato padrão, não é necessário fazer nada
                break; // Sai do loop se o cep estiver no formato padrão
            } else if (cep.matches("[0-9]+") && cep.length() == 8) {
                // Formatar o cep se não estiver no formato padrão
                cep = cep.substring(0, 2) + "." + cep.substring(2, 5) + "-" + cep.substring(5);
                break;
            } else {
                System.out.println("cep inválido. Deve estar no formato padrão (##.###-##) ou ser composto apenas por números e ter 8 dígitos.");
            }
        }

        return cep; // Retorna o cep validado
    }
}
