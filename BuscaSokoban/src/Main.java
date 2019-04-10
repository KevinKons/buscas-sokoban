import jomi.BuscaLargura;
import jomi.Nodo;
import model.EstadoSokoban;
import model.Tabuleiro;
import util.LeitorArquivo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o nome da instância que o agente deve buscar a solução");
        String instancia = sc.nextLine();
        Tabuleiro tabuleiro = LeitorArquivo.ler(instancia);

        Nodo n = new BuscaLargura().busca(new EstadoSokoban(tabuleiro));
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
        }


    }
}
