package util;

import model.Coordenada;

public class CalculaHeuristica {

    public static int manhattanDistance(Coordenada caixa, Coordenada objetivo) {
        return Math.abs(caixa.getX() - objetivo.getX()) + Math.abs(caixa.getY() - objetivo.getY());
    }
}
