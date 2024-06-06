import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

/**
 * A classe SalvarArquivo oferece métodos para manipulação de arquivos.
 */
public class SalvarArquivo {
    
    /**
     * Verifica se um arquivo existe.
     * @param arquivo O caminho do arquivo a ser verificado
     * @return true se o arquivo existe, false caso contrário
     */
    public static boolean arquivoExiste(String arquivo) {
        return Files.exists(Path.of(arquivo));
    }
    
    /**
     * Lê as linhas de um arquivo.
     * @param arquivo O caminho do arquivo a ser lido
     * @return Uma lista contendo as linhas do arquivo
     */
    public static List<String> lerLinhas(String arquivo) {
        System.out.flush();
        var p = Path.of(arquivo);
        System.out.println("Salvando em: " + p.toString());
        try {
            return Files.readAllLines(p);
        } catch (NoSuchFileException x) {
            return List.of();
        } catch (IOException x) {
            x.printStackTrace(System.out);
            throw new RuntimeException(x);
        }
    }
    
    /**
     * Escreve linhas em um arquivo.
     * @param linhas As linhas a serem escritas no arquivo
     * @param arquivo O caminho do arquivo a ser escrito
     */
    public static void escreverLinhas(List<String> linhas, String arquivo) {
        try {
            Files.write(Path.of(arquivo), linhas);
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    
    /**
     * Lê um número de um arquivo.
     * @param arquivo O caminho do arquivo a ser lido
     * @return O número lido do arquivo
     */
    public static int lerNumero(String arquivo) {
        try {
            return Integer.parseInt(Files.readString(Path.of(arquivo)).trim());
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    
    /**
     * Lê um número de um arquivo, retornando um valor padrão se o arquivo não for encontrado.
     * @param arquivo O caminho do arquivo a ser lido
     * @param naoAchou O valor padrão a ser retornado se o arquivo não for encontrado
     * @return O número lido do arquivo ou o valor padrão
     */
    public static int lerNumero(String arquivo, int naoAchou) {
        try {
            return Integer.parseInt(Files.readString(Path.of(arquivo)).trim());
        } catch (NoSuchFileException x) {
            return naoAchou;
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    
    /**
     * Escreve um número em um arquivo.
     * @param valor O valor a ser escrito no arquivo
     * @param arquivo O caminho do arquivo a ser escrito
     */
    public static void escreverNumero(int valor, String arquivo) {
        try {
            Files.write(Path.of(arquivo), List.of("" + valor));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    
    /**
     * Verifica se um dado específico já existe no arquivo.
     * @param dado O dado a ser verificado
     * @param arquivo O caminho do arquivo a ser verificado
     * @return true se o dado já existe no arquivo, false caso contrário
     */
    public static boolean verificaDuplicidade(String dado, String arquivo) {
        List<String> linhas = lerLinhas(arquivo);
        for (String linha : linhas) {
            if (linha.contains(dado)) {
                return true;
            }
        }
        return false;
    }
}
