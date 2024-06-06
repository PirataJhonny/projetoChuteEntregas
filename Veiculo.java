/**
 * A classe Veiculo representa um veículo, com informações sobre o motorista, características do veículo e cubagem.
 */
public record Veiculo (
    String nomeMotorista, // Nome completo do motorista
    String cnh, // Número da CNH do motorista
    String cpf, // Número do CPF do motorista
    String rg, // Número do RG do motorista
    String placa, // Placa do veículo
    String rodizio, // Informação sobre o rodízio do veículo
    String marca, // Marca do veículo
    String modelo, // Modelo do veículo
    int ano, // Ano do veículo
    double comprimento, // Comprimento do veículo em metros
    double largura, // Largura do veículo em metros
    double altura, // Altura do veículo em metros
    double cubagem // Cubagem do veículo em metros cúbicos
) {

    /**
     * Calcula a cubagem total do veículo.
     * @return A cubagem total do veículo em metros cúbicos
     */
    public double cubagem() {
        return comprimento * largura * altura;
    }

}
