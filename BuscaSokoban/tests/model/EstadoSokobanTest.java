package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EstadoSokobanTest {

    private EstadoSokoban estadoSokoban;

    @Before
    public void setUp() throws Exception {
        char[][] matriz = {
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                {'#',' ',' ',' ','@',' ',' ',' ',' ','#'},
                {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };
        estadoSokoban = new EstadoSokoban(new Tabuleiro(matriz, 1, new Coordenada(2, 4)));
    }

    @Test
    public void ehMeta() {
        Assert.assertFalse(estadoSokoban.ehMeta());
    }

    @Test
    public void geraNovoEstadoPosicaoVaziaOuObjetivo() throws CloneNotSupportedException {
//        estadoSokoban.geraNovoEstadoPosicaoDestinoVaziaOuObjetivo(new Coordenada(2, 2));
//        System.out.println(estadoSokoban.getTabuleiro().toString());
    }

    @Test
    public void andarParaCima() throws CloneNotSupportedException {
        estadoSokoban.andarParaCima(null);
    }


    @Test
    public void andarParaBaixo() throws CloneNotSupportedException {
        estadoSokoban.andarParaBaixo(null);
    }

    @Test
    public void andarParaEsquerda() throws CloneNotSupportedException {
        estadoSokoban.andarParaEsquerda(null);
    }

    @Test
    public void andarParaDireita() throws CloneNotSupportedException {
        estadoSokoban.andarParaDireita(null);
    }
}
