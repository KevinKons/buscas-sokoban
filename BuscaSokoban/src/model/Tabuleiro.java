package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabuleiro implements Cloneable {

    private char[][] matriz; // X e Y
    private List<Coordenada> caixas;
    private List<Coordenada> objetivos;
    private Coordenada posSokoban;

    public Tabuleiro(char[][] matriz, List<Coordenada> caixas, Coordenada posSokoban) {
        this.matriz = matriz;
        this.posSokoban = posSokoban;
        this.caixas = caixas;
    }

    public Tabuleiro(char[][] matriz, List<Coordenada> caixas, List<Coordenada> objetivos, Coordenada posSokoban) {
        this.matriz = matriz;
        this.caixas = caixas;
        this.objetivos = objetivos;
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

    public List<Coordenada> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<Coordenada> caixas) {
        this.caixas = caixas;
    }

    public void addCaixa(Coordenada coordenadaCaixa) {
        this.caixas.add(coordenadaCaixa);
    }

    public List<Coordenada> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List<Coordenada> objetivos) {
        this.objetivos = objetivos;
    }

    public void addObjetivos(Coordenada coordenadaObjetivo) {
        this.objetivos.add(coordenadaObjetivo);
    }

    public Coordenada getPosSokoban() {
        return posSokoban;
    }

    public void setPosSokoban(Coordenada posSokoban) {
        this.posSokoban = posSokoban;
    }

    public void setNovaPosicaoCaixa(Coordenada coordenadaAntiga, Coordenada futuraCoordenada) {
        for(Coordenada c : caixas) {
            if(c.equals(coordenadaAntiga)) {
                c.setY(futuraCoordenada.getY());
                c.setX(futuraCoordenada.getX());
            }
        }
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

    public Tabuleiro clonar() throws CloneNotSupportedException {
        Tabuleiro clone = (Tabuleiro) clone();

        clone.matriz = new char[matriz.length][matriz[0].length];
        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz[i].length; j++)
                clone.matriz[i][j] = String.valueOf(matriz[i][j]).charAt(0);


        clone.posSokoban = posSokoban.clonar();

        clone.caixas = new ArrayList<>(caixas.size());
        for(Coordenada caixa : caixas)
            clone.caixas.add(caixa.clonar());

        clone.objetivos = new ArrayList<>(objetivos.size());
        for(Coordenada objetivo : objetivos)
            clone.objetivos.add(objetivo.clonar());


        return clone;
    }
}
