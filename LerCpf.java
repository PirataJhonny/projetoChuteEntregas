package tratativas;
import java.util.Scanner;

/**
 * A classe LerCpf é responsável por ler e validar um número de CPF digitado pelo usuário.
 */
public class LerCpf {

    private static final Scanner ler = new Scanner(System.in);
    
    /**
     * Valida um número de CPF digitado pelo usuário.
     * @return O número do CPF validado.
     */
    public static String validaCpf() {

        String cpf;

        // Solicitar ao usuário que digite o CPF até que ele seja válido
        while (true) {
            cpf = ler.nextLine();

            // Verificar se o CPF está no formato padrão
            if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                // CPF já está formatado no formato padrão, não é necessário fazer nada
                break; // Sai do loop se o CPF estiver no formato padrão
            } else if (cpf.matches("[0-9]+") && cpf.length() == 11) {
                // Formatar o CPF se não estiver no formato padrão
                cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
                break;
            } else {
                System.out.println("CPF inválido. Deve estar no formato padrão (###.###.###-##) ou ser composto apenas por números e ter 11 dígitos.");
            }
        }

        return cpf; // Retorna o CPF validado
    }
}
