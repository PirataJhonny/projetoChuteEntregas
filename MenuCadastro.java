import tratativas.LerDados;

/**
 * Classe responsável por exibir o menu de cadastro e processar as escolhas do usuário.
 */
public class MenuCadastro {

    /**
     * Exibe o menu de cadastro e processa as escolhas do usuário.
     */
    public static void menuCadastro() {
        // Submenu para a opção "Cadastrar"
        while (true) {
            System.out.println("======= Submenu Cadastro =======");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastro Veículo/Motorista");
            System.out.println("2 - Cadastro Cliente");
            System.out.println("3 - Cadastro de Entregas");
            System.out.println("4 - Sair");
            System.out.println();
            System.out.print("Digite a sua escolha: ");
            var subEscolha = LerDados.lerTexto().toUpperCase();
            System.out.println();

            if (subEscolha.equals("1")) {
                // Opção para cadastrar veículo e motorista
                LerCadastroVeiculo.cadastroVeiculo();

            } else if (subEscolha.equals("2")) {
                // Opção para cadastrar cliente
                LerCadastroCliente.cadastroCliente();

            } else if (subEscolha.equals("3")) {
                // Opção para cadastrar entrega
                LerCadastroEntrega.cadastroEntrega();

            } else if(subEscolha.equals("4")) {
                // Opção para sair do menu
                break;

            } else {
                System.out.println("Esta não é uma opção válida. Vamos tentar novamente!");
            }
        }
    }
}
