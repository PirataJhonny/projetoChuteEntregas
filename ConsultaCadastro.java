import tratativas.LerCnpj;
import tratativas.LerCpf;
import tratativas.LerDados;
import tratativas.LerId;

/**
 * Classe responsável por exibir o menu de consulta e realizar consultas
 * de veículos/motoristas, clientes e entregas.
 */
public class ConsultaCadastro {

    /**
     * Exibe o menu de consulta e processa a escolha do usuário.
     */
    public static void menuConsulta() {
        // Submenu para a opção "Consultar"
        while (true) {
            System.out.println("======= Submenu Consulta =======");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Consulta Veículo/Motorista");
            System.out.println("2 - Consulta Cliente");
            System.out.println("3 - Consulta de Entregas");
            System.out.println("4 - Sair");
            System.out.println();
            System.out.print("Digite a sua escolha: ");
            var subEscolha = LerDados.lerTexto().toUpperCase();
            System.out.println();

            if (subEscolha.equals("1")) {
                consultarVeiculoMotorista();
            } else if (subEscolha.equals("2")) {
                consultarCliente();
            } else if (subEscolha.equals("3")) {
                consultarEntrega();
            } else if (subEscolha.equals("4")) {
                break;
            } else {
                System.out.println("Esta não é uma opção válida. Vamos tentar novamente!");
            }
        }
    }

    /**
     * Solicita o CPF do motorista e realiza a consulta de veículo/motorista.
     */
    private static void consultarVeiculoMotorista() {
        System.out.println("Digite o CPF do motorista a ser consultado: ");
        String cpf = LerCpf.validaCpf();
        ConsultarVeiculoMotorista.consultarPorCpf(cpf);
    }

    /**
     * Solicita o CNPJ do cliente e realiza a consulta do cliente.
     */
    private static void consultarCliente() {
        System.out.print("Digite o CNPJ do cliente a ser consultado: ");
        String cnpj = LerCnpj.validaCnpj();
        ConsultarCliente.consultarPorCnpj(cnpj);
    }

    /**
     * Solicita o ID da entrega e realiza a consulta da entrega.
     */
    private static void consultarEntrega() {
        System.out.print("Digite o ID da entrega a ser consultado: ");
        String id = LerId.validaId();
        ConsultarEntrega.consultarPorIdPedido(id);
    }
}
