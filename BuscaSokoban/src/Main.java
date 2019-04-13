import jomi.*;
import model.EstadoSokoban;
import model.Tabuleiro;
import util.LeitorArquivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            executar();
        } catch (FileNotFoundException ex) {
            System.out.println("O sistema não pode encontrar o arquivo específicado. Não esqueça de fornecer a extensão do arquivo");
            executar();
        } catch (NullPointerException | NumberFormatException ex) {
            System.out.println("O sistema não pode encontrar a busca específicada.");
            executar();
        }

    }

//    @Timeable(limit = 5, unit = TimeUnit.SECONDS) f
    private static void executar() throws IOException, NullPointerException {
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
            n = busca.busca(new EstadoSokoban(tabuleiro));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
        }
    }
}
