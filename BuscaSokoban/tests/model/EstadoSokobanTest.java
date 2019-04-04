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
                {'#',' ',' ',' ',' ',' ',' ','+',' ','#'},
                {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };
//        estadoSokoban = new EstadoSokoban(new Tabuleiro(matriz, 1));
    }

    @Test
    public void ehMeta() {
        Assert.assertFalse(estadoSokoban.ehMeta());
    }

}