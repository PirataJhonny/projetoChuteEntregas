/**
 * Representa um cliente com informações básicas de identificação e endereço.
 */
public record Cliente(

    /**
     * O nome do cliente.
     */
    String nomeCliente,

    /**
     * O CNPJ do cliente.
     */
    String cnpjCliente,

    /**
     * A rua onde o cliente reside.
     */
    String ruaCliente,

    /**
     * O número da casa do cliente.
     */
    int numeroCasa,

    /**
     * O bairro onde o cliente reside.
     */
    String bairroCliente,

    /**
     * A cidade onde o cliente reside.
     */
    String cidadeCliente,

    /**
     * O estado onde o cliente reside.
     */
    String estadoCliente,

    /**
     * O CEP (Código de Endereçamento Postal) do cliente.
     */
    String cepCliente

) {

}
