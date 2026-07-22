package br.ufpb.dcx.amigosecreto;

public class MensagemParaTodos extends Mensagem {
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (ehAnonima()) {
            return "br.ufpb.dcx.amigosecreto.Mensagem para todos. Texto: " + getTexto();
        } else {
            return "br.ufpb.dcx.amigosecreto.Mensagem de " + getEmailRemetente() + " para todos. Texto: " + getTexto();
        }
    }
}
