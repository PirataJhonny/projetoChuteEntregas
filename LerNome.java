package tratativas;
import java.util.Scanner;

/**
 * A classe LerNome é responsável por ler e validar um nome digitado pelo usuário.
 */
public class LerNome {
    
    /**
     * Método principal que chama o método de validação do nome e imprime o resultado.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        String nome = validaNome();
        System.out.println("Nome válido: " + nome);
    }

    /**
     * Chama o método de validação do nome.
     * @return O nome validado.
     */
    public static String validaNome() {
        Scanner ler = new Scanner(System.in);
        String nome = validaNome(ler);
        //ler.close();
        return nome;
    }

    /**
     * Valida um nome digitado pelo usuário.
     * @param scanner Scanner para ler a entrada do usuário.
     * @return O nome validado.
     */
    public static String validaNome(Scanner scanner) {
        String nome;
        do {
            nome = scanner.nextLine();
            if (!nome.matches("[a-zA-Z ]+")) {
                System.out.println("Nome inválido. Por favor, digite novamente.");
            }
        } while (!nome.matches("[a-zA-Z ]+"));
        return nome;
    }
}
