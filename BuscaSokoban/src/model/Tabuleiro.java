package model;

import java.util.List;

public class Tabuleiro {

    private char[][] tabuleiro;
    private List<Coordenada> caixas;
    private Coordenada posSokoban;

    public Tabuleiro(char[][] tabuleiro, List<Coordenada> caixas, Coordenada posSokoban) {
        this.tabuleiro = tabuleiro;
        this.posSokoban = posSokoban;
        this.caixas = caixas;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public List<Coordenada> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<Coordenada> caixas) {
        this.caixas = caixas;
    }

    public Coordenada getPosSokoban() {
        return posSokoban;
    }

    public void setPosSokoban(Coordenada posSokoban) {
        this.posSokoban = posSokoban;
    }
}
