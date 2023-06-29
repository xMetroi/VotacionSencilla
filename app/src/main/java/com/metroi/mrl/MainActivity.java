package com.metroi.mrl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Cambiamos a la pantalla de configuración de votación
    public void config(View view) {
        Intent intent = new Intent(MainActivity.this, Config.class);
        startActivity(intent);
    }
}