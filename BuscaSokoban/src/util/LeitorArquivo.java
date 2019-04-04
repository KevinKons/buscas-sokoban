package util;

import model.Tabuleiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

public class LeitorArquivo {

    public Tabuleiro ler(String nomeArquivo) throws Exception {

        char[][] tabuleiro;
        int qtdCaixas = 0;
        boolean primeiraLinha = true;

        try {
            BufferedReader ler = new BufferedReader(new FileReader(nomeArquivo));
            String str;
            while ((str = ler.readLine()) != null) {

                if (primeiraLinha) {
                    int x = (int) str.charAt(0);
                    int y = (int) str.charAt(2);
                    tabuleiro = new char[x][y];
                    primeiraLinha = false;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ex.getMessage());
        }

        return null;
    }

}
