package util;

import jomi.Busca;
import jomi.Nodo;
import model.EstadoSokoban;
import model.Tabuleiro;

public class ExecutarBusca extends Thread {

    private Busca busca;
    private Tabuleiro tabuleiro;

    public ExecutarBusca(Busca busca, Tabuleiro tabuleiro){
        this.busca = busca;
        this.tabuleiro = tabuleiro;
    }

    @Override
    public void run() {

        Nodo n = null;
        try {

            long tempoInicio = System.currentTimeMillis();
            n = busca.busca(new EstadoSokoban(tabuleiro));

            LeitorArquivo.gravar("\nbusca: " + (System.currentTimeMillis() - tempoInicio));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
