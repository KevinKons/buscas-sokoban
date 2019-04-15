package util;

import jomi.Busca;
import jomi.Nodo;
import model.EstadoSokoban;
import model.Tabuleiro;

public class ExecutarBusca extends Thread {

    private Busca busca;
    private Tabuleiro tabuleiro;
    private String nomeBusca;

    public ExecutarBusca(Busca busca, Tabuleiro tabuleiro, String nomeBusca) {
        this.busca = busca;
        this.tabuleiro = tabuleiro;
        this.nomeBusca = nomeBusca;
    }

    //    @Override
    public void run() {

        Nodo n = null;
        try {

            long tempoInicio = System.currentTimeMillis();
            n = busca.busca(new EstadoSokoban(tabuleiro));

            LeitorArquivo.gravar("\n" + nomeBusca + ": " + (System.currentTimeMillis() - tempoInicio) + "ms com " + busca.getStatus().getVisitados() + " nodos visitados");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
