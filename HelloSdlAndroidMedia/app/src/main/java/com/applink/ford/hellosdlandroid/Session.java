package com.applink.ford.hellosdlandroid;

import dominio.Veiculo;

/**
 * Created by Uehara on 21/08/2016.
 */
public class Session {

    public static Veiculo veiculo = new Veiculo();

    public static Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
