package util;

import model.Tabuleiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class LeitorArquivo {

    private static Tabuleiro ler(String nomeArquivo) throws Exception {

        char[][] tabuleiro = new char[0][];
        int qtdCaixas = 0;
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
                }
                // Gravando as informações do arquivo texto na matriz de Char
                for (int i = 0; i < str.length() - 1; i++) {
                    tabuleiro[linha][i] = str.charAt(i);
                    if (String.valueOf(str.charAt(i)).equals("$")) {
                        qtdCaixas++;
                    }
                }
//                System.out.println(str);

                linha++;

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
//        System.out.println("Quantidade caixas:" + qtdCaixas);
        return new Tabuleiro(tabuleiro, 0);
    }

//    public static void main(String[] args) throws Exception {
//
//        ler("alberto(1).txt");
//
//    }

}
