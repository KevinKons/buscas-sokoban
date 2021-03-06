package util;

import model.Coordenada;
import model.Tabuleiro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

    public static void gravar(String informacao) {

        try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write(informacao);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Tabuleiro ler(String nomeArquivo) {

        char[][] tabuleiro = new char[0][];
        List<Coordenada> caixas = new ArrayList<>();
        List<Coordenada> objetivos = new ArrayList<>();
        Coordenada posSokoban = new Coordenada(0, 0);
        int linha = 0;
        boolean primeiraLinha = true;

        try {
            BufferedReader ler = new BufferedReader(new FileReader("../" + nomeArquivo));
            String str;

            while ((str = ler.readLine()) != null) {
                // Pegando as informações da primeira linha
                if (primeiraLinha) {
                    int y = Integer.parseInt(str.split("x")[0]);
                    int x = Integer.parseInt(str.split("x")[1]);
                    tabuleiro = new char[y][x];
                    primeiraLinha = false;
                } else {
                    // Percorrendo a linha atual do arquivo texto
                    for (int i = 0; i < str.length(); i++) {
                        // Gravando as informações do arquivo texto na matriz de Char
                        tabuleiro[linha][i] = str.charAt(i);
                        //Armazenando cada caixa do mapa
                        if (String.valueOf(str.charAt(i)).equals("$") ||
                                String.valueOf(str.charAt(i)).equals("*")) {
                            //A key é a quantidade de caixas + 1
                            caixas.add(new Coordenada(linha, i));
                        }
                        //Armazenando cada pontoObjetivo do mapa
                        if (String.valueOf(str.charAt(i)).equals(".") ||
                                String.valueOf(str.charAt(i)).equals("+")) {
                            //A key é a quantidade de caixas + 1
                            objetivos.add(new Coordenada(linha, i));
                        }
                        //Pegando a coordenada do player Sokoban
                        if (String.valueOf(str.charAt(i)).equals("@") ||
                                String.valueOf(str.charAt(i)).equals("+")) {
                            posSokoban = new Coordenada(linha, i);
                        }
                    }
                    linha++;
                }
                if(str.equals(" ")){
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new Tabuleiro(tabuleiro, caixas, objetivos, posSokoban);
    }
}
