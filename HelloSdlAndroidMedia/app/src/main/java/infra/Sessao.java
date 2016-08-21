package infra;

import dominio.Veiculo;

/**
 * Created by Daivid on 21/08/2016.
 */
public class Sessao {

    private static Veiculo veiculo = new Veiculo();

    public static Veiculo getVeiculo() {
        return veiculo;
    }

    public static void setVeiculo(Veiculo veiculo) {
        Sessao.veiculo = veiculo;
    }
}
