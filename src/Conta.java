// Importando estruturas para criar e manipular listas
import java.util.ArrayList;
import java.util.List;

public class Conta {
    double saldo;
    int numeroConta;
    Cliente cliente;

    private List<String> historicoTransacoes; // Lista para armazenar o histórico de transações
    private Notificação notificacoes; // Adicione uma instância de Notificacao

    // Construtor da classe
    public Conta(double saldo, int numeroConta, Cliente cliente) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.historicoTransacoes = new ArrayList<>();
        this.notificacoes = new Notificação();
    }

    public Conta(double saldoInicial, String numeroConta2, Cliente cliente2) {
    }

    // Método para realizar saques
    public void saque(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para o saque.");
            notificacoes.adicionarMensagem("Tentativa de saque de R$" + valor + " falhou devido a saldo insuficiente.");
        } else {
            saldo -= valor;
            String descricaoTransacao = "Saque: R$" + valor;
            registrarTransacao(descricaoTransacao);
            notificacoes.adicionarMensagem("Saque de R$" + valor + " realizado com sucesso.");
            System.out.println("Saque de " + valor + " realizado com sucesso.");
            System.out.println("\n");
        }
    }
    
    // Método para realizar depósitos
    public void deposito(double valor) {
        saldo += valor;
        String descricaoTransacao = "Depósito: R$" + valor;
        registrarTransacao(descricaoTransacao);
        notificacoes.adicionarMensagem("Depósito de R$" + valor + " realizado com sucesso.");
        System.out.println("Depósito de " + valor + " realizado com sucesso.");
        System.out.println("\n");
    }    

    // Método para realizar transferências
    public void transferencia(Conta destino, double transferencia) {
        if (transferencia > saldo) {
            System.out.println("Saldo insuficiente para a transferência.");
            notificacoes.adicionarMensagem("Tentativa de transferência de R$" + transferencia + " falhou devido a saldo insuficiente.");
            System.out.println("\n");
        } else {
            saldo -= transferencia;
            destino.deposito(transferencia);
    
            // Registra a transação no histórico
            String descricaoTransacao = "Transferência para a conta " + destino.numeroConta + ": R$" + transferencia;
            registrarTransacao(descricaoTransacao);
            notificacoes.adicionarMensagem("Transferência de R$" + transferencia + " realizada com sucesso para a conta " + destino.numeroConta + ".");
    
            System.out.println("Transferência de " + transferencia + " realizada com sucesso para o destinatário.");
            System.out.println("\n");
        }
    }    

    // Método para exibir o saldo da conta
    public void mostrarSaldo() {
        System.out.println("Número da Conta: " + numeroConta + "\nSaldo: R$" + saldo);
        System.out.println("\n");
    }

    // Método para registrar uma transação no histórico
    public void registrarTransacao(String transacao) {
        historicoTransacoes.add(transacao);
    }

    // Método para obter o histórico de transações
    public List<String> getHistoricoTransacoes() {
        return historicoTransacoes;
    }

    // Método para obter as mensagens de notificação
    public List<String> getNotificacoes() {
        return notificacoes.getMensagens();
    }

    // Método para limpar as mensagens de notificação
    public void limparNotificacoes() {
        notificacoes.limparMensagens();
    }
}