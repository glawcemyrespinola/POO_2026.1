import java.util.Objects;

public class Jogador_de_Futebol {

    // Atributos
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String clube;

    // Construtores
    public Jogador_de_Futebol(String nome, int idade, double altura, double peso, String clube) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.clube = clube;
    }

    // Métodos Getter e Sette
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getClube() {
        return clube;
    }

    public void transferirClube(String novoClube) throws TransferenciaInvalidaException {
        // Um jogador não pode ser transferido para o mesmo clube onde já está
        if (this.clube.equalsIgnoreCase(novoClube)) {
            throw new TransferenciaInvalidaException("O jogador já pertence a este clube!");
        }
        this.clube = novoClube;
    }

    @Override
    public String toString() {
        return "Jogador: " + nome +
                ", " + idade + " anos" +
                ", " + altura + " de altura" +
                ", " + peso + " kg" +
                ", " + clube;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jogador_de_Futebol that = (Jogador_de_Futebol) o;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getClube(), that.getClube());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getClube());
    }

}
