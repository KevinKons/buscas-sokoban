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

//-Xmx3072m
public class Main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escolha o modo de execução \n" +
                    "1 - Escolhendo busca e instância \n" +
                    "2 - Executar tudo");
            int opcao = sc.nextInt();

            if(opcao == 1)
                executar();
            else
                executarTudo();
        } catch (FileNotFoundException ex) {
            System.out.println("O sistema não pode encontrar o arquivo específicado. Não esqueça de fornecer a extensão do arquivo");
            executar();
        } catch (NullPointerException | NumberFormatException ex) {
            System.out.println("O sistema não pode encontrar a busca especificada.");
            executar();
        }

    }

    private static void executarTudo() throws IOException, NullPointerException, CloneNotSupportedException {
        System.out.println("Executando instâncias");

        List<String> instancias = new ArrayList<>();
        instancias.add("easy(1).txt");
        instancias.add("ac_easy(7).txt");
        instancias.add("moderate(5).txt");
        instancias.add("moderate(7).txt");
        instancias.add("ac_easy(outside_in).txt");
        instancias.add("ac_easy(warming_up).txt");
        instancias.add("easy(4).txt");
        instancias.add("alberto(1).txt");
        instancias.add("alberto(3).txt");
        instancias.add("alberto(14).txt");

        List<Busca> buscas = new ArrayList<>();
        buscas.add(new BuscaLargura());
        buscas.add(new BuscaProfundidade());
        buscas.add(new BuscaIterativo());
        buscas.add(new AEstrela());

        for (String instancia : instancias) {

            LeitorArquivo.gravar("\nNome: " + instancia);
            Tabuleiro tabuleiro = LeitorArquivo.ler(instancia);

            for (int i = 0; i < 4; i++) {

                Busca busca = defineBusca(i);

                ExecutarBusca exec = new ExecutarBusca(busca, tabuleiro.clonar(), nomeBusca(i));
                long tempoInicial = System.currentTimeMillis();
                exec.start();

                while (true) {
                    long tempoAtual = System.currentTimeMillis();

                    if ((tempoAtual - tempoInicial) >= 1800000) {
                        exec.stop();
                        LeitorArquivo.gravar("\nbusca: sem solução");
                        break;
                    } else if (!exec.isAlive()) {
                        break;
                    }
                }

            }
        }
    }
    private static void executar() throws  NullPointerException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o nome da instância que o agente deve solucionar");
        String instancia = sc.nextLine();
        Tabuleiro tabuleiro = LeitorArquivo.ler(instancia);

        System.out.println("Insira o tipo de busca que deseja utilizar: \n" +
                "1 - Busca em Largura \n" +
                "2 - Busca em profundidade \n" +
                "3 - Busca em profundidade iterativa \n" +
                "4 - Busca A*");
        int buscaEscolhida = Integer.parseInt(sc.nextLine());

        Busca busca = null;
        switch(buscaEscolhida) {
            case 1:
                busca = new BuscaLargura();
                break;
            case 2:
                busca = new BuscaProfundidade();
                break;
            case 3:
                busca = new BuscaIterativo();
                break;
            case 4:
                busca = new AEstrela();
                break;
        }
        if(busca == null)
            throw new NullPointerException();

        Nodo n = null;
        try {
            long tempoInicio = System.currentTimeMillis();
            n = busca.busca(new EstadoSokoban(tabuleiro));
            if (n == null) {
                System.out.println("sem solucao!");
            } else {
                System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
            }
            long tempoFinal = System.currentTimeMillis();
            System.out.println(tempoFinal - tempoInicio);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Busca defineBusca(int i) {
        switch (i) {
            case 0:
                return new BuscaLargura();
            case 1:
                return new BuscaProfundidade();
            case 2:
                return new BuscaIterativo();
            case 3:
                return new AEstrela();
        }
        return null;
    }

    private static String nomeBusca(int busca) {

        switch (busca) {
            case 0:
                return "Largura";
            case 1:
                return "Profundidade";
            case 2:
                return "Profundidade Iterativa";
            case 3:
                return "Busca A*";
                default: return "Instancia não cadastrada";
        }

    }
}