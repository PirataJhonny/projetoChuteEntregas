import tratativas.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe é responsável por capturar e salvar os detalhes do cadastro de uma entrega.
 */
public class LerCadastroEntrega {

    /**
     * Realiza o cadastro de uma entrega, capturando suas informações e salvando no arquivo de cadastro de entregas.
     */
    public static void cadastroEntrega() {
        // Pedir CNPJ do cliente (remetente)
        System.out.print("Digite o CNPJ do cliente (remetente): ");
        String cnpjRemetente = LerCnpj.validaCnpj();

        // Consultar cliente pelo CNPJ (remetente)
        Cliente remetente = ConsultarCliente.consultarPorCnpj(cnpjRemetente);

        // Se o cliente (remetente) for encontrado
        if (remetente != null) {
            // Solicitar detalhes do destinatário
            System.out.println("Digite os detalhes do destinatário:");

            System.out.print("Nome do destinatário: ");
            String nomeDestinatario = LerNome.validaNome();

            System.out.print("CNPJ do destinatário: ");
            String cnpjDestinatario = LerCnpj.validaCnpj();

            System.out.print("Rua do destinatário: ");
            String ruaDestinatario = LerDados.lerTextoMesclado();

            System.out.print("Número do destinatário: ");
            int numeroDestinatario = LerDados.lerInt("Favor digitar um número inteiro: ");

            System.out.print("Bairro do destinatário: ");
            String bairroDestinatario = LerDados.lerTextoMesclado();

            System.out.print("Cidade do destinatário: ");
            String cidadeDestinatario = LerDados.lerTextoMesclado();

            // Usar o método de validação da sigla do estado
            String estadoDestinatario = Distancias.validaSiglaEstado();

            System.out.print("CEP do destinatário: ");
            String cepDestinatario = LerCep.validaCep();

            // Solicitar detalhes dos objetos
            List<ObjetoEntrega> objetos = lerDetalhesObjetos();

            // Calcular quantidade total de objetos
            int quantidadeTotal = objetos.stream().mapToInt(ObjetoEntrega::quantidade).sum();

            // Gerar ID único para a entrega
            String id = GeradorIdPedido.gerarIdPedido(estadoDestinatario, quantidadeTotal, cnpjRemetente);

            // Obter data e hora atual formatada
            LocalDateTime dataHoraAtual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy-HHmm");
            String dataHoraFormatada = dataHoraAtual.format(formatter);

            // Exibir a folha de pedido com as informações do remetente e destinatário
            System.out.println("\n==== Folha de Pedido ====");
            System.out.println("ID do Pedido: " + id);
            System.out.println("Data e hora: " + dataHoraFormatada);
            System.out.println("Remetente:");
            ConsultarCliente.exibirInformacoesCliente(remetente);
            System.out.println("Destinatário:");
            System.out.println("Nome do destinatário: " + nomeDestinatario);
            System.out.println("CNPJ do destinatário: " + cnpjDestinatario);
            System.out.println("Rua do destinatário: " + ruaDestinatario);
            System.out.println("Número do destinatário: " + numeroDestinatario);
            System.out.println("Bairro do destinatário: " + bairroDestinatario);
            System.out.println("Cidade do destinatário: " + cidadeDestinatario);
            System.out.println("Estado do destinatário: " + estadoDestinatario);
            System.out.println("CEP do destinatário: " + cepDestinatario);

            // Exibir detalhes dos objetos
            System.out.println("\nObjetos:");
            for (ObjetoEntrega objeto : objetos) {
                System.out.println(objeto);
            }

            // Exibir informações totais
            CalculoTransporte.exibirTotais(objetos, quantidadeTotal, estadoDestinatario);

            // Calcular totais para a entrega
            double cubagemTotal = objetos.stream().mapToDouble(ObjetoEntrega::cubagem).sum();
            double pesoTotal = objetos.stream().mapToDouble(ObjetoEntrega::pesoTotal).sum();
            int numeroCarretas = (int) Math.ceil(cubagemTotal / 90.0);
            double custoCubagem = cubagemTotal * 10;
            int distanciaDestino = Distancias.getDistancia(estadoDestinatario);
            double custoPorDistancia = distanciaDestino * 2;
            double custoTotalFrete = custoCubagem + custoPorDistancia;

            // Criar objeto Entrega com todas as informações
            Entrega entrega = new Entrega(id, dataHoraFormatada, remetente, null, cnpjRemetente, null, 0,
                    null, null, null, null, nomeDestinatario, cnpjDestinatario, ruaDestinatario,
                    numeroDestinatario, bairroDestinatario, cidadeDestinatario, estadoDestinatario, cepDestinatario,
                    objetos, quantidadeTotal, cubagemTotal, pesoTotal, numeroCarretas, custoCubagem, distanciaDestino,
                    custoPorDistancia, custoTotalFrete);

            // Chamar método para escrever a entrega em um arquivo
            EscreverEntrega.escreverEntrega(entrega);

        } else {
            System.out.println("Cliente com CNPJ " + cnpjRemetente + " não encontrado.");
        }
    }

    /**
     * Solicita e lê os detalhes dos objetos a serem entregues.
     * 
     * @return Uma lista de objetos de entrega.
     */
    private static List<ObjetoEntrega> lerDetalhesObjetos() {
        List<ObjetoEntrega> objetos = new ArrayList<>();
        
        while (true) {
            System.out.print("Quantidade de objetos (ou 0 para finalizar): ");
            int quantidade = LerDados.lerInt("Favor digitar um númerointeiro: ");
            if (quantidade == 0) {
                System.out.println("FimObjetos");
                break;
            }

            System.out.print("Altura do objeto (cm): ");
            double altura = LerDados.lerDouble("Favor digitar um número: ");

            System.out.print("Largura do objeto (cm): ");
            double largura = LerDados.lerDouble("Favor digitar um número: ");

            System.out.print("Comprimento do objeto (cm): ");
            double comprimento = LerDados.lerDouble("Favor digitar um número: ");

            System.out.print("Peso do objeto (kg): ");
            double peso = LerDados.lerDouble("Favor digitar um número: ");

            // Adiciona o objeto à lista de objetos
            objetos.add(new ObjetoEntrega(quantidade, altura, largura, comprimento, peso));
        }
        return objetos;
    }
}

