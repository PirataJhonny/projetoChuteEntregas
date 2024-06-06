/**
 * A classe ChuteEntregasMenu implementa um menu para a aplicação Chutes Entregas.
 * Permite ao usuário realizar operações como cadastrar, consultar cadastros e acessar funcionalidades em produção.
 *
 * @author Jhonny, Vinicius e Camila
 * @version 3.4
 * @since 07/03/2024
 */

import tratativas.LerDados;

public class ChuteEntregasMenu {

    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Método principal que inicia o programa, chamando o menu principal.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     */
    private static void menuPrincipal() {
        while (true) {
            System.out.println("Bem vindo ao menu Chutes Entregas");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consulta de Cadastro");
            System.out.println("3 - Sair");
            System.out.println();
            System.out.print("Digite a sua escolha: ");
            var escolha = LerDados.lerTexto().toUpperCase();
            System.out.println();

            if (escolha.equals("1")) {
                MenuCadastro.menuCadastro();

            } else if (escolha.equals("2")) {
                ConsultaCadastro.menuConsulta();

            } else if (escolha.equals("3")) {
                return;

            } else {
                System.out.println("Esta não é uma opção válida. Vamos tentar novamente!");
            }
        }
    }
}
