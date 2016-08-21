package gui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.applink.ford.hellosdlandroid.MainActivity;
import com.applink.ford.hellosdlandroid.R;

public class SplashAct extends Activity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                if (sp.getInt("flag",0) == 0) {
                    // TODO INICIAR FRAGMENT DE CADASTRO
                    Intent i = new Intent(SplashAct.this,FirstLoginAct.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(SplashAct.this,MainActivity.class);
                    startActivity(i);
                }
            }
        }, 3000);

    }

}
