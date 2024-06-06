package tratativas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * A classe LerDados é responsável por ler diferentes tipos de dados digitados pelo usuário.
 */
public class LerDados {

    private static final Scanner scan = new Scanner(System.in);

    /**
     * Lê um número inteiro digitado pelo usuário.
     * @param tenteNovamente A mensagem a ser exibida se a entrada for inválida.
     * @return O número inteiro lido.
     */
    public static int lerInt(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    /**
     * Lê um número decimal (double) digitado pelo usuário.
     * @param tenteNovamente A mensagem a ser exibida se a entrada for inválida.
     * @return O número decimal lido.
     */
    public static double lerDouble(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    /**
     * Lê uma linha de texto digitada pelo usuário.
     * @return A linha de texto lida.
     */
    public static String lerTexto() {
        return scan.nextLine();
    }

    /**
     * Lê uma linha de texto digitada pelo usuário e converte para letras maiúsculas.
     * @return A linha de texto lida e convertida para maiúsculas.
     */
    public static String lerTextoMesclado() {
        while (true) {
            var linha = scan.nextLine();
            // Permite letras (a-z, A-Z), números (0-9), espaços e caracteres especiais/acentuados
            if (linha.matches("^[a-z|^A-Z|^0-9|ç|Ç|á|é|í|ó|ú|â|ê|î|ô|û|ã|õ|à|è|ì|ò|ù|ä|ë|ï|ö|ü|Á|É|Í|Ó|Ú|Â|Ê|Î|Ô|Û|Ã|Õ|À|È|Ì|Ò|Ù|Ä|Ë|Ï|Ö|Ü^\\s]+$")) {
                return linha.toUpperCase(); // Converte a entrada para maiúsculas
            } else {
                // Exibe uma mensagem de erro se a entrada for inválida
                System.out.println("Entrada inválida. Deve conter apenas letras, números e espaços.");
            }
        }
    }

    /**
     * Obtém a data e hora atuais formatadas.
     * @return A data e hora atuais formatadas.
     */
    public static String obterDataHoraAtual() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formatter);
    }

}
