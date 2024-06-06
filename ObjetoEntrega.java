/**
 * ObjetoEntrega representa um objeto a ser entregue, com suas dimensões e peso.
 */
public record ObjetoEntrega(
    int quantidade, // Quantidade de itens
    double altura, // Altura do objeto em centímetros
    double largura, // Largura do objeto em centímetros
    double comprimento, // Comprimento do objeto em centímetros
    double peso // Peso do objeto em quilogramas
) {
    
    /**
     * Calcula a cubagem total do conjunto de caixas.
     * @return A cubagem total em metros cúbicos
     */
    public double cubagem() {
        double cubagemCalculada = (altura / 100) * (largura / 100) * (comprimento / 100) * quantidade;
        double cubagemArredondada = Math.round(cubagemCalculada * 100.0) / 100.0;
        if (cubagemArredondada - Math.floor(cubagemArredondada) > 0.01) {
            cubagemArredondada = Math.ceil(cubagemCalculada * 100.0) / 100.0;
        }
        return cubagemArredondada;
    }
    
    /**
     * Calcula o peso cubado do conjunto de caixas.
     * @return O peso cubado em quilogramas
     */
    public double pesoCubado() {
        return cubagem() /** 0.0003*/ * 300;
    }

    /**
     * Calcula o peso total do conjunto de caixas.
     * @return O peso total em quilogramas
     */
    public double pesoTotal() {
        return peso * quantidade;
    }

    /**
     * Sobrescrita do método toString para representação textual do objeto.
     * @return Uma string representando o objeto entrega
     */
    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", " +
            "Altura: " + altura + " cm, " +
            "Largura: " + largura + " cm, " +
            "Comprimento: " + comprimento + " cm, " +
            "Peso: " + peso + " kg, " +
            "Cubagem: " + cubagem() + " cm³, " +
            "Peso Total: " + pesoTotal() + " kg, " +
            "Peso Cubado: " + pesoCubado() + " kg";
    }
}
