import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por consultar informações de entregas a partir de um arquivo.
 */
public class ConsultarEntrega {

    /**
     * Consulta uma entrega pelo ID do pedido.
     *
     * @param idPedido o ID do pedido a ser consultado
     * @return a entrega encontrada ou {@code null} se não encontrada
     */
    public static Entrega consultarPorIdPedido(String idPedido) {
        List<Entrega> listaDeEntregas = lerEntregasDoArquivo("cadastro_entregas.txt");
        for (Entrega entrega : listaDeEntregas) {
            if (entrega.id().equals(idPedido)) {
                exibirInformacoesEntrega(entrega);
                return entrega;
            }
        }
        System.out.println("Entrega com ID do pedido " + idPedido + " não encontrada.");
        MenuRetorno.oferecerOpcoesEntrega();
        return null;
    }

    /**
     * Exibe as informações de uma entrega.
     *
     * @param entrega a entrega cujas informações serão exibidas
     */
    private static void exibirInformacoesEntrega(Entrega entrega) {
        System.out.println("==== Folha de Pedido ====");
        System.out.println("ID do Pedido: " + entrega.id());
        System.out.println("Data e hora: " + entrega.dataHoraFormatada());
        System.out.println("Remetente:");
        System.out.println("Nome do remetente: " + entrega.remetente().nomeCliente());
        System.out.println("CNPJ do remetente: " + entrega.remetente().cnpjCliente());
        System.out.println("Rua do remetente: " + entrega.remetente().ruaCliente());
        System.out.println("Número do remetente: " + entrega.remetente().numeroCasa());
        System.out.println("Bairro do remetente: " + entrega.remetente().bairroCliente());
        System.out.println("Cidade do remetente: " + entrega.remetente().cidadeCliente());
        System.out.println("Estado do remetente: " + entrega.remetente().estadoCliente());
        System.out.println("CEP do remetente: " + entrega.remetente().cepCliente());
        System.out.println("Destinatário:");
        System.out.println("Nome do destinatário: " + entrega.nomeDestinatario());
        System.out.println("CNPJ do destinatário: " + entrega.cnpjDestinatario());
        System.out.println("Rua do destinatário: " + entrega.ruaDestinatario());
        System.out.println("Número do destinatário: " + entrega.numeroDestinatario());
        System.out.println("Bairro do destinatário: " + entrega.bairroDestinatario());
        System.out.println("Cidade do destinatário: " + entrega.cidadeDestinatario());
        System.out.println("Estado do destinatário: " + entrega.estadoDestinatario());
        System.out.println("CEP do destinatário: " + entrega.cepDestinatario());
        System.out.println("Objetos:");
        for (ObjetoEntrega objeto : entrega.objetos()) {
            System.out.print(objeto);
        }
        System.out.println("FimObjetos");
        System.out.println("Totais:");
        System.out.println("Quantidade Total de Volumes: " + entrega.quantidadeTotal());
        System.out.println("Cubagem Total: " + entrega.cubagemTotal() + " m³");
        System.out.println("Peso Total: " + entrega.pesoTotal() + " kg");
        System.out.println("Número de Carretas: " + entrega.numeroCarretas());
        System.out.println("Custo da Cubagem: R$ " + entrega.custoCubagem());
        System.out.println("Distância até o destino: " + entrega.distanciaDestino() + " km");
        System.out.println("Custo por Distância: R$ " + entrega.custoPorDistancia());
        System.out.println("Custo Total do Frete: R$ " + entrega.custoTotalFrete());
    }

    /**
     * Lê as entregas a partir de um arquivo.
     *
     * @param arquivo o nome do arquivo que contém os dados das entregas
     * @return a lista de entregas lida do arquivo
     */
    private static List<Entrega> lerEntregasDoArquivo(String arquivo) {
        List<Entrega> entregas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("==== Folha de Pedido ====")) {
                    String id = null;
                    String dataHoraFormatada = null;
                    Cliente remetente = null;
                    String nomeRemetente = null;
                    String cnpjRemetente = null;
                    String ruaRemetente = null;
                    int numeroRemetente = 0;
                    String bairroRemetente = null;
                    String cidadeRemetente = null;
                    String estadoRemetente = null;
                    String cepRemetente = null;
                    String nomeDestinatario = null;
                    String cnpjDestinatario = null;
                    String ruaDestinatario = null;
                    int numeroDestinatario = 0;
                    String bairroDestinatario = null;
                    String cidadeDestinatario = null;
                    String estadoDestinatario = null;
                    String cepDestinatario = null;
                    List<ObjetoEntrega> objetos = new ArrayList<>();
                    int quantidadeTotal = 0;
                    double cubagemTotal = 0;
                    double pesoTotal = 0;
                    int numeroCarretas = 0;
                    double custoCubagem = 0.0;
                    double distanciaDestino = 0.0;
                    double custoPorDistancia = 0.0;
                    double custoTotalFrete = 0.0;

                    while ((linha = br.readLine()) != null && !linha.startsWith("==== Folha de Pedido ====")) {
                        if (linha.equals("==========================")) {
                            break; // Sai do loop quando encontrar o marcador de fim de objetos
                        }
                        if (linha.trim().isEmpty()) {
                            continue;
                        }

                        String[] partes = linha.split(": ");
                        if (partes.length < 2) {
                            continue;
                        }
                        String chave = partes[0].trim();
                        String valor = partes[1].trim();
                        switch (chave) {
                            case "ID do Pedido":
                                id = valor;
                                break;
                            case "Data e hora":
                                dataHoraFormatada = valor;
                                break;
                            case "Nome do remetente":
                                nomeRemetente = valor;
                                break;
                            case "CNPJ do remetente":
                                cnpjRemetente = valor;
                                break;
                            case "Rua do remetente":
                                ruaRemetente = valor;
                                break;
                            case "Número do remetente":
                                if (valor.matches("\\d+")) { // Verifica se o valor é composto apenas por dígitos
                                    numeroRemetente = Integer.parseInt(valor);
                                } else {
                                    // Se o valor não for um número válido, imprima uma mensagem de erro e continue
                                    System.out.println("Número do remetente inválido: " + valor);
                                }
                                break;
                            case "Bairro do remetente":
                                bairroRemetente = valor;
                                break;
                            case "Cidade do remetente":
                                cidadeRemetente = valor;
                                break;
                            case "Estado do remetente":
                                estadoRemetente = valor;
                                break;
                            case "CEP do remetente":
                                cepRemetente = valor;
                                break;
                            case "Nome do destinatário":
                                nomeDestinatario = valor;
                                break;
                            case "CNPJ do destinatário":
                                cnpjDestinatario = valor;
                                break;
                            case "Rua do destinatário":
                                ruaDestinatario = valor;
                                break;
                            case "Número do destinatário":
                                if (valor.matches("\\d+")) { // Verifica se o valor é composto apenas por dígitos
                                    numeroDestinatario = Integer.parseInt(valor);
                                } else {
                                    // Se o valor não for um número válido, imprima uma mensagem de erro e continue
                                    System.out.println("Número do destinatário inválido: " + valor);
                                }
                                break;
                            case "Bairro do destinatário":
                                bairroDestinatario = valor;
                                break;
                            case "Cidade do destinatário":
                                cidadeDestinatario = valor;
                                break;
                            case "Estado do destinatário":
                                estadoDestinatario = valor;
                                break;
                            case "CEP do destinatário":
                                cepDestinatario = valor;
                                break;
                            case "Objetos:":
                                while ((linha = br.readLine()) != null && !linha.startsWith("Totais:")) {
                                    if (linha.trim().isEmpty()) {
                                        continue;
                                    }
                                    partes = linha.split(", ");
                                    int quantidade = Integer.parseInt(partes[0].split(": ")[1]);
                                    double altura = Double.parseDouble(partes[1].split(": ")[1].replace(" cm", ""));
                                    double largura = Double.parseDouble(partes[2].split(": ")[1].replace(" cm", ""));
                                    double comprimento = Double.parseDouble(partes[3].split(": ")[1].replace(" cm", ""));
                                    double peso = Double.parseDouble(partes[4].split(": ")[1].replace(" kg", ""));
                                    objetos.add(new ObjetoEntrega(quantidade, altura, largura, comprimento, peso));
                                    quantidadeTotal += quantidade;
                                    cubagemTotal += altura * largura * comprimento * quantidade;
                                    pesoTotal += peso * quantidade;
                                }
                                break;
                            case "Número de Carretas":
                                numeroCarretas = Integer.parseInt(valor);
                                break;
                            case "Custo da Cubagem":
                                custoCubagem = Double.parseDouble(valor.replace("R$ ", ""));
                                break;
                            case "Distância até o destino":
                                distanciaDestino = Double.parseDouble(valor.replace(" km", ""));
                                break;
                            case "Custo por Distância":
                                custoPorDistancia = Double.parseDouble(valor.replace("R$ ", ""));
                                break;
                            case "Custo Total do Frete":
                                custoTotalFrete = Double.parseDouble(valor.replace("R$ ", ""));
                                break;
                        }
                    }
                    remetente = new Cliente(nomeRemetente, cnpjRemetente, ruaRemetente, numeroRemetente, bairroRemetente, cidadeRemetente, estadoRemetente, cepRemetente);
                    entregas.add(new Entrega(id, dataHoraFormatada, remetente, nomeRemetente, cnpjRemetente, ruaRemetente, numeroRemetente,
                            bairroRemetente, cidadeRemetente, estadoRemetente, cepRemetente, nomeDestinatario, cnpjDestinatario, ruaDestinatario,
                            numeroDestinatario, bairroDestinatario, cidadeDestinatario, estadoDestinatario, cepDestinatario,
                            objetos, quantidadeTotal, cubagemTotal, pesoTotal, numeroCarretas, custoCubagem, distanciaDestino,
                            custoPorDistancia, custoTotalFrete));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entregas: " + e.getMessage());
        }
        return entregas;
    }
}
