package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabuleiro implements Cloneable {

    private char[][] matriz; // X e Y
    private Coordenada posSokoban;

    public Tabuleiro(char[][] matriz, List<Coordenada> caixas, Coordenada posSokoban) {
        this.matriz = matriz;
        this.posSokoban = posSokoban;
    }

    public Tabuleiro(char[][] matriz, List<Coordenada> caixas, List<Coordenada> objetivos, Coordenada posSokoban) {
        this.matriz = matriz;
        this.posSokoban = posSokoban;
    }

    public Tabuleiro() {

    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    public Coordenada getPosSokoban() {
        return posSokoban;
    }

    public void setPosSokoban(Coordenada posSokoban) {
        this.posSokoban = posSokoban;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (char[] vetor : matriz) {
            for (char elemento : vetor) {
                resultado += elemento + "";
            }
            resultado = resultado + "\n";
        }
        return resultado;
    }

    public Tabuleiro clonar() {
        Tabuleiro clone = new Tabuleiro();

        clone.matriz = new char[matriz.length][matriz[0].length];
        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz[i].length; j++)
                clone.matriz[i][j] = String.valueOf(matriz[i][j]).charAt(0);

        clone.posSokoban = posSokoban.clonar();
        return clone;
    }
}
