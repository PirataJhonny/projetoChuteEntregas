import tratativas.LerCnpj;
import tratativas.LerCpf;
import tratativas.LerDados;
import tratativas.LerId;

/**
 * Classe responsável por oferecer opções de retorno para diferentes tipos de consultas.
 */
public class MenuRetorno {

    /**
     * Oferece opções de retorno para consultas relacionadas a veículos e motoristas.
     */
    public static void oferecerOpcoesVeiculo() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Voltar ao menu de Consulta");
            System.out.println("2 - Consultar outro Motorista / Veiculo");
            System.out.println("3 - Cadastrar novo Motorista / Veiculo");
            System.out.println("4 - Sair");
            System.out.print("Digite a sua escolha: ");
            String escolha = LerDados.lerTexto();

            switch (escolha) {
                case "1":
                    // Retorna ao menu de consulta
                    ConsultaCadastro.menuConsulta();
                    return;
                case "2":
                    // Consulta outro motorista ou veículo
                    System.out.print("Digite o CPF do motorista a ser consultado: ");
                    String novoCpf = LerCpf.validaCpf();
                    ConsultarVeiculoMotorista.consultarPorCpf(novoCpf);
                    return;
                case "3":
                    // Cadastra novo motorista ou veículo
                    LerCadastroVeiculo.cadastroVeiculo();
                    return;
                case "4":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    /**
     * Oferece opções de retorno para consultas relacionadas a clientes.
     */
    public static void oferecerOpcoesCliente() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Voltar ao menu de Consulta");
            System.out.println("2 - Consultar outro Cliente");
            System.out.println("3 - Cadastrar novo Cliente");
            System.out.println("4 - Sair");
            System.out.print("Digite a sua escolha: ");
            String escolhaCliente = LerDados.lerTexto();

            switch (escolhaCliente) {
                case "1":
                    // Retorna ao menu de consulta
                    ConsultaCadastro.menuConsulta();
                    return;
                case "2":
                    // Consulta outro cliente
                    System.out.print("Digite o CNPJ do cliente a ser consultado: ");
                    String novoCnpj = LerCnpj.validaCnpj();
                    ConsultarCliente.consultarPorCnpj(novoCnpj);
                    return;
                case "3":
                    // Cadastra novo cliente
                    LerCadastroCliente.cadastroCliente();
                    return;
                case "4":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    /**
     * Oferece opções de retorno para consultas relacionadas a entregas.
     */
    public static void oferecerOpcoesEntrega() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Voltar ao menu de Consulta");
            System.out.println("2 - Consultar outra Entrega");
            System.out.println("3 - Cadastrar nova Entrega");
            System.out.println("4 - Sair");
            System.out.print("Digite a sua escolha: ");
            String escolhaCliente = LerDados.lerTexto();

            switch (escolhaCliente) {
                case "1":
                    // Retorna ao menu de consulta
                    ConsultaCadastro.menuConsulta();
                    return;
                case "2":
                    // Consulta outra entrega
                    System.out.print("Digite o CNPJ do cliente a ser consultado: ");
                    String novoIdPedido = LerId.validaId();
                    ConsultarEntrega.consultarPorIdPedido(novoIdPedido);
                    return;
                case "3":
                    // Cadastra nova entrega
                    LerCadastroEntrega.cadastroEntrega();
                    return;
                case "4":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
