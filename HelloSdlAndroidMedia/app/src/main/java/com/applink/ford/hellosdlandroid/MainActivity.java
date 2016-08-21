package com.applink.ford.hellosdlandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import dao.VeiculoDAO;
import dominio.Veiculo;
import gui.CadastraVeiculoAct;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Veiculo v = new Veiculo();
        v.setId("uiashusaiahsiah");
        v.setAno(2016);
        v.setCor("preto");
        v.setModelo("focus");
        v.setPlaca("oko-8798");
        v.setSenha("naonula");
        v.setLatitude(1.00000000);
        v.setLongitude(1.00000000);*/

        VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
        veiculoDAO.setContextUp(this);

        Veiculo v = veiculoDAO.buscarVeiculo("12345678890");

        Log.i("Veículo lat", Double.toString(v.getLatitude()));

        Button fab = (Button) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CadastraVeiculoAct.class);
                startActivity(i);
            }
        });

    }




}
