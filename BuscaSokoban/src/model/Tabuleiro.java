package model;

import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {

    private Map<Integer, Coordenada> caixas;
    private char[][] matriz; // Y e X
    private Coordenada posSokoban;

    public Tabuleiro(char[][] matriz, HashMap<Integer, Coordenada> caixas, Coordenada posSokoban) {
        this.matriz= matriz;
        this.posSokoban = posSokoban;
        this.caixas = caixas;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    public Map<Integer, Coordenada> getCaixas() {
        return caixas;
    }

    public void setCaixas(Map<Integer, Coordenada> caixas) {
        this.caixas = caixas;
    }

    public void addCaixa(int key, Coordenada coordenada){
        this.caixas.put(key, coordenada);
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
                resultado += elemento+"";
            }
            resultado = resultado + "\n";
        }
        return resultado;
    }
}
