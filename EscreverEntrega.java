import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Esta classe é responsável por escrever os detalhes de uma entrega em um arquivo de texto.
 */
public class EscreverEntrega {

    /**
     * Escreve os detalhes de uma entrega em um arquivo de texto.
     *
     * @param entrega a entrega da qual os detalhes serão escritos no arquivo
     */
    public static void escreverEntrega(Entrega entrega) {
        String nomeArquivo = "cadastro_entregas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("==== Folha de Pedido ====\n");
            writer.write("ID do Pedido: " + entrega.id() + "\n");
            writer.write("Data e hora: " + entrega.dataHoraFormatada() + "\n");
            Cliente remetente = entrega.remetente();
            writer.write("Remetente:\n");
            writer.write("Nome do remetente: " + remetente.nomeCliente() + "\n");
            writer.write("CNPJ do remetente: " + remetente.cnpjCliente() + "\n");
            writer.write("Rua do remetente: " + remetente.ruaCliente() + "\n");
            writer.write("Número do remetente: " + remetente.numeroCasa() + "\n");
            writer.write("Bairro do remetente: " + remetente.bairroCliente() + "\n");
            writer.write("Cidade do remetente: " + remetente.cidadeCliente() + "\n");
            writer.write("Estado do remetente: " + remetente.estadoCliente() + "\n");
            writer.write("CEP do remetente: " + remetente.cepCliente() + "\n");

            writer.write("\nDestinatário:\n");
            writer.write("Nome do destinatário: " + entrega.nomeDestinatario() + "\n");
            writer.write("CNPJ do destinatário: " + entrega.cnpjDestinatario() + "\n");
            writer.write("Rua do destinatário: " + entrega.ruaDestinatario() + "\n");
            writer.write("Número do destinatário: " + entrega.numeroDestinatario() + "\n");
            writer.write("Bairro do destinatário: " + entrega.bairroDestinatario() + "\n");
            writer.write("Cidade do destinatário: " + entrega.cidadeDestinatario() + "\n");
            writer.write("Estado do destinatário: " + entrega.estadoDestinatario() + "\n");
            writer.write("CEP do destinatário: " + entrega.cepDestinatario() + "\n");

            writer.write("\nObjetos:\n");
            for (ObjetoEntrega objeto : entrega.objetos()) {
                writer.write("Quantidade: " + objeto.quantidade() + ", ");
                writer.write("Altura: " + objeto.altura() + " cm, ");
                writer.write("Largura: " + objeto.largura() + " cm, ");
                writer.write("Comprimento: " + objeto.comprimento() + " cm, ");
                writer.write("Peso: " + objeto.peso() + " kg, ");
                writer.write("Cubagem Total: " + objeto.cubagem() + " cm³, ");
                writer.write("Peso Total: " + objeto.pesoTotal() + " kg, ");
                writer.write("Peso Cubado: " + objeto.pesoCubado() + " kg\n");
            }

            writer.write("FimObjetos\n");

            writer.write("\nTotais:\n");
            writer.write("Quantidade Total de Volumes: " + entrega.quantidadeTotal() + "\n");
            writer.write("Cubagem Total: " + entrega.cubagemTotal() + " m³\n");
            writer.write("Peso Total: " + entrega.pesoTotal() + " kg\n");
            writer.write("Número de Carretas: " + entrega.numeroCarretas() + "\n");
            writer.write("Custo da Cubagem: R$ " + entrega.custoCubagem() + "\n");
            writer.write("Distância até o destino: " + entrega.distanciaDestino() + " km\n");
            writer.write("Custo por Distância: R$ " + entrega.custoPorDistancia() + "\n");
            writer.write("Custo Total do Frete: R$ " + entrega.custoTotalFrete() + "\n");

            writer.write("==========================\n\n");

            System.out.println("Entrega salva com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar a entrega no arquivo: " + e.getMessage());
        }
    }
}
