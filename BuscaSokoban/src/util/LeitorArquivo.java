package util;

import model.Tabuleiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

public class LeitorArquivo {

    // Um método de leitura que retorna um Tabuleiro
    // nomeArquivo.txt
    public Tabuleiro ler(String nomeArquivo) throws Exception {

        int[][] tabuleiro;
        boolean primeiraLinha = true;

        try {
            BufferedReader ler = new BufferedReader(new FileReader(nomeArquivo));
            String str;
            while ((str = ler.readLine()) != null) {

                if (primeiraLinha) {
                    int x = (int) str.charAt(0);
                    int y = (int) str.charAt(2);
                    tabuleiro = new int[x][y];
                    primeiraLinha = false;
                }



            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ex.getMessage());
        }

        return null;
    }

}
