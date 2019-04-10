package model;

import org.junit.Before;
import org.junit.Test;


public class TabuleiroTest {

    private Tabuleiro tabuleiro = new Tabuleiro();

    @Before
    public void setUp() {
        char[][] matriz = {
                {'#','#','#','#','#','#','#'},
                {'#',' ',' ',' ',' ',' ','#'},
                {'#',' ',' ','$','@',' ','#'},
                {'#',' ',' ',' ',' ',' ','#'},
                {'#','#','#','#','#','#','#'}
        };
        tabuleiro.setMatriz(matriz);

    }

    @Test
    public void testToString() {
        System.out.println(tabuleiro.toString());
        System.out.println(tabuleiro.toString());
    }

    @Test
    public void clonar() throws CloneNotSupportedException {
        tabuleiro.clonar();
    }
}