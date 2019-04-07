package util;

import model.Coordenada;
import model.Tabuleiro;

public class Verificacoes {

    public static boolean ehPosicaoVaziaOuObjetivo(Coordenada coordenada, char[][] matriz) {
        if((matriz[coordenada.getX()][coordenada.getY()] == ' ') ||
                matriz[coordenada.getX()][coordenada.getY()] == '.')
            return true;
        return false;
    }

    public static boolean ehPosicaoComCaixa(Coordenada coordenada, char[][] matriz) {
        if(matriz[coordenada.getX()][coordenada.getY()] == '$' || matriz[coordenada.getX()][coordenada.getY()] == '*')
            return true;
        return false;
    }

    public static boolean podeEmpurrar(Coordenada coordenada, char[][] matriz) {
        if(matriz[coordenada.getY()][coordenada.getY()] == ' ' || matriz[coordenada.getY()][coordenada.getY()] == '.')
            return true;
        return false;
    }

    /** Verificação de Deadlocks **/

    // Dead square deadlocks
    public static boolean contemDeadSquare(Tabuleiro tabuleiro){

//        for(int i = 0; i < tabuleiro.getCaixas(); i++){

//        }

        return false;
    }

}
