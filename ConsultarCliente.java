import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por consultar informações de clientes a partir de um arquivo.
 */
public class ConsultarCliente {

    /**
     * Consulta um cliente pelo seu CNPJ.
     *
     * @param cnpj o CNPJ do cliente a ser consultado
     * @return o cliente encontrado ou {@code null} se não encontrado
     */
    public static Cliente consultarPorCnpj(String cnpj) {
        List<Cliente> listaDeClientes = lerClientesDoArquivo("cadastro_clientes.txt");
        // Percorre a lista de Clientes para encontrar o Cliente com o CNPJ fornecido
        for (Cliente cliente : listaDeClientes) {
            if (cliente.cnpjCliente().equals(cnpj)) {
                // Se o Cliente for encontrado, exibe suas informações
                exibirInformacoesCliente(cliente);
                return cliente; // Encerra o método após encontrar o Cliente
            }
        }
        // Se o Cliente não for encontrado, exibe uma mensagem informando isso
        System.out.println("Cliente com CNPJ " + cnpj + " não encontrado.");
        // Oferecer opções de caminho
        MenuRetorno.oferecerOpcoesCliente();
        return null;
    }

    /**
     * Exibe as informações de um cliente.
     *
     * @param cliente o cliente cujas informações serão exibidas
     */
    public static void exibirInformacoesCliente(Cliente cliente) {
        System.out.println("Informações do Cliente:");
        System.out.println("Razão Social: " + cliente.nomeCliente());
        System.out.println("CNPJ: " + cliente.cnpjCliente());
        System.out.println("Rua: " + cliente.ruaCliente());
        System.out.println("Nº: " + cliente.numeroCasa());
        System.out.println("Bairro: " + cliente.bairroCliente());
        System.out.println("Cidade: " + cliente.cidadeCliente());
        System.out.println("Estado: " + cliente.estadoCliente());
        System.out.println("CEP: " + cliente.cepCliente());
    }

    /**
     * Lê os clientes a partir de um arquivo.
     *
     * @param arquivo o nome do arquivo que contém os dados dos clientes
     * @return a lista de clientes lida do arquivo
     */
    private static List<Cliente> lerClientesDoArquivo(String arquivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome do cliente: ")) {
                    String nome = linha.split(": ")[1];
                    String cnpj = br.readLine().split(": ")[1];
                    String rua = br.readLine().split(": ")[1];
                    int numeroCasa = Integer.parseInt(br.readLine().split(": ")[1]);
                    String bairro = br.readLine().split(": ")[1];
                    String cidade = br.readLine().split(": ")[1];
                    String estado = br.readLine().split(": ")[1];
                    String cep = br.readLine().split(": ")[1];
                    clientes.add(new Cliente(nome, cnpj, rua, numeroCasa, bairro, cidade, estado, cep));
                    // Pular linha vazia entre registros
                    br.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return clientes;
    }
}
