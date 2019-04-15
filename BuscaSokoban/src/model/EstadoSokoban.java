package model;

import jomi.Estado;
import jomi.Heuristica;
import util.CalculaHeuristica;
import util.GeradorEstado;
import util.Verificacoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EstadoSokoban implements Estado, Heuristica, Cloneable {

    private List<Coordenada> caixas;
    private List<Coordenada> objetivos;

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

    @Override
    public boolean ehMeta() {
        char[][] matriz = tabuleiro.getMatriz();
        int qntCaixaNaMeta = 0;

        for (char[] vetor : matriz)
            for (char elemento : vetor)
                switch (elemento) {
                    case '$':
                        return false;
                    case '.':
                        return false;
                    case '+':
                        return false;
                }

        return true;
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<Estado> sucessores() {
        List<Estado> suc = new LinkedList<Estado>();
        setaListaCaixasObjetivos();
        try {
            andarParaCima(suc);
            andarParaBaixo(suc);
            andarParaEsquerda(suc);
            andarParaDireita(suc);
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return suc;
    }

    public void andarParaDireita(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaEsquerda = new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() + 1);
        Coordenada coordenadaFuturaCaixa = new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() + 2);

        newState(suc, coordenadaEsquerda, coordenadaFuturaCaixa);

    }

    public void andarParaEsquerda(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaEsquerda = new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() - 1);
        Coordenada coordenadaFuturaCaixa = new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() - 2);

        newState(suc, coordenadaEsquerda, coordenadaFuturaCaixa);
    }


    public void andarParaBaixo(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaBaixo = new Coordenada(coordenadaSokoban.getY() + 1, coordenadaSokoban.getX());
        Coordenada coordenadaFuturaCaixa = new Coordenada(coordenadaSokoban.getY() + 2, coordenadaSokoban.getX());

        newState(suc, coordenadaBaixo, coordenadaFuturaCaixa);

    }

    public void andarParaCima(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaCima = new Coordenada(coordenadaSokoban.getY() - 1, coordenadaSokoban.getX());
        Coordenada coordenadaFuturaCaixa = new Coordenada(coordenadaSokoban.getY() - 2, coordenadaSokoban.getX());

        newState(suc, coordenadaCima, coordenadaFuturaCaixa);

    }

    private void newState(List<Estado> suc, Coordenada coordenadaCima, Coordenada coordenadaFuturaCaixa) throws CloneNotSupportedException {
        EstadoSokoban novoEstado = GeradorEstado.geraNovoEstado(this.clonar(), coordenadaCima, coordenadaFuturaCaixa);

        if (novoEstado != null) {
            if(!Verificacoes.contemDeadSquare(novoEstado.getTabuleiro(), caixas, objetivos) && !Verificacoes.contemClosedDiagonal(novoEstado.getTabuleiro(), caixas, objetivos))
                suc.add(novoEstado);
        }


    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public EstadoSokoban clonar() {
        return new EstadoSokoban(tabuleiro.clonar());
    }

    @Override
    public int h() {
        setaListaCaixasObjetivos();
        return h1();
    }

    /*Manhattan distance*/
    public int h1() {
        int distanciaTotal = 0;
        for (Coordenada caixa : caixas)
            distanciaTotal += CalculaHeuristica.manhattanDistance(caixa, localizaObjetivoMaisProximo(caixa));

        return distanciaTotal;
    }

    public Coordenada localizaObjetivoMaisProximo(Coordenada caixa) {
        Coordenada coordenadaEscolhida = null;
        double distanciaCoordenadaEscolhida = 1000;

        for (Coordenada objetivo : objetivos) {
            double distancia =
                    Math.hypot(Math.abs(objetivo.getX() - caixa.getX()), Math.abs(objetivo.getY() - caixa.getY()));
            if (distancia < distanciaCoordenadaEscolhida) {
                distanciaCoordenadaEscolhida = distancia;
                coordenadaEscolhida = objetivo;
            }
        }

        return coordenadaEscolhida;
    }


    public void setaListaCaixasObjetivos() {
        caixas = new ArrayList<>();
        objetivos = new ArrayList<>();
        char[][] matriz = this.tabuleiro.getMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                switch(matriz[i][j]) {
                    case '.':
                    case '+':
                        objetivos.add(new Coordenada(i, j));
                        break;
                    case '$':
                        caixas.add(new Coordenada(i, j));
                        break;
                }
            }
        }
    }
}
