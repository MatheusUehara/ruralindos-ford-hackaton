package com.applink.ford.hellosdlandroid;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Double2;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import dao.VeiculoDAO;
import dominio.Veiculo;

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

        Veiculo v = veiculoDAO.buscarVeiculo("uiashusaiahsiah");

        Log.i("Veículo lat", Double.toString(v.getLatitude()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
