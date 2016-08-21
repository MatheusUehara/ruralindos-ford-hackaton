package gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.applink.ford.hellosdlandroid.MainActivity;
import com.applink.ford.hellosdlandroid.R;
import com.applink.ford.hellosdlandroid.Session;

import dao.VeiculoDAO;

public class ConfirmaCadastroAct extends Activity {

    VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_cadastro);

        Button btnProx = (Button) findViewById(R.id.proximo_button);

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veiculoDAO.setContextUp(ConfirmaCadastroAct.this);
                Session.getVeiculo().setId("12345678890");
                veiculoDAO.adicionar(Session.getVeiculo());
                //TODO IMPLEMENTAR METODO DE VALIDAÇÃO DOS CAMPOS
                Intent i =  new Intent(ConfirmaCadastroAct.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
