import java.io.IOException;
import java.util.Collection;

public interface SistemaJogos {

    boolean cadastraJogo(String nome, String categoria, double preco);

    Collection<Jogo> pesquisaPorPreco(double precoMaximo);

     boolean removeJogo(String nome) throws JogoInexistenteException;

     void salvarDados() throws IOException;

     void recuperarDados() throws IOException;
}
