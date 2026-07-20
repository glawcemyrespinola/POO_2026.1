package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {

        for (Amigo a : amigos) {
            if (a.getEmail().equals(emailAmigo)) {
                throw new AmigoJaExisteException("Amigo já cadastrado: " + emailAmigo);
            }
        }
        amigos.add(new Amigo(nomeAmigo, emailAmigo));
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        for (Amigo a : amigos) {
            if (a.getEmail().equals(emailAmigo)) {
                return a;
            }
        }
        throw new AmigoInexistenteException("Amigo não encontrado: " + emailAmigo);
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        this.mensagens.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        this.mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo a = pesquisaAmigo(emailDaPessoa);
        a.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo a = pesquisaAmigo(emailDaPessoa);
        if (a.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("Amigo sorteado ainda não configurado para: " + emailDaPessoa);
        }
        return a.getEmailAmigoSorteado();
    }
}