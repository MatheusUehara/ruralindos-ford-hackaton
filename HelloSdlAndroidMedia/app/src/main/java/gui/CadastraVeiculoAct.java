package gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.applink.ford.hellosdlandroid.R;
import com.applink.ford.hellosdlandroid.Session;

import dominio.Veiculo;

public class CadastraVeiculoAct extends Activity {

    EditText fieldModelo,fieldAno, fieldPlaca,fieldCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_veiculo);

        Button btnProx = (Button) findViewById(R.id.proximo_button);

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastraVeiculo();
                Intent i =  new Intent(CadastraVeiculoAct.this, CadastraSenhaAct.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void cadastraVeiculo(){
        fieldModelo = (EditText) findViewById(R.id.field_modelo);
        fieldAno = (EditText) findViewById(R.id.field_ano);
        fieldPlaca = (EditText) findViewById(R.id.field_placa);
        fieldCor = (EditText) findViewById(R.id.field_cor);

        Veiculo veiculo = Session.getVeiculo();
        veiculo.setModelo(fieldModelo.getText().toString());
        veiculo.setAno(Integer.parseInt(fieldAno.getText().toString()));
        veiculo.setPlaca(fieldPlaca.getText().toString());
        veiculo.setCor(fieldCor.getText().toString());
    }
}
