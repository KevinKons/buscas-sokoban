package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class EstadoSokobanTest {

    private EstadoSokoban estadoSokoban;

    @Before
    public void setUp() throws Exception {
        char[][] matriz = {
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                {'#','.',' ','$','@',' ',' ',' ',' ','#'},
                {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };
        List<Coordenada> caixas = new ArrayList<>();
        // Return matriz[][], HashMap de caixas e Coordenada do Player
        estadoSokoban = new EstadoSokoban(new Tabuleiro(matriz, caixas, new Coordenada(2, 4)));
        estadoSokoban.getTabuleiro().setCaixas(Arrays.asList(new Coordenada(2, 3)));
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
