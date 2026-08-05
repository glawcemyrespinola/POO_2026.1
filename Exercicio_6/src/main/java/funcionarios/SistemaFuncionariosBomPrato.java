package funcionarios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SistemaFuncionariosBomPrato implements SistemaFuncionarios {

    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<>();
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getCpf(), funcionario);
    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario) {
        Funcionario f = new Funcionario(cpf, nome, tipoFuncionario, salario);
        cadastrarFuncionario(f);
    }

    @Override
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) {
        Funcionario f = pesquisarFuncionario(cpfFuncionario);
        if (f != null) {
            f.setSalario(novoSalario);
        }
    }

    @Override
    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int contador = 0;
        for (Funcionario f : funcionarios.values()) {
            if (f.getTipo() == tipo) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return funcionarios.containsKey(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        return funcionarios.values().stream()
                .filter(f -> f.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    @Override
    public Funcionario pesquisarFuncionario(String cpfFuncionario) {
        return funcionarios.get(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        return funcionarios.values().stream()
                .filter(f -> f.getSalario() > valor)
                .collect(Collectors.toList());
    }


}