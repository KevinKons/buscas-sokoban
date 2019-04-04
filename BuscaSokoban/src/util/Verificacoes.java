package util;

import model.Coordenada;

public class Verificacoes {

    public static boolean ehPosicaoVaziaOuObjetivo(Coordenada coordenada, char[][] matriz) {
        if((matriz[coordenada.getX()][coordenada.getY()] == ' ') ||
                matriz[coordenada.getX()][coordenada.getY()] == '.') {
            return true;
        }
        return false;
    }

    public static boolean ehPosicaoComCaixa(Coordenada coordenada, char[][] matriz) {
        if(matriz[coordenada.getX()][coordenada.getY()] == '$')
                return true;
            return false;
        }
}
