package BancaoSA;
import java.util.Scanner;

public class VerificadorNumeroConta 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite o número da conta bancária:");
            String numeroConta = scanner.nextLine();

            // Chama o método que verifica se o número da conta é válido
            verificarNumeroConta(numeroConta);
            
            // Caso nenhuma exceção seja lançada, imprime a mensagem de sucesso.
            System.out.println("Número de conta válido.");
        } catch (IllegalArgumentException e) {
            // Informa que o número de conta é inválido e exibe a mensagem de erro
            System.out.println("Erro: " + e.getMessage());
        } finally {
            // Fecha o scanner para evitar vazamentos de recursos
            scanner.close();
        }
    }

    private static void verificarNumeroConta(String numeroConta) {
        if (numeroConta.length() != 8) {
            // Lança uma IllegalArgumentException com a mensagem apropriada
            throw new IllegalArgumentException("Número de conta inválido. Digite exatamente 8 dígitos.");
        }
    }
}

