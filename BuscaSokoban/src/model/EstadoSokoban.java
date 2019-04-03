package model;

import jomi.Estado;

import java.util.List;

public class EstadoSokoban implements Estado {
    @Override
    public String getDescricao() {
        return "O problema consiste em um jogador " +
                "movimentar uma ou mais caixas para os pontos " +
                "chave no tabuleiro";
    }

    @Override
    public boolean ehMeta() {
        return false;
    }

    @Override
    public int custo() {
        return 0;
    }

    @Override
    public List<Estado> sucessores() {
        return null;
    }
}
