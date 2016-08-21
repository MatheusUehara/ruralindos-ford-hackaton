package gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.applink.ford.hellosdlandroid.R;

public class FirstLoginAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login);


        Button prox = (Button) findViewById(R.id.proximo_button);

        prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstLoginAct.this, CadastraVeiculoAct.class);
                startActivity(i);
            }
        });
    }
}
