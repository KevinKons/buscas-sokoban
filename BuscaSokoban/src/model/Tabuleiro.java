package model;

public class Tabuleiro {

    private char[][] matriz;
    private int qntCaixas;
    private Coordenada posSokoban;

    public Tabuleiro(char[][] tabuleiro, int qntCaixas, Coordenada posSokoban) {
        this.matriz = tabuleiro;
        this.qntCaixas = qntCaixas;
        this.posSokoban = posSokoban;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    public int getQntCaixas() {
        return qntCaixas;
    }

    public void setQntCaixas(int qntCaixas) {
        this.qntCaixas = qntCaixas;
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

        for(char[] vetor : matriz) {
            for(char elemento : vetor) {
                resultado += elemento + " ";
            }
            resultado = resultado + "\n";
        }
        return resultado;
    }
}
