package br.ufpb.dcx.amigosecreto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SistemaAmigoMapTest {

    private SistemaAmigoMap sistema = new SistemaAmigoMap();

    @Test
    public void testPesquisaECadastraAmigo() {
        try {
            assertThrows(AmigoInexistenteException.class, () -> sistema.pesquisaAmigo("ayla@teste.com"));

            sistema.cadastraAmigo("Ayla", "ayla@teste.com");
            Amigo a = sistema.pesquisaAmigo("ayla@teste.com");
            assertEquals("Ayla", a.getNome());
            assertEquals("ayla@teste.com", a.getEmail());

        } catch (AmigoJaExisteException | AmigoInexistenteException e) {
            fail("Não deveria lançar exceção aqui");
        }
    }

    @Test
    public void testEnviarMensagemParaTodos() {
        sistema.enviarMensagemParaTodos("Oi pessoal", "ayla@dcx.ufpb.br", false);
        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
        assertEquals("Oi pessoal", sistema.pesquisaTodasAsMensagens().get(0).getTexto());
    }

    @Test
    public void testEnviarMensagemParaAlguem() {
        sistema.enviarMensagemParaAlguem("Oi Ayla", "rodrigo@dcx.ufpb.br", "ayla@dcx.ufpb.br", false);
        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
    }

    @Test
    public void testPesquisaMensagensAnonimas() {
        assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());
        sistema.enviarMensagemParaAlguem("Texto 1", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());
        sistema.enviarMensagemParaAlguem("Texto 2", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
        assertEquals(1, sistema.pesquisaMensagensAnonimas().size());
    }

    @Test
    public void testPesquisaTodasAsMensagens() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("Texto 1", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", false);
        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
    }

    @Test
    public void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        try {
            sistema.cadastraAmigo("Ayla", "ayla@dcx.ufpb.br");
            sistema.cadastraAmigo("Ana", "ana@dcx.ufpb.br");

            sistema.configuraAmigoSecretoDe("ayla@dcx.ufpb.br", "ana@dcx.ufpb.br");

            assertEquals("ana@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));

        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }

    @Test
    public void testSistemaAmigo() {
        try {
            sistema.cadastraAmigo("Ayla", "ayla@dcx.ufpb.br");
            assertThrows(AmigoNaoSorteadoException.class, () -> sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));
        } catch (AmigoJaExisteException e) {
            fail("Não deveria lançar exceção");
        }
    }
}
