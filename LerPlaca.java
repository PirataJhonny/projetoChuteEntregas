package tratativas;
import java.util.Scanner;

/**
 * A classe LerPlaca é responsável por ler e validar uma placa de veículo digitada pelo usuário.
 */
public class LerPlaca {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Valida uma placa de veículo digitada pelo usuário.
     * @return A placa de veículo validada.
     */
    public static String validaPlaca() {
        String placa;
        System.out.println("Digite a Placa (Ex1:AAA-0A00 ou AAA-0000: ");
        while (true) {
            placa = scanner.nextLine().toUpperCase(); // Converte a entrada para maiúsculas
            if (placa.matches("[A-Z]{3}-?\\d{4}") || placa.matches("[A-Z]{3}-?\\d[A-Z]\\d{2}")) {
                if (!placa.contains("-")) {
                    // Adiciona o hífen (-) se não estiver presente
                    placa = placa.substring(0, 3) + "-" + placa.substring(3);
                }
                break;
            } else {
                System.out.println("Placa inválida. Deve estar no formato padrão (AAA-1234 ou AAA1A23).");
            }
        }
        System.out.println("Placa digitada:" + placa);
        return placa;

    }

    /**
     * Retorna o dia de rodízio com base no último dígito da placa.
     * @param placa A placa do veículo.
     * @return O dia da semana correspondente ao rodízio.
     */
    public static String diaRodizio(String placa) {
        char ultimoDigito = placa.charAt(placa.length() - 1);
        switch (ultimoDigito) {
            case '1':
            case '2':
                return "segunda-feira";
            case '3':
            case '4':
                return "terça-feira";
            case '5':
            case '6':
                return "quarta-feira";
            case '7':
            case '8':
                return "quinta-feira";
            case '9':
            case '0':
                return "sexta-feira";
            default:
                return "";
        }
    }
}
