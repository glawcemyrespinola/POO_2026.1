import java.util.Arrays;

public class Aluno {

    // Atributos
    private String nome;
    private String matricula;
    private double[] notas;

    // Construtores
    public Aluno(){
    }

    public  Aluno(String nome, String matricula, double[] notas) {
    this.nome = nome;
    this.matricula = matricula;
    this.notas = notas;
    }

    // Método_to_String
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", notas=" + Arrays.toString(notas) +
                '}';
    }
    public double getMedia() throws NotasInexistentesException {
        // Primeiro: a verificação de segurança (lança a exceção se não houver notas)
        if (this.notas == null || this.notas.length == 0) {
            throw new NotasInexistentesException ("O aluno " + this.nome + " não possui notas registradas.");
        }

        // Segundo: o cálculo da média
        double soma = 0;
        for (double nota : this.notas) {
            soma += nota;
        }

        return soma / this.notas.length;
    }

    // Métodos Getters
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    }
