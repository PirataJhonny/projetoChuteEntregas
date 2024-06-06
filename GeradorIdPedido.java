package tratativas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A classe GeradorIdPedido é responsável por gerar o ID de um pedido com base em informações específicas.
 */
public class GeradorIdPedido {

    /**
     * Gera o ID de um pedido utilizando o estado do destinatário, o total de caixas e o CNPJ do remetente.
     * @param estadoDestinatario A sigla do estado do destinatário.
     * @param totalCaixas O total de caixas no pedido.
     * @param cnpjRemetente O CNPJ do remetente.
     * @return O ID do pedido gerado.
     */
    public static String gerarIdPedido(String estadoDestinatario, int totalCaixas, String cnpjRemetente) {
        // Obter a data e hora atual
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        
        // Formatar a data e hora no formato desejado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy-HHmm");
        String dataHoraFormatada = dataHoraAtual.format(formatter);

        // Remover os pontos e barras do CNPJ do remetente
        String cnpjRemetenteSemFormatacao = cnpjRemetente.replaceAll("[^0-9]", "");

        // Obter os dois últimos dígitos do CNPJ do remetente
        String doisUltimosDigitosCnpj = cnpjRemetenteSemFormatacao.substring(12, 14);

        // Obter a sigla do estado do destinatário em letras maiúsculas
        String siglaEstado = estadoDestinatario.toUpperCase();

        // Construir o ID do pedido conforme o formato especificado
        String idPedido = siglaEstado + "-" + dataHoraFormatada + "-" + totalCaixas + "-" + doisUltimosDigitosCnpj;

        return idPedido;
    }
}
