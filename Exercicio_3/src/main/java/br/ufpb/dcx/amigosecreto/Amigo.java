package br.ufpb.dcx.amigosecreto;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.emailAmigoSorteado = null; // Inicia como null para indicar que não há sorteado
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
}