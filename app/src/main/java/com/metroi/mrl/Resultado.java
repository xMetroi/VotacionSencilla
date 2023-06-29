package com.metroi.mrl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Se obtienen los valores que fueron enviados de la clase anterior
        Bundle extras = getIntent().getExtras();

        String nombreMC1 = extras.getString("snombreMC1");
        String nombreMC2 = extras.getString("snombreMC2");
        double puntajemc1 = extras.getDouble("puntajeMC1");
        double puntajemc2 = extras.getDouble("puntajeMC2");
        double diferenciaDefinida = extras.getDouble("diferenciaPuntos");

        //Se inicializa el valor de diferencia
        double diferencia = 0;

        /*
        Hacemos esta verificación para que el valor de la diferencia no sea entre los dos puntajes
        no sea negativo
        Si el valor de puntajemc1 es mayor a puntajemc2, que se reste puntajemc1 menos puntajemc2
        ya que es el numero mayor. Esto evita una diferencia negativa.
         */
        if ( puntajemc1 > puntajemc2) {
            diferencia = puntajemc1 - puntajemc2;
            TextView txtDiferencia = (TextView) findViewById(R.id.txtDiferencia);
            txtDiferencia.setText(String.valueOf(diferencia));
        }

        /*
        Si el valor de puntajemc2 es mayor a puntajemc1, que se reste puntajemc2 menos puntajemc1
        ya que es el numero mayor. Esto evita una diferencia negativa.
         */
        if ( puntajemc2 > puntajemc1) {
            diferencia = puntajemc2 - puntajemc1;
            TextView txtDiferencia = (TextView) findViewById(R.id.txtDiferencia);
            txtDiferencia.setText(String.valueOf(diferencia));
        }


        TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
        TextView txtnombreMC1 = (TextView) findViewById(R.id.txtRnombreMC1);
        TextView txtnombreMC2 = (TextView) findViewById(R.id.txtRnombreMC2);
        TextView txtPuntajeMC1 = (TextView) findViewById(R.id.txtRpuntajeMC1);
        TextView txtPuntajeMC2 = (TextView) findViewById(R.id.txtRpuntajeMC2);

        txtnombreMC1.setText(nombreMC1);
        txtnombreMC2.setText(nombreMC2);

        txtPuntajeMC1.setText(String.valueOf(puntajemc1));
        txtPuntajeMC2.setText(String.valueOf(puntajemc2));

        //Si el valor de la diferencia es menor o igual a la diferencia definida será una Replica
        if ( diferencia  <= diferenciaDefinida) {
            txtResultado.setText("REPLICA");
        }

        //Si el valor de la diferencia es mayor a la diferencia definida hay un ganador
        else if ( diferencia > diferenciaDefinida) {
            //Si el puntaje del mc1 es mayor al del mc2, el mc 1 es el ganador
            if (puntajemc1 > puntajemc2) {
                txtResultado.setText(nombreMC1);
            }
            //Sino, el ganador es el mc2
            else {
                txtResultado.setText(nombreMC2);
            }
        }

    }

    //Damos funcionalidad al botón para volver al inicio.
    public void volverInicio(View view) {
        Intent intent = new Intent(Resultado.this, MainActivity.class);
        startActivity(intent);
    }

}