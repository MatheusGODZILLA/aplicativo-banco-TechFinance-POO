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
}
