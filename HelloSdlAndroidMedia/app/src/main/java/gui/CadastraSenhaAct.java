package gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.applink.ford.hellosdlandroid.R;
import com.applink.ford.hellosdlandroid.Session;

public class CadastraSenhaAct extends Activity {


    private EditText senha;
    private EditText confirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_senha);

        Button btnProx = (Button) findViewById(R.id.proximo_button);

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificaSenha()) {
                    Intent i = new Intent(CadastraSenhaAct.this, ConfirmaCadastroAct.class);
                    startActivity(i);
                    Session.getVeiculo().setSenha(senha.getText().toString());
                    finish();
                }
            }
        });

    }

    private boolean verificaSenha(){

        senha = (EditText) findViewById(R.id.field_senha);
        confirmacao = (EditText) findViewById(R.id.field_confirma_senha);

        String strSenha = senha.getText().toString();
        String strConfirmacao = confirmacao.getText().toString();
        if (!(strConfirmacao.isEmpty() || strSenha.isEmpty())){
            return strSenha.equals(strConfirmacao);
        }else if ((strConfirmacao.isEmpty() || strSenha.isEmpty())){
            Toast.makeText(CadastraSenhaAct.this,"Campos Obrigatórios!",Toast.LENGTH_LONG).show();
            return false;
        }else{
            Toast.makeText(CadastraSenhaAct.this,"As senhas são diferentes!",Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
