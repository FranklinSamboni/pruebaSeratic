package com.example.frank.boletic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.frank.boletic.eventos.MainActivity;
import com.example.frank.boletic.login_register.LoginActivity;

/**
 * Created by FRANK on 2/09/2017.
 */

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadFirst();
    }

    private void loadFirst() {

        SharedPreferences preference = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        boolean sesion = preference.getBoolean("Sesion",false);

        if(!sesion){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }


    }


}
