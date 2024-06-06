import java.util.List;

/**
 * Representa uma entrega, contendo informações sobre o remetente, destinatário e os objetos a serem entregues.
 */
public record Entrega(
        String id,
        String dataHoraFormatada,
        Cliente remetente,
        String nomeRemetente,
        String cnpjRemetente,
        String ruaRemetente,
        int numeroRemetente,
        String bairroRemetente,
        String cidadeRemetente,
        String estadoRemetente,
        String cepRemetente,
        String nomeDestinatario,
        String cnpjDestinatario,
        String ruaDestinatario,
        int numeroDestinatario,
        String bairroDestinatario,
        String cidadeDestinatario,
        String estadoDestinatario,
        String cepDestinatario,
        List<ObjetoEntrega> objetos,
        int quantidadeTotal,
        double cubagemTotal,
        double pesoTotal,
        int numeroCarretas,
        double custoCubagem,
        double distanciaDestino,
        double custoPorDistancia,
        double custoTotalFrete
        ) {

    /**
     * Cria uma nova instância de Entrega.
     *
     * @param id                  ID da entrega
     * @param dataHoraFormatada   Data e hora da entrega formatada
     * @param remetente           Cliente remetente
     * @param nomeRemetente       Nome do remetente
     * @param cnpjRemetente       CNPJ do remetente
     * @param ruaRemetente        Rua do remetente
     * @param numeroRemetente     Número do remetente
     * @param bairroRemetente     Bairro do remetente
     * @param cidadeRemetente     Cidade do remetente
     * @param estadoRemetente     Estado do remetente
     * @param cepRemetente        CEP do remetente
     * @param nomeDestinatario    Nome do destinatário
     * @param cnpjDestinatario    CNPJ do destinatário
     * @param ruaDestinatario     Rua do destinatário
     * @param numeroDestinatario  Número do destinatário
     * @param bairroDestinatario  Bairro do destinatário
     * @param cidadeDestinatario  Cidade do destinatário
     * @param estadoDestinatario  Estado do destinatário
     * @param cepDestinatario     CEP do destinatário
     * @param objetos             Lista de objetos da entrega
     * @param quantidadeTotal     Quantidade total de objetos
     * @param cubagemTotal        Cubagem total dos objetos
     * @param pesoTotal           Peso total dos objetos
     * @param numeroCarretas      Número de carretas
     * @param custoCubagem        Custo da cubagem
     * @param distanciaDestino    Distância até o destino
     * @param custoPorDistancia   Custo por distância
     * @param custoTotalFrete     Custo total do frete
     * @return                    Nova instância de Entrega
     */
    public static Entrega criarEntrega(String id, String dataHoraFormatada, Cliente remetente, 
                                    String nomeRemetente, String cnpjRemetente, String ruaRemetente, int numeroRemetente,
                                    String bairroRemetente, String cidadeRemetente, String estadoRemetente, String cepRemetente,
                                    String nomeDestinatario, String cnpjDestinatario, String ruaDestinatario, int numeroDestinatario,
                                    String bairroDestinatario, String cidadeDestinatario, String estadoDestinatario, String cepDestinatario,
                                    List<ObjetoEntrega> objetos, int quantidadeTotal, double cubagemTotal, double pesoTotal, int numeroCarretas,
                                    double custoCubagem, double distanciaDestino, double custoPorDistancia, double custoTotalFrete) {
        
        return new Entrega(id, dataHoraFormatada, remetente, nomeRemetente, cnpjRemetente, ruaRemetente, numeroRemetente,
                        bairroRemetente, cidadeRemetente, estadoRemetente, cepRemetente, nomeDestinatario, cnpjDestinatario, ruaDestinatario,
                        numeroDestinatario, bairroDestinatario, cidadeDestinatario, estadoDestinatario, cepDestinatario,
                        objetos, quantidadeTotal, cubagemTotal, pesoTotal, numeroCarretas, custoCubagem, distanciaDestino,
                        custoPorDistancia, custoTotalFrete);
    }

    /**
     * Exibe os detalhes da entrega.
     */
    public void exibirDetalhesEntrega() {
        System.out.println("\nDetalhes da Entrega:");
        System.out.println("ID do Pedido: " + id());
        System.out.println("Data e hora: " + dataHoraFormatada());
        System.out.println("Nome do remetente: " + remetente.nomeCliente());
        System.out.println("CNPJ do remetente: " + remetente.cnpjCliente());
        System.out.println("Rua do remetente: " + remetente.ruaCliente());
        System.out.println("Número do remetente: " + remetente.numeroCasa());
        System.out.println("Bairro do remetente: " + remetente.bairroCliente());
        System.out.println("Cidade do remetente: " + remetente.cidadeCliente());
        System.out.println("Estado do remetente: " + remetente.estadoCliente());
        System.out.println("CEP do remetente: " + remetente.cepCliente());

        System.out.println("\nDestinatário:");
        System.out.println("Nome do destinatário: " + nomeDestinatario());
        System.out.println("CNPJ do destinatário: " + cnpjDestinatario());
        System.out.println("Rua do destinatário: " + ruaDestinatario());
        System.out.println("Número do destinatário: " + numeroDestinatario());
        System.out.println("Bairro do destinatário: " + bairroDestinatario());
        System.out.println("Cidade do destinatário: " + cidadeDestinatario());
        System.out.println("Estado do destinatário: " + estadoDestinatario());
        System.out.println("CEP do destinatário: " + cepDestinatario());

        System.out.println("\nObjetos:");
        for (ObjetoEntrega objeto : objetos()) {
            System.out.println("Quantidade: " + objeto.quantidade() +
                            ", Altura: " + objeto.altura() + " cm" +
                            ", Largura: " + objeto.largura() + " cm" +
                            ", Comprimento: " + objeto.comprimento() + " cm" +
                            ", Peso: " + objeto.peso() + " kg" +
                            ", Cubagem Total: " + objeto.cubagem() + " cm³" +
                            ", Peso Total: " + objeto.pesoTotal() + " kg" +
                            ", Peso Cubado: " + objeto.pesoCubado() + " kg");
    }

        System.out.println("\nTotais:");
        System.out.println("Quantidade Total de Volumes: " + quantidadeTotal());
        System.out.println("Cubagem Total: " + cubagemTotal() + " m³");
        System.out.println("Peso Total: " + pesoTotal() + " kg");
        System.out.println("Número de Carretas: " + numeroCarretas());
        System.out.println("Custo da Cubagem: R$ " + custoCubagem());
        System.out.println("Distância até o destino: " + distanciaDestino() + " km");
        System.out.println("Custo por Distância: R$ " + custoPorDistancia());
        System.out.println("Custo Total do Frete: R$ " + custoTotalFrete());
    }

    /**
     * Calcula a cubagem total dos objetos da entrega.
     *
     * @return a cubagem total
     */
    public double cubagemTotal() {
        double cubagemTotal = 0.0;
        for (ObjetoEntrega objeto : objetos()) {
            cubagemTotal += objeto.cubagem();
        }
        return cubagemTotal;
    }
}
