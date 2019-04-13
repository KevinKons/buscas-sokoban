package model;

import jomi.Estado;
import jomi.Heuristica;
import util.AtribuiNovoElemento;
import util.CalculaHeuristica;
import util.GeradorEstado;
import util.Verificacoes;

import java.util.LinkedList;
import java.util.List;

import static util.Verificacoes.contemDeadSquare;

public class EstadoSokoban implements Estado, Heuristica, Cloneable {

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

        for(char[] vetor : matriz)
            for(char elemento : vetor)
                switch (elemento) {
                    case '$':
                        return false;
                    case '.':
                        return false;
                    case '+':
                        return false;
                    case '*':
                        qntCaixaNaMeta++;
                        if(qntCaixaNaMeta == tabuleiro.getCaixas().size())
                            return true;
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
            andarParaEsquerda(suc);
            andarParaDireita(suc);
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return suc;
    }

    public void andarParaDireita(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaEsquerda =  new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() + 1);
        Coordenada coordenadaFuturaCaixa =  new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() + 2);

        EstadoSokoban novoEstado = GeradorEstado.geraNovoEstado(this.clonar(), coordenadaEsquerda, coordenadaFuturaCaixa);

        if(novoEstado != null)
            suc.add(novoEstado);

    }

    public void andarParaEsquerda(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaEsquerda =  new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() - 1);
        Coordenada coordenadaFuturaCaixa =  new Coordenada(coordenadaSokoban.getY(), coordenadaSokoban.getX() - 2);

        EstadoSokoban novoEstado = GeradorEstado.geraNovoEstado(this.clonar(), coordenadaEsquerda, coordenadaFuturaCaixa);

        if(novoEstado != null)
            suc.add(novoEstado);
    }



    public void andarParaBaixo(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaBaixo =  new Coordenada(coordenadaSokoban.getY() + 1, coordenadaSokoban.getX());
        Coordenada coordenadaFuturaCaixa =  new Coordenada(coordenadaSokoban.getY() + 2, coordenadaSokoban.getX());

        EstadoSokoban novoEstado = GeradorEstado.geraNovoEstado(this.clonar(), coordenadaBaixo, coordenadaFuturaCaixa);

        if(novoEstado != null)
            suc.add(novoEstado);

    }

    public void andarParaCima(List<Estado> suc) throws CloneNotSupportedException {
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaCima = new Coordenada(coordenadaSokoban.getY() - 1, coordenadaSokoban.getX());
        Coordenada coordenadaFuturaCaixa = new Coordenada(coordenadaSokoban.getY() - 2, coordenadaSokoban.getX());

        EstadoSokoban novoEstado = GeradorEstado.geraNovoEstado(this.clonar(), coordenadaCima, coordenadaFuturaCaixa);

        if(novoEstado != null)
            suc.add(novoEstado);

    }
    //easy(1).txt

    /** returna true se o estado e valido */
    private boolean ehValido(Tabuleiro tabuleiro) {
        return contemDeadSquare(tabuleiro);
    }


    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public EstadoSokoban clonar() throws CloneNotSupportedException {
        return new EstadoSokoban(tabuleiro.clonar());
    }


    @Override
    public int h() {
        return h1();
    }

    /*Manhattan distance*/
    public int h1() {
        int distanciaTotal = 0;
        for(Coordenada caixa : tabuleiro.getCaixas())
            distanciaTotal += CalculaHeuristica.manhattanDistance(caixa, localizaObjetivoMaisProximo(caixa));

        return distanciaTotal;
    }

    public Coordenada localizaObjetivoMaisProximo(Coordenada caixa) {
        Coordenada coordenadaEscolhida = null;
        double distanciaCoordenadaEscolhida = 1000;

        for(Coordenada objetivo : tabuleiro.getObjetivos()) {
            double distancia =
                    Math.hypot(Math.abs(objetivo.getX() - caixa.getX()), Math.abs(objetivo.getY() - caixa.getY()));
            if(distancia < distanciaCoordenadaEscolhida) {
                distanciaCoordenadaEscolhida = distancia;
                coordenadaEscolhida = objetivo;
            }
        }

        return coordenadaEscolhida;
    }
}
