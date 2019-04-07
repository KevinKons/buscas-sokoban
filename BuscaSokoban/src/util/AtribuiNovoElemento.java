package util;

import model.Coordenada;
import model.Tabuleiro;

//Nélio Alves

public class AtribuiNovoElemento {

    @SuppressWarnings("Duplicates")
    public static void posicaoAtualSokoban(Tabuleiro tabuleiro) {
        char[][] matriz = tabuleiro.getMatriz();
        Coordenada coordenadaSokoban = tabuleiro.getPosSokoban();

        char elementoPosSokoban = matriz[coordenadaSokoban.getY()][coordenadaSokoban.getX()];
        if(elementoPosSokoban == '@')
            matriz[coordenadaSokoban.getY()][coordenadaSokoban.getX()] = ' ';
        else if(elementoPosSokoban == '+')
            matriz[coordenadaSokoban.getY()][coordenadaSokoban.getX()] = '.';
    }

    public static void posicaoFuturaSokoban(Tabuleiro tabuleiro, Coordenada futuraCoordenada) {
        char[][] matriz = tabuleiro.getMatriz();

        char elementoAtualFuturaCoordenadaSokoban = matriz[futuraCoordenada.getY()][futuraCoordenada.getX()];
        if(elementoAtualFuturaCoordenadaSokoban == ' ' || elementoAtualFuturaCoordenadaSokoban == '$')
            matriz[futuraCoordenada.getY()][futuraCoordenada.getX()] = '@';
        else if(elementoAtualFuturaCoordenadaSokoban == '.' || elementoAtualFuturaCoordenadaSokoban == '*')
            matriz[futuraCoordenada.getY()][futuraCoordenada.getX()] = '+';
    }

    public static void posicaoFuturaCaixa(Tabuleiro tabuleiro, Coordenada coordenadaFuturaCaixa) {
        char[][] matriz = tabuleiro.getMatriz();

        char elementoAtualFuturaCoordenadaCaixa = matriz[coordenadaFuturaCaixa.getY()][coordenadaFuturaCaixa.getX()];
        if(elementoAtualFuturaCoordenadaCaixa == ' ')
            matriz[coordenadaFuturaCaixa.getY()][coordenadaFuturaCaixa.getX()] = '$';
        else if(elementoAtualFuturaCoordenadaCaixa == '.')
            matriz[coordenadaFuturaCaixa.getY()][coordenadaFuturaCaixa.getX()] = '*';
    }
}
