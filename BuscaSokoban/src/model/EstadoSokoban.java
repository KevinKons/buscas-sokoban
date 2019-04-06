package model;

import jomi.Estado;
import util.AtribuiNovoElemento;
import util.GeradorEstado;
import util.Verificacoes;

import java.util.LinkedList;
import java.util.List;

public class EstadoSokoban implements Estado, Cloneable {

    @Override
    public String getDescricao() {
        return "O problema consiste em um jogador " +
                "movimentar uma ou mais caixas para os pontos " +
                "chave no tabuleiro";
    }

    private Tabuleiro tabuleiro;

    public EstadoSokoban(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public EstadoSokoban() { }

    @Override
    public boolean ehMeta() {
        char[][] matriz = tabuleiro.getMatriz();
        int qntCaixaNaMeta = 0;

        for(char[] vetor : matriz) {
            for(char elemento : vetor) {
                switch (elemento) {
                    case '$':
                        return false;
                    case '.':
                        return false;
                    case '+':
                        return false;
                    case '*':
                        qntCaixaNaMeta++;
                        if(qntCaixaNaMeta == tabuleiro.getQntCaixas())
                            return true;
                }
            }
        }
        return false;
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<Estado> sucessores() {
        List<Estado> suc = new LinkedList<Estado>();

        try {
            andarParaCima(suc);
            andarParaBaixo(suc);
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void andarParaBaixo(List<Estado> suc) {
        char[][] matriz = tabuleiro.getMatriz();
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaBaixo = coordenadaSokoban; coordenadaBaixo.setY(coordenadaSokoban.getY() + 1);
    }

    public void andarParaCima(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaCima = new Coordenada(coordenadaSokoban.getY() - 1, coordenadaSokoban.getX());
        Coordenada coordenadaFuturaCaixa = new Coordenada(coordenadaSokoban.getY() - 2, coordenadaSokoban.getX());

        EstadoSokoban novoEstado = GeradorEstado.geraNovoEstado(this.clone(), coordenadaCima, coordenadaFuturaCaixa);
        System.out.println(novoEstado.getTabuleiro().toString());

        if(!causaDeadLock()) {
            suc.add(novoEstado);
        }

    }

    private boolean causaDeadLock() {
        return false;
    }


    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public EstadoSokoban clone() {
        return new EstadoSokoban(tabuleiro);
    }
}
