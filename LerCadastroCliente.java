import java.util.ArrayList;
import java.util.List;

import tratativas.LerCep;
import tratativas.LerCnpj;
import tratativas.LerDados;
import tratativas.LerNome;

/**
 * Esta classe é responsável por capturar e salvar os detalhes do cadastro de um cliente.
 */
public class LerCadastroCliente {

    /**
     * Realiza o cadastro de um cliente, capturando suas informações e salvando no arquivo de cadastro de clientes.
     */
    public static void cadastroCliente() {
        // Captura o nome do cliente
        System.out.print("Digite a Razão Social: ");
        var nomeCliente = LerNome.validaNome();

        // Captura o CNPJ do cliente
        System.out.print("Digite o Nº do CNPJ: ");
        var cnpjCliente = LerCnpj.validaCnpj();

        // Verifica se o CNPJ já existe no arquivo de cadastro de clientes
        if (SalvarArquivo.verificaDuplicidade(cnpjCliente, "cadastro_clientes.txt")) {
            System.out.println("CNPJ já existe, os detalhes do cliente não foram salvos.");
            return; // Retorna sem salvar os detalhes do cliente
        }

        // Captura outras informações do cliente
        System.out.print("Digite o nome da rua: ");
        var ruaCliente = LerDados.lerTextoMesclado();

        System.out.print("Digite o número da casa: ");
        var numeroCasa = LerDados.lerInt("Favor digitar um número inteiro: ");

        System.out.print("Digite o nome do bairro: ");
        var bairroCliente = LerDados.lerTextoMesclado();

        System.out.print("Digite o nome da Cidade: ");
        var cidadeCliente = LerDados.lerTextoMesclado();

        System.out.print("Digite o nome do estado: ");
        var estadoCliente = LerDados.lerTextoMesclado();

        System.out.print("Digite o nome do CEP: ");
        var cepCliente = LerCep.validaCep();

        // Cria um objeto Cliente com as informações capturadas
        Cliente cliente = new Cliente(nomeCliente, cnpjCliente, ruaCliente, numeroCasa, bairroCliente, cidadeCliente,
                estadoCliente, cepCliente);
        
        // Monta uma string com os detalhes do cliente
        String detalhesCliente = "Nome do cliente: " + cliente.nomeCliente() + "\n" +
                "CNPJ: " + cliente.cnpjCliente() + "\n" +
                "Rua: " + cliente.ruaCliente() + "\n" +
                "Nº: " + cliente.numeroCasa() + "\n" +
                "Bairro: " + cliente.bairroCliente() + "\n" +
                "Cidade: " + cliente.cidadeCliente() + "\n" +
                "Estado: " + cliente.estadoCliente() + "\n" +
                "CEP: " + cliente.cepCliente() + "\n";

        try {
            // Lê as linhas existentes no arquivo de cadastro de clientes
            List<String> linhas = SalvarArquivo.lerLinhas("cadastro_clientes.txt");
            List<String> linhasMutaveis = new ArrayList<>(linhas); // Cria uma lista mutável
            linhasMutaveis.add(detalhesCliente); // Adiciona os detalhes do cliente na lista mutável
            // Escreve as linhas atualizadas no arquivo de cadastro de clientes
            SalvarArquivo.escreverLinhas(linhasMutaveis, "cadastro_clientes.txt");
            System.out.println("Detalhes do cliente salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar os detalhes do cliente: " + e.getMessage());
            e.printStackTrace(); // Imprime a stack trace completa da exceção
        }
    }
}
