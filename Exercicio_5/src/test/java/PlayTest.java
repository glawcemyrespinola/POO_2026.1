import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

public class PlayTest {

    @Test
    public void testCadastraEPesquisa() {
        SistemaJogos sistema = new Play();
        boolean cadastrou = sistema.cadastraJogo("The Witcher 3", "RPG", 99.90);
        assertTrue(cadastrou);

        Collection<Jogo> encontrados = sistema.pesquisaPorPreco(100.00);
        assertFalse(encontrados.isEmpty());
    }

    @Test
    public void testRemoveJogo() {
        SistemaJogos sistema = new Play();
        sistema.cadastraJogo("FIFA 23", "Esportes", 59.90);

        assertDoesNotThrow(() -> {
            boolean removido = sistema.removeJogo("FIFA 23");
            assertTrue(removido);
        });

        assertThrows(JogoInexistenteException.class, () -> {
            sistema.removeJogo("Jogo Inexistente");
        });
    }

    @Test
    public void testPersistencia() {
        SistemaJogos sistema = new Play();
        sistema.cadastraJogo("Minecraft", "Sandbox", 49.90);

        assertDoesNotThrow(() -> {
            sistema.salvarDados();
            sistema.recuperarDados();
        });
    }
}
