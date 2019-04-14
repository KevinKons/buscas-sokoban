import javafx.scene.control.Tab;
import jomi.*;
import model.EstadoSokoban;
import model.Tabuleiro;
import util.ExecutarBusca;
import util.LeitorArquivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            executar();
        } catch (FileNotFoundException ex) {
            System.out.println("O sistema não pode encontrar o arquivo específicado. Não esqueça de fornecer a extensão do arquivo");
            executar();
        } catch (NullPointerException | NumberFormatException ex) {
            System.out.println("O sistema não pode encontrar a busca especificada.");
            executar();
        }

    }

    //    @Timeable(limit = 5, unit = TimeUnit.SECONDS) f
    private static void executar() throws IOException, NullPointerException {

        System.out.println("Executando instâncias");

        /*
         * Para cada instância:
         *
         * 1 - Aplicar um algoritmo
         * 2 - Gravar hora inicio e hora fim
         * 3 - Armazenar no arquivo.txt de saída
         */
        List<String> instancias = new ArrayList<>();
        instancias.add("easy(1).txt");
        instancias.add("easy(4).txt");
        instancias.add("alberto(1).txt");
//        instancias.add("alberto(3).txt");
//        instancias.add("alberto(14).txt");
//        instancias.add("moderate(5).txt");
//        instancias.add("moderate(7).txt");
//        instancias.add("ac_easy(7).txt");
//        instancias.add("ac_easy(outside_in).txt");
//        instancias.add("ac_easy(warming_up).txt");

        List<Busca> buscas = new ArrayList<>();
        buscas.add(new BuscaLargura());
        buscas.add(new BuscaProfundidade());
        buscas.add(new BuscaIterativo());
        buscas.add(new AEstrela());


        for (String instancia : instancias) {

            LeitorArquivo.gravar("\nNome: " + instancia);
            Tabuleiro tabuleiro = LeitorArquivo.ler(instancia);

            for (Busca busca : buscas) {

                ExecutarBusca exec = new ExecutarBusca(busca, tabuleiro);
                long tempoInicial = System.currentTimeMillis();
                exec.start();

                while (true) {
                    long tempoAtual = System.currentTimeMillis();

                    if ((tempoAtual - tempoInicial) >= 3600000) {
                        exec.stop();
                        LeitorArquivo.gravar("\nbusca: sem solução");
                        break;
                    }else if(!exec.isAlive()){
                        break;
                    }
                }

            }
        }
    }
}