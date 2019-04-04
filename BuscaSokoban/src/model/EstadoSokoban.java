package model;

import jomi.Estado;
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
        char[][] matriz = tabuleiro.getTabuleiro();
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

//        andarParaCima(suc);
        return null;
    }

    private void andarParaCima(List<Estado> suc) throws CloneNotSupportedException {
        char[][] matriz = tabuleiro.getTabuleiro();
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaCima = coordenadaSokoban; coordenadaCima.setY(coordenadaSokoban.getY() - 1);

        //Coordenada cima é um pontoDeCaixa ou um local objetivo
        if(Verificacoes.ehPosicaoVaziaOuObjetivo(coordenadaCima, matriz)) {
            EstadoSokoban novoEstado = geraNovoEstadoPosicaoVaziaOuObjetivo(coordenadaSokoban, coordenadaCima);
        } else if(Verificacoes.ehPosicaoComCaixa(coordenadaCima, matriz)) {
            Coordenada coordenadaAcimaCaixa = coordenadaCima; coordenadaAcimaCaixa.setY(coordenadaCima.getY() - 1);
            if(Verificacoes.podeEmpurrar(coordenadaAcimaCaixa, matriz));
        }

    }

    private EstadoSokoban geraNovoEstadoPosicaoVaziaOuObjetivo(Coordenada coordenadaSokoban, Coordenada novaCoordenada)
            throws CloneNotSupportedException {
        EstadoSokoban novoEstado = (EstadoSokoban) this.clone();
    char[][] matriz = novoEstado.tabuleiro.getTabuleiro();

        //decide novo elemento para a posição atual do sokoban
        char elementoPosSokoban = matriz[coordenadaSokoban.getX()][coordenadaSokoban.getY()];
        if(elementoPosSokoban == '@')
            matriz[coordenadaSokoban.getX()][coordenadaSokoban.getY()] = ' ';
        else if(elementoPosSokoban == '+')
            matriz[coordenadaSokoban.getX()][coordenadaSokoban.getY()] = '.';

        //decide elemento para a posição futura do sokoban
        char elementoNovaCoordenada = matriz[novaCoordenada.getX()][novaCoordenada.getY()];
        if(elementoNovaCoordenada == ' ')
            matriz[novaCoordenada.getY()][novaCoordenada.getY()] = '@';
        else if(elementoNovaCoordenada == '.')
            matriz[novaCoordenada.getY()][novaCoordenada.getY()] = '+';

        //seta nova pos sokoban
        novoEstado.tabuleiro.setPosSokoban(novaCoordenada);

        return novoEstado;
    }

    /** returna true se o estado e valido */
    private boolean ehValido(Estado estado){



        return true;
    }

}
