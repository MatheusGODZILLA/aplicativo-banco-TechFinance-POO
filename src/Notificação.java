// Importando estruturas para criar e manipular listas
import java.util.ArrayList;
import java.util.List;

public class Notificação {
    private List<String> mensagens;

    public Notificação() {
        this.mensagens = new ArrayList<>();
    }

    // Método para adicionar uma mensagem de notificação
    public void adicionarMensagem(String mensagem) {
        mensagens.add(mensagem);
    }

    // Método para obter todas as mensagens de notificação
    public List<String> getMensagens() {
        return mensagens;
    }

    // Método para limpar todas as mensagens de notificação
    public void limparMensagens() {
        mensagens.clear();
    }
}