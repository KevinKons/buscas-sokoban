package model;

public class Tabuleiro {

    private char[][] tabuleiro;
    private int qntCaixas;

    public Tabuleiro(char[][] tabuleiro, int qntCaixas) {
        this.tabuleiro = tabuleiro;
        this.qntCaixas = qntCaixas;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getQntCaixas() {
        return qntCaixas;
    }

    public void setQntCaixas(int qntCaixas) {
        this.qntCaixas = qntCaixas;
    }
}
