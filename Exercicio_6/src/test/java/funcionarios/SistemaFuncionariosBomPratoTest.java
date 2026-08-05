package funcionarios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaFuncionariosBomPratoTest {

    @Test
    public void testaCadastroEPesquisa() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();

        try {
            // Cadastra o funcionário
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças",
                    TipoFuncionario.GERENTE, 3000));

            // Verifica se ele existe
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));

            // Pesquisa o funcionário e guarda na variável f1
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");

            // Completa o TODO com as asserções para validar os dados
            assertNotNull(f1);
            assertEquals("333.333.333-33", f1.getCpf());
            assertEquals("Ayla Rebouças", f1.getNome());
            assertEquals(TipoFuncionario.GERENTE, f1.getTipo());
            assertEquals(3000.0, f1.getSalario(), 0.0001);

        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }
}