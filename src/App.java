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

    // Menu de Funcionamento da aplicação
    public static void menu(Conta conta, Scanner scanner) {
        System.out.println("1. Informações do Cliente e da Conta");
        System.out.println("2. Depósito");
        System.out.println("3. Saque");
        System.out.println("4. Transferência");
        System.out.println("5. Histórico de transações");
        System.out.println("6. Sair");

        System.out.print("\nSelecione uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Informações do Cliente:");
                System.out.println("Nome: " + conta.cliente.nome);
                System.out.println("CPF: " + conta.cliente.CPF);
                System.out.println("Data de Nascimento: " + conta.cliente.dataNascimento);
                System.out.println("Email: " + conta.cliente.email);

                System.out.println("\nInformações da Conta:");
                conta.mostrarSaldo();
                menu(conta, scanner);
                break;

            case 2:
                System.out.print("\nInforme o valor para depósito: ");
                double valorDeposito = scanner.nextDouble();
                conta.deposito(valorDeposito);
                menu(conta, scanner);
                break;

            case 3:
                System.out.print("\nInforme o valor para saque: ");
                double valorSaque = scanner.nextDouble();
                conta.saque(valorSaque);
                menu(conta, scanner);
                break;

            case 4:
                System.out.print("Número da Conta de Destino: ");
                int numeroContaDestino = scanner.nextInt();
                Conta contaDestino = new Conta(0, numeroContaDestino, new Cliente("Pedro Henrique", "123.456.789-00", "15/03/1990", 0, "ointankavel@mail.com"));
                if (contaDestino != null) {
                    System.out.print("\nInforme o valor para transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    conta.transferencia(contaDestino, valorTransferencia);
                    menu(conta, scanner);
                }
                break;

            case 5:
                ArrayList<String> historico = (ArrayList<String>) conta.getHistoricoTransacoes();
                if (historico.isEmpty()) {
                    System.out.println("\nNenhuma transação recente encontrada.\n");
                } else {
                    System.out.println("\nHistórico de Transações:");
                    for (String transacao : historico) {
                        System.out.println(transacao);
                    }
                    System.out.println();
                }
                menu(conta, scanner);
                break;

            case 6:
                System.out.println("\nValeu!");
                scanner.close();
                break;

            default:
                System.out.println("\nOpção inválida. Tente novamente.");
                menu(conta, scanner);
        }
    }
}