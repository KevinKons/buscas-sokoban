package util;

import model.Coordenada;
import model.Tabuleiro;

public class Verificacoes {

    public static boolean ehPosicaoVaziaOuObjetivo(Coordenada coordenada, char[][] matriz) {
        if((matriz[coordenada.getY()][coordenada.getX()] == ' ') ||
                matriz[coordenada.getY()][coordenada.getX()] == '.')
            return true;
        return false;
    }

    public static boolean ehPosicaoComCaixa(Coordenada coordenada, char[][] matriz) {
        if(matriz[coordenada.getY()][coordenada.getX()] == '$' || matriz[coordenada.getY()][coordenada.getX()] == '*')
            return true;
        return false;
    }

    public static boolean podeEmpurrar(Coordenada coordenada, char[][] matriz) {
        if(matriz[coordenada.getY()][coordenada.getX()] == ' ' || matriz[coordenada.getY()][coordenada.getX()] == '.')
            return true;
        return false;
    }

    /** Verificação de Deadlocks **/

    // Dead square deadlocks
    // Retorna false se não detectado Deadlock ou true se detectado
    public static boolean contemDeadSquare(Tabuleiro tabuleiro){

        // 1 - Percorrer a lista de caixas
        // 2 - Verificar se a coordenadas anteriores ou posteriores são paredes na matriz
        for(int i = 0; i < tabuleiro.getCaixas().size(); i++){

            // A Key do Map de caixas inicia em 1, por do isso i + 1 abaixo
            int y = tabuleiro.getCaixas().get(i + 1).getY();
            int x = tabuleiro.getCaixas().get(i + 1).getX();

            /**
             * Verificar possibilidades:
             * 1 -> Y - 1 e X
             * 2 -> Y e X - 1
             *
             * 3 -> Y - 1 e X
             * 4 -> Y e X + 1
             *
             * 5 -> Y + 1 e X
             * 6 -> Y e X + 1
             *
             * 7 -> Y + 1 e X
             * 8 -> Y e X - 1
             */

            if(String.valueOf(tabuleiro.getMatriz()[y - 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x - 1]).equals("#")){
                return true;
            }

            if(String.valueOf(tabuleiro.getMatriz()[y - 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x + 1]).equals("#")){
                return true;
            }

            if(String.valueOf(tabuleiro.getMatriz()[y + 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x + 1]).equals("#")){
                return true;
            }

            if(String.valueOf(tabuleiro.getMatriz()[y + 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x - 1]).equals("#")){
                return true;
            }

        }

        return false;
    }

}
