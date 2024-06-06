import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por consultar informações de veículos e motoristas a partir de um arquivo.
 */
public class ConsultarVeiculoMotorista {

    /**
     * Consulta um veículo pelo CPF do motorista.
     *
     * @param cpf o CPF do motorista a ser consultado
     */
    public static void consultarPorCpf(String cpf) {
        List<Veiculo> listaDeVeiculos = lerVeiculosDoArquivo("cadastro_veiculos.txt");
        // Percorre a lista de veículos para encontrar o veículo com o CPF fornecido
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.cpf().equals(cpf)) {
                // Se o veículo for encontrado, exibe suas informações
                exibirInformacoesVeiculo(veiculo);
                return; // Encerra o método após encontrar o veículo
            }
        }
        // Se o veículo não for encontrado, exibe uma mensagem informando isso
        System.out.println("CPF " + cpf + " não encontrado.");
        MenuRetorno.oferecerOpcoesVeiculo();
    }

    /**
     * Exibe as informações de um veículo.
     *
     * @param veiculo o veículo cujas informações serão exibidas
     */
    private static void exibirInformacoesVeiculo(Veiculo veiculo) {
        System.out.println("Informações do Veiculo:");
        System.out.println("Nome do Motorista: " + veiculo.nomeMotorista());
        System.out.println("CNH: " + veiculo.cnh());
        System.out.println("CPF: " + veiculo.cpf());
        System.out.println("RG: " + veiculo.rg());
        System.out.println("Placa: " + veiculo.placa());
        System.out.println("Rodizio: " + veiculo.rodizio());
        System.out.println("Marca: " + veiculo.marca());
        System.out.println("Modelo: " + veiculo.modelo());
        System.out.println("Ano: " + veiculo.ano());
        System.out.println("Comprimento: " + veiculo.comprimento());
        System.out.println("Largura: " + veiculo.largura());
        System.out.println("Altura: " + veiculo.altura());
        System.out.println("Cubagem: " + veiculo.cubagem());
    }

    /**
     * Lê os veículos a partir de um arquivo.
     *
     * @param arquivo o nome do arquivo que contém os dados dos veículos
     * @return a lista de veículos lida do arquivo
     */
    private static List<Veiculo> lerVeiculosDoArquivo(String arquivo) {
        List<Veiculo> veiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome do Motorista: ")) {
                    String nome = linha.split(": ")[1];
                    String cnh = br.readLine().split(": ")[1];
                    String cpf = br.readLine().split(": ")[1];
                    String rg = br.readLine().split(": ")[1];
                    String placa = br.readLine().split(": ")[1];
                    String rodizio = br.readLine().split(": ")[1];
                    String marca = br.readLine().split(": ")[1];
                    String modelo = br.readLine().split(": ")[1];
                    int ano = Integer.parseInt(br.readLine().split(": ")[1]);
                    double comprimento = Double.parseDouble(br.readLine().split(": ")[1]);
                    double largura = Double.parseDouble(br.readLine().split(": ")[1]);
                    double altura = Double.parseDouble(br.readLine().split(": ")[1]);
                    double cubagem = Double.parseDouble(br.readLine().split(": ")[1]);
                    veiculos.add(new Veiculo(nome, cnh, cpf, rg, placa, rodizio, marca, modelo, ano, comprimento, largura, altura, cubagem));

                    br.readLine(); // Lê a linha em branco após os dados do veículo
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return veiculos;
    }
}
