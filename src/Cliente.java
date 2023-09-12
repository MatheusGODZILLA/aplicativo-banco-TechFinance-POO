public class Cliente {
    String nome;
    String CPF;
    String dataNascimento;
    double saldo;
    String email;

    public Cliente(String nome, String CPF, String dataNascimento, double saldo, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.email = email;
    }
}