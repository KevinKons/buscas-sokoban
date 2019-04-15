package util;

import model.Coordenada;
import model.EstadoSokoban;

public class GeradorEstado {

    public static EstadoSokoban geraNovoEstado(EstadoSokoban novoEstado, Coordenada coordenadaAvancandoUm,
                                               Coordenada coordenadaAvancandoDois) throws CloneNotSupportedException {
        char[][] matriz = novoEstado.getTabuleiro().getMatriz();

        if(Verificacoes.ehPosicaoVaziaOuObjetivo(coordenadaAvancandoUm, matriz)) {
            return geraNovoEstadoPosicaoDestinoVaziaOuObjetivo(novoEstado, coordenadaAvancandoUm);
        } else if(Verificacoes.ehPosicaoComCaixa(coordenadaAvancandoUm, matriz)) {
            if(Verificacoes.podeEmpurrar(coordenadaAvancandoDois, matriz)) {
                return geraNovoEstadoEmpurrandoCaixa(novoEstado, coordenadaAvancandoUm, coordenadaAvancandoDois);
            }
        }

        return null;
    }

    private static EstadoSokoban geraNovoEstadoPosicaoDestinoVaziaOuObjetivo(EstadoSokoban novoEstado,
                                                                             Coordenada coordenadaFutura) {

        AtribuiNovoElemento.posicaoAtualSokoban(novoEstado.getTabuleiro());
        AtribuiNovoElemento.posicaoFuturaSokoban(novoEstado.getTabuleiro(), coordenadaFutura);

        novoEstado.getTabuleiro().setPosSokoban(coordenadaFutura);

        return novoEstado;
    }

    private static EstadoSokoban geraNovoEstadoEmpurrandoCaixa(EstadoSokoban novoEstado, Coordenada coordenadaFuturaSokoban,
                                                               Coordenada coordenadaFuturaCaixa) {

        AtribuiNovoElemento.posicaoAtualSokoban(novoEstado.getTabuleiro());
        AtribuiNovoElemento.posicaoFuturaSokoban(novoEstado.getTabuleiro(), coordenadaFuturaSokoban);
        AtribuiNovoElemento.posicaoFuturaCaixa(novoEstado.getTabuleiro(), coordenadaFuturaCaixa);

        novoEstado.getTabuleiro().setPosSokoban(coordenadaFuturaSokoban);
//        novoEstado.getTabuleiro().setNovaPosicaoCaixa(coordenadaFuturaSokoban, coordenadaFuturaCaixa);


        return novoEstado;

    }
}
