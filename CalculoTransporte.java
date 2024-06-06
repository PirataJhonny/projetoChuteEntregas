import java.util.List;

/**
 * Classe responsável pelo cálculo de custos de transporte e exibição de totais.
 */
public class CalculoTransporte {

    /**
     * Exibe os totais relacionados ao transporte de objetos de entrega.
     *
     * @param objetos              Lista de objetos de entrega.
     * @param quantidadeTotal      Quantidade total de volumes.
     * @param estadoDestinatario   Estado de destino dos objetos.
     */
    public static void exibirTotais(List<ObjetoEntrega> objetos, int quantidadeTotal, String estadoDestinatario) {
        double cubagemTotal = 0;
        double pesoTotal = 0;

        // Calcula a cubagem total e o peso total dos objetos
        for (ObjetoEntrega objeto : objetos) {
            cubagemTotal += objeto.cubagem();
            pesoTotal += objeto.pesoTotal();
        }

        // Calcula o número de carretas necessário, custo da cubagem e custo da distância
        int numeroCarretas = (int) Math.ceil(cubagemTotal / 90.0);
        double custoCubagem = cubagemTotal * 10;

        // Obtém a distância até o estado destinatário
        int distancia = Distancias.getDistancia(estadoDestinatario);
        double custoDistancia = distancia * 2;

        // Calcula o custo total do frete
        double custoTotalFrete = custoCubagem + custoDistancia;

        // Exibe os totais calculados
        System.out.println("\nTotais:");
        System.out.println("Quantidade Total de Volumes: " + quantidadeTotal);
        System.out.println("Cubagem Total: " + cubagemTotal + " m³");
        System.out.println("Peso Total: " + pesoTotal + " kg");
        System.out.println("Número de Carretas: " + numeroCarretas);
        System.out.println("Custo da Cubagem: R$ " + custoCubagem);
        System.out.println("Distância até o destino: " + distancia + " km");
        System.out.println("Custo por Distância: R$ " + custoDistancia);
        System.out.println("Custo Total do Frete: R$ " + custoTotalFrete);
    }
}
