package util;

import model.Coordenada;
import model.Tabuleiro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorArquivo {

    private static Tabuleiro ler(String nomeArquivo) throws Exception {

        char[][] tabuleiro = new char[0][];
        HashMap<Integer, Coordenada> caixas = new HashMap<>();
        Coordenada posSokoban = new Coordenada(0, 0);
        int linha = 0;
        boolean primeiraLinha = true;

        try {
            BufferedReader ler = new BufferedReader(new FileReader("../" + nomeArquivo));
            String str;

            while ((str = ler.readLine()) != null) {
                // Pegando as informações da primeira linha
                if (primeiraLinha) {
                    int x = (int) str.charAt(0);
                    int y = (int) str.charAt(2);
                    tabuleiro = new char[x][y];
                    primeiraLinha = false;
                } else {
                    // Percorrendo a linha atual do arquivo texto
                    for (int i = 0; i < str.length(); i++) {
                        // Gravando as informações do arquivo texto na matriz de Char
                        tabuleiro[linha][i] = str.charAt(i);
                        //Contando a coordenada de cada caixa no mapa
                        if (String.valueOf(str.charAt(i)).equals("$")) {
                            //A key é a quantidade de caixas + 1
                            caixas.put(caixas.size() + 1, new Coordenada(linha, i));
                        }
                        //Pegando a coordenada do player Sokoban
                        if (String.valueOf(str.charAt(i)).equals("@")) {
                            posSokoban = new Coordenada(i, linha);
                        }
                    }
                    linha++;
                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new Tabuleiro(tabuleiro, caixas, posSokoban);
    }

//    public static void main(String[] args) throws Exception {
//        Tabuleiro tabuleiro = ler("alberto(1).txt");
//        System.out.println("Caixas: " + tabuleiro.getCaixas().size());
//
//        // i = 1 pois o primeiro registro do HashMap começa em 1
//        for(int i = 1; i <= tabuleiro.getCaixas().size(); i++){
//            System.out.println("Coordenada ("+i+"): " + tabuleiro.getCaixas().get(i).toString());
//        }
//
//        System.out.println(tabuleiro.toString());
//
//    }
}
