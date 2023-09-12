// Importando estruturas para criar e manipular listas
import java.util.ArrayList;
import java.util.List;

public class Conta {
    double saldo;
    int numeroConta;
    Cliente cliente;

    private List<String> historicoTransacoes; // Lista para armazenar o histórico de transações

    // Construtor da classe
    public Conta(double saldo, int numeroConta, Cliente cliente) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.historicoTransacoes = new ArrayList<>();
    }

    public Conta(double saldoInicial, String numeroConta2, Cliente cliente2) {
    }

    // Método para realizar saques
    public void saque(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para o saque.");
        } else {
            saldo -= valor;
            String descricaoTransacao = "Saque: R$" + valor;
            registrarTransacao(descricaoTransacao);
            System.out.println("Saque de " + valor + " realizado com sucesso.");
            System.out.println("\n");
        }
    }

    // Método para realizar depósitos
    public void deposito(double valor) {
        saldo += valor;
        String descricaoTransacao = "Depósito: R$" + valor;
        registrarTransacao(descricaoTransacao);
        System.out.println("Depósito de " + valor + " realizado com sucesso.");
        System.out.println("\n");
    }

    // Método para realizar transferências
    public void transferencia(Conta destino, double transferencia) {
        if (transferencia > saldo) {
            System.out.println("Saldo insuficiente para a transferência.");
            System.out.println("\n");
        } else {
            saldo -= transferencia;
            destino.deposito(transferencia);
    
            // Registra a transação no histórico
            String descricaoTransacao = "Transferência para a conta " + destino.numeroConta + ": R$" + transferencia;
            registrarTransacao(descricaoTransacao);
    
            System.out.println("Transferência de " + transferencia + " realizada com sucesso para o destinatário.");
            System.out.println("\n");
        }
    }
}