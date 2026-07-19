public class SistemaGestaoJogadores {
    public static void main(String[] args) throws Exception {
        GerenciadorJogadores jogadores = new GerenciadorJogadores();
        Jogador_de_Futebol jogador1 = new Jogador_de_Futebol("Neymar", 34, 1.75, 68.0, "Santos FC");
        Jogador_de_Futebol jogador2 = new Jogador_de_Futebol("Zico", 70, 1.72, 69.0, "Flamengo");
        jogador1.setNome("Neymar Jr");

        try {
            jogadores.adicionarJogador(jogador1);
            jogadores.adicionarJogador(jogador2);
            jogadores.adicionarJogador(jogador1);
        } catch (Exception e) {

            System.out.println("Atenção! " + e.getMessage());
        }
        System.out.println("\n--- Jogadores Cadastrados ---");

        for (Jogador_de_Futebol j : jogadores.getListaJogadores()) {
            System.out.println(j.toString());
        }
    }
}
