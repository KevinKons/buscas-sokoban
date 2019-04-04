package model;

import jomi.Estado;

import java.util.LinkedList;
import java.util.List;

public class EstadoSokoban implements Estado {

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

        andarParaCima(suc);
        return null;
    }

    private void andarParaCima(List<Estado> suc) {
        char[][] matriz = tabuleiro.getTabuleiro();
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();
        Coordenada coordenadaCima = coordenadaSokoban; coordenadaCima.setY(coordenadaSokoban.getY() + 1);

        //Coordenada cima é um pontoDeCaixa ou um local vazio
        if((matriz[coordenadaCima.getX()][coordenadaCima.getY()] == ' ') ||
                matriz[coordenadaCima.getX()][coordenadaCima.getY()] == '.') {
//            EstadoSokoban novoEstado = geraNovoEstado();
        }
    }

    private EstadoSokoban geraNovoEstado(Coordenada coordenadaSokoban, Coordenada novaCoordenada) {
        char[][] matriz = tabuleiro.getTabuleiro();

        char elementoPosSokoban = matriz[coordenadaSokoban.getX()][coordenadaSokoban.getY()];
        if(elementoPosSokoban == '@')
            matriz[coordenadaSokoban.getX()][coordenadaSokoban.getY()] = ' ';
        else if(elementoPosSokoban == '+')
            matriz[coordenadaSokoban.getX()][coordenadaSokoban.getY()] = '.';

        char elementoNovaCoordenada = matriz[novaCoordenada.getX()][novaCoordenada.getY()];
//        if(elementoNovaCoordenada == )
        return null;
    }
}
