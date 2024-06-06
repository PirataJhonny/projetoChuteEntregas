import java.util.ArrayList;
import java.util.List;

import tratativas.LerCnh;
import tratativas.LerCpf;
import tratativas.LerDados;
import tratativas.LerPlaca;
import tratativas.LerRg;

/**
 * Classe responsável pelo cadastro de veículos.
 */
public class LerCadastroVeiculo {

    /**
     * Método para realizar o cadastro de um veículo.
     */
    public static void cadastroVeiculo() {

        // Solicitar informações do motorista
        System.out.print("Digite o nome completo: ");
        var nomeMotorista = LerDados.lerTexto();

        System.out.print("Digite o Nº da CNH: ");
        var cnh = LerCnh.validaCnh();

        System.out.print("Digite o Nº do CPF: ");
        var cpf = LerCpf.validaCpf();

        // Verificar se o CPF já está cadastrado
        if (SalvarArquivo.verificaDuplicidade(cpf, "cadastro_veiculos.txt")) {
            System.out.println("CPF já existe, os detalhes do veículo não foram salvos.");
            return; // Retorna sem salvar os detalhes do veículo
        }

        System.out.print("Digite o Nº do RG: ");
        var rg = LerRg.validaRg();

        System.out.print("Digite a placa: ");
        var placa = LerPlaca.validaPlaca();

        // Verificar se a placa já está cadastrada
        if (SalvarArquivo.verificaDuplicidade(placa, "cadastro_veiculos.txt")) {
            System.out.println("Placa já existe, os detalhes do veículo não foram salvos.");
            return; // Retorna sem salvar os detalhes do veículo
        }

        // Determinar o dia do rodízio da placa
        var rodizio = LerPlaca.diaRodizio(placa);
        if (rodizio.isEmpty()) {
            System.out.println("Placa inválida. Os detalhes do veículo não foram salvos.");
            return; // Retorna sem salvar os detalhes do veículo
        }
        System.out.println("Dia do rodízio: " + rodizio);

        // Solicitar informações sobre o veículo
        System.out.print("Digite a marca: ");
        var marca = LerDados.lerTextoMesclado();

        System.out.print("Digite o modelo: ");
        var modelo = LerDados.lerTextoMesclado();

        System.out.print("Digite o ano: ");
        var ano = LerDados.lerInt("Favor digitar um número inteiro: ");

        System.out.print("Digite o comprimento:");
        var comprimento = LerDados.lerDouble("Favor digitar um valor decimal:");

        System.out.print("Digite a largura: ");
        var largura = LerDados.lerDouble("Favor digitar um valor decimal:");

        System.out.print("Digite a altura: ");
        var altura = LerDados.lerDouble("Favor digitar um valor decimal:");

        // Calcular a cubagem do veículo
        double cubagem = comprimento * largura * altura;

        System.out.println("A metragem cúbica do Baú é:" + cubagem + " m³");

        // Criar objeto Veiculo com as informações coletadas
        Veiculo veiculo = new Veiculo(nomeMotorista, cnh, cpf, rg, placa, rodizio, marca, modelo, ano, comprimento, largura, altura, cubagem);
        
        // Formatar detalhes do veículo para registro
        String detalhesVeiculo = "Nome do Motorista: " + veiculo.nomeMotorista() + "\n" +
                "CNH: " + veiculo.cnh() + "\n" +
                "CPF: " + veiculo.cpf() + "\n" +
                "RG: " + veiculo.rg() + "\n" +
                "Placa: " + veiculo.placa() + "\n" +
                "Rodzio: " + veiculo.rodizio() + "\n" +
                "Marca: " + veiculo.marca() + "\n" +
                "Modelo: " + veiculo.modelo() + "\n" +
                "Ano: " + veiculo.ano() + "\n" +
                "Comprimento: " + veiculo.comprimento() + "\n" +
                "Largura: " + veiculo.largura() + "\n" +
                "Altura: " + veiculo.altura() + "\n" +
                "Cubagem: " + veiculo.cubagem() + "\n";

        // Tentar salvar os detalhes do veículo em um arquivo
        try {
            List<String> linhas = SalvarArquivo.lerLinhas("cadastro_veiculos.txt");
            List<String> linhasMutaveis = new ArrayList<>(linhas);
            linhasMutaveis.add(detalhesVeiculo);
            SalvarArquivo.escreverLinhas(linhasMutaveis, "cadastro_veiculos.txt");
            System.out.println("Detalhes do veículo salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar os detalhes do veículo: " + e.getMessage());
            e.printStackTrace(); // Imprime a stack trace completa da exceção
        }
    }
}
