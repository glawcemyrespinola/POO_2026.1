import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Play implements SistemaJogos {
    private Map<String, Jogo> jogos;
    private GravadorDeDados gravador;

    public Play() {
        this.gravador = new GravadorDeDados();
        this.jogos = new HashMap<>();
    }

    @Override
    public boolean cadastraJogo(String nome, String categoria, double preco) {
        if (jogos.containsKey(nome)) {
            return false;
        }
        Jogo jogo = new Jogo(nome, categoria, preco);
        jogos.put(nome, jogo);
        return true;
    }

    @Override
    public Collection<Jogo> pesquisaPorPreco(double precoMaximo) {
        return jogos.values().stream()
                .filter(j -> j.getPreco() <= precoMaximo)
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeJogo(String nome) throws JogoInexistenteException {
        if (!jogos.containsKey(nome)) {
            throw new JogoInexistenteException("O jogo '" + nome + "' não foi encontrado no sistema.");
        }
        jogos.remove(nome);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvarJogos(jogos);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.jogos = gravador.recuperarJogos();
    }
}
