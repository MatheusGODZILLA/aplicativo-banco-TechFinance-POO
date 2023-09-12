// Importando estruturas para manipular listas e ler entradas
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para leitura de entrada

        // Cadastro inicial do cliente
        System.out.println("//-- Cadastro inicial --//");
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String CPF = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpar a linha em branco
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Cria um cliente com informações iniciais e uma conta bancária
        Cliente cliente = new Cliente(nome, CPF, dataNascimento, saldoInicial, email);
        Conta conta1 = new Conta(saldoInicial, 12345, cliente);

        System.out.println("");
        System.out.println("//-- Aplicativo de Conta Bancária --//");

        menu(conta1, scanner);

        scanner.close();
    }
}