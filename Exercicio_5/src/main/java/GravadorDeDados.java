import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    private static final String ARQUIVO_JOGOS = "jogos.dat";

    public void salvarJogos(Map<String, Jogo> jogos) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_JOGOS))) {
            oos.writeObject(jogos);
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Jogo> recuperarJogos() throws IOException {
        File file = new File(ARQUIVO_JOGOS);
        if (!file.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_JOGOS))) {
            return (Map<String, Jogo>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Classe não encontrada ao recuperar os dados.", e);
        }
    }
}