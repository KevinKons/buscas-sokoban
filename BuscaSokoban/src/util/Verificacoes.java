package util;

import model.Coordenada;
import model.Tabuleiro;

import java.util.ArrayList;
import java.util.List;

public class Verificacoes {

    public static boolean ehPosicaoVaziaOuObjetivo(Coordenada coordenada, char[][] matriz) {
        if ((matriz[coordenada.getY()][coordenada.getX()] == ' ') ||
                matriz[coordenada.getY()][coordenada.getX()] == '.')
            return true;
        return false;
    }

    public static boolean ehPosicaoComCaixa(Coordenada coordenada, char[][] matriz) {
        if (matriz[coordenada.getY()][coordenada.getX()] == '$' || matriz[coordenada.getY()][coordenada.getX()] == '*')
            return true;
        return false;
    }

    public static boolean podeEmpurrar(Coordenada coordenada, char[][] matriz) {
        if (matriz[coordenada.getY()][coordenada.getX()] == ' ' || matriz[coordenada.getY()][coordenada.getX()] == '.')
            return true;
        return false;
    }


    public static boolean ehObjetivo(Coordenada coordenada, char[][] matriz) {
        try {
            if (matriz[coordenada.getY()][coordenada.getX()] == '.')
                return true;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
//        } finally {
        }
            return false;
    }

    /**
     * Verificação de Deadlocks
     **/

//     Dead square deadlocks
//     Retorna false se não detectado Deadlock ou true se detectado
    public static boolean contemDeadSquare(Tabuleiro tabuleiro, List<Coordenada> caixas, List<Coordenada> objetivos) {

        // 1 - Percorrer a lista de caixas
        // 2 - Verificar se a coordenadas anteriores ou posteriores são paredes na matriz
        for (int i = 0; i < caixas.size(); i++) {

            // Capturando as coordenadas da caixa em iteração
            int y = caixas.get(i).getY();
            int x = caixas.get(i).getX();

            if (String.valueOf(tabuleiro.getMatriz()[y - 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x - 1]).equals("#")) {
                return true;
            }

            if (String.valueOf(tabuleiro.getMatriz()[y - 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x + 1]).equals("#")) {
                return true;
            }

            if (String.valueOf(tabuleiro.getMatriz()[y + 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x + 1]).equals("#")) {
                return true;
            }

            if (String.valueOf(tabuleiro.getMatriz()[y + 1][x]).equals("#") &&
                    String.valueOf(tabuleiro.getMatriz()[y][x - 1]).equals("#")) {
                return true;
            }
        }
        return false;
    }

//     Closed Diagonal Deadlock
//     Retorna false se não detectado Deadlock ou true se detectado
    public static boolean contemClosedDiagonal(Tabuleiro tabuleiro, List<Coordenada> caixas, List<Coordenada> objetivos) {
        // 1 - Verificar se há 4 caixas juntas formando um cubo

        for (int i = 0; i < caixas.size(); i++) {

            // Capturando as coordenadas da caixa em iteração
            int y = caixas.get(i).getY();
            int x = caixas.get(i).getX();

            //Analisando do canto superior esquerdo
            if (String.valueOf(tabuleiro.getMatriz()[y][x + 1]).equals("$")) {
                if (String.valueOf(tabuleiro.getMatriz()[y + 1][x]).equals("$")) {
                    if (String.valueOf(tabuleiro.getMatriz()[y + 1][x + 1]).equals("$")) {
                        return true;
                    }
                }
            }

            //Analisando do canto superior direito
            if (String.valueOf(tabuleiro.getMatriz()[y][x - 1]).equals("$")) {
                if (String.valueOf(tabuleiro.getMatriz()[y + 1][x]).equals("$")) {
                    if (String.valueOf(tabuleiro.getMatriz()[y + 1][x - 1]).equals("$")) {
                        return true;
                    }
                }
            }

            // Analisando canto inferior esquerdo
            if (String.valueOf(tabuleiro.getMatriz()[y][x + 1]).equals("$")) {
                if (String.valueOf(tabuleiro.getMatriz()[y - 1][x]).equals("$")) {
                    if (String.valueOf(tabuleiro.getMatriz()[y - 1][x + 1]).equals("$")) {
                        return true;
                    }
                }
            }

            // Analisando canto inferior direito
            if (String.valueOf(tabuleiro.getMatriz()[y][x - 1]).equals("$")) {
                if (String.valueOf(tabuleiro.getMatriz()[y - 1][x]).equals("$")) {
                    if (String.valueOf(tabuleiro.getMatriz()[y - 1][x - 1]).equals("$")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
