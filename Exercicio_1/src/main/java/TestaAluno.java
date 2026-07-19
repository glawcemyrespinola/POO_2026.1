import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestaAluno {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Aluno> listaDeAlunos = new ArrayList<>();

        // Repete 3 vezes para cadastrar 3 alunos diferentes
        for (int i = 0; i < 3; i++) {
            System.out.println("--- Cadastro do aluno " + (i + 1) + " ---");

            System.out.println("Digite o nome:");
            String nome = leitor.nextLine();

            System.out.println("Digite a matrícula:");
            String matricula = leitor.nextLine();

            // Lógica para ler as notas desse aluno específico
            double[] notas = new double[3]; // Definindo que cada aluno tem 3 notas
            for (int j = 0; j < 3; j++) {
                System.out.println("Digite a nota " + (j + 1) + ":");
                notas[j] = Double.parseDouble(leitor.nextLine());
            }

            // Cria o objeto Aluno e adiciona na lista
            Aluno a = new Aluno(nome, matricula, notas);
            listaDeAlunos.add(a);
        }

        // Percorrer a lista e mostrar a média de cada aluno
        System.out.println("\n--- Médias ---");
        for (Aluno aluno : listaDeAlunos) {
            try {
                System.out.println("Aluno: " + aluno.getNome() + " | Média: " + aluno.getMedia());
            } catch (NotasInexistentesException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        leitor.close();
    }
}