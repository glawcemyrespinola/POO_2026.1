import java.util.ArrayList;
import java.util.List;

public class GerenciadorJogadores {

    // Armazena a lista de jogadores
    private List<Jogador_de_Futebol> listaJogadores;

    // Construtor que inicializa a lista vazia
    public GerenciadorJogadores() {
        this.listaJogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador_de_Futebol jogador) throws Exception {
        if (listaJogadores.contains(jogador)) {
            throw new Exception(" O jogador " + jogador.getNome() + " já está cadastrado!");
        }
        listaJogadores.add(jogador);
        System.out.println(" O Jogador " + jogador.getNome() + " foi adicionado!");
    }

    public List<Jogador_de_Futebol> getListaJogadores() {
        return listaJogadores;
    }
}
