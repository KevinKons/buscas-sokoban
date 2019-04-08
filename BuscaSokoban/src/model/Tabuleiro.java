package model;

import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {

    private char[][] matriz; // Y e X
    private Map<Integer, Coordenada> caixas;
    private Map<Integer, Coordenada> objetivos;
    private Coordenada posSokoban;
    private int NADA = 0;

    public Tabuleiro(char[][] matriz, HashMap<Integer, Coordenada> caixas, Coordenada posSokoban) {
        this.matriz= matriz;
        this.posSokoban = posSokoban;
        this.caixas = caixas;
    }

    public Tabuleiro(char[][] matriz, HashMap<Integer, Coordenada> caixas, HashMap<Integer, Coordenada> objetivos, Coordenada posSokoban) {
        this.matriz= matriz;
        this.caixas = caixas;
        this.objetivos = objetivos;
        this.posSokoban = posSokoban;
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

    public Map<Integer, Coordenada> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(Map<Integer, Coordenada> objetivos) {
        this.objetivos = objetivos;
    }

    public void addObjtivo(int key, Coordenada coordenada){
        this.objetivos.put(key, coordenada);
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
