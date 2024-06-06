package tratativas;
import java.util.Scanner;

/**
 * A classe LerCnpj é responsável por ler e validar um número de CNPJ digitado pelo usuário.
 */
public class LerCnpj {

    private static final Scanner ler = new Scanner(System.in);

    /**
     * Valida um número de CNPJ digitado pelo usuário.
     * @return O número do CNPJ validado.
     */
    public static String validaCnpj() {
        
        String cnpj;

        // Solicitar ao usuário que digite o CNPJ até que ele seja válido
        while (true) {
            cnpj = ler.nextLine();

            // Verificar se o CNPJ está no formato padrão
            if (cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2}")) {
                // CNPJ já está formatado no formato padrão, não é necessário fazer nada
                break; // Sai do loop se o CNPJ estiver no formato padrão
            } else if (cnpj.matches("[0-9]+") && cnpj.length() == 14) {
                // Formatar o CNPJ se não estiver no formato padrão
                cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/"
                        + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
                break;
            } else {
                System.out.println(
                        "CNPJ inválido. Deve estar no formato padrão (##.###.###/####-##) ou ser composto apenas por números e ter 14 dígitos.");
            }
        }

        return cnpj; // Retorna o CNPJ validado
    }
}
