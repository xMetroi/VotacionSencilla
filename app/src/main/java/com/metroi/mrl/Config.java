package com.metroi.mrl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class Config extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        TextView txtnombreMC1 = findViewById(R.id.txtnombreMC1);
        TextView txtnombreMC2 = findViewById(R.id.txtnombreMC2);
        EditText txtEntradas = findViewById(R.id.txtnumeroEntradas);
        EditText txtDiferencia = findViewById(R.id.txtdiferenciaPuntos);
    }

    public void cambioActivity(View view) {

        //Declaramos los campos
        TextView txtnombreMC1 = findViewById(R.id.txtnombreMC1);
        TextView txtnombreMC2 = findViewById(R.id.txtnombreMC2);
        EditText txtEntradas = findViewById(R.id.txtnumeroEntradas);
        EditText txtDiferencia = findViewById(R.id.txtdiferenciaPuntos);

        String nombreMC1 = txtnombreMC1.getText().toString();
        String nombreMC2 = txtnombreMC2.getText().toString();

        //Si ninguno de los campos está vacio:
        if (!(txtnombreMC1.getText().toString().isEmpty() || txtnombreMC2.getText().toString().isEmpty() || txtEntradas.getText().toString().isEmpty() || txtDiferencia.getText().toString().isEmpty())) {
            int entradas = Integer.parseInt(txtEntradas.getText().toString());
            double diferencia = Double.parseDouble(txtDiferencia.getText().toString());

            /* Hacemos un intent para mandar los datos de la pantalla de Config a la pantalla de
            cuatro por cuatro */
            Intent i = new Intent(Config.this, cuatroporcuatro.class);
            i.putExtra("nombreMC1", nombreMC1);
            i.putExtra("nombreMC2", nombreMC2);
            i.putExtra("entradas", entradas);
            i.putExtra("diferenciaPuntos", diferencia);

            startActivity(i);
        }

        else {
            //Si hay algun campo vacío que muestre un mensaje diciendole al usuario que por favor rellene todos los campos.
            Toast toast=Toast. makeText(getApplicationContext(),"Por favor, rellene todos los campos",Toast. LENGTH_SHORT);
            toast. show();
        }


    }

}