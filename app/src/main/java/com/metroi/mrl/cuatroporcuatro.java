package com.metroi.mrl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class cuatroporcuatro extends AppCompatActivity {

    //Inicializamos las variables
    int entradasmc1 = 0;
    int entradasmc2 = 0;
    double puntajemc1 = 0;
    double puntajemc2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuatroporcuatro);

        //Aquí escondemos el botón de ver resultados para poder mostrarlo a proposito más adelante
        Button btnverResultados = (Button) findViewById(R.id.btnResultados);
        btnverResultados.setVisibility(View.INVISIBLE);

        //Obtenemos los valores que pasamos de la ventana de Config
        Bundle extras = getIntent().getExtras();
        String snombreMC1 = extras.getString("nombreMC1");
        String snombreMC2 = extras.getString("nombreMC2");
        TextView nombreMC1 = (TextView) findViewById(R.id.nombreMC1);
        TextView nombreMC2 = (TextView) findViewById(R.id.nombreMC2);
        nombreMC1.setText(String.valueOf(snombreMC1));
        nombreMC2.setText(String.valueOf(snombreMC2));

        TextView cantidadEntradas1 = (TextView) findViewById(R.id.cantidadEntradas);
        TextView cantidadEntradas2 = (TextView) findViewById(R.id.cantidadEntradas2);
        int cantidadEntradas = extras.getInt("entradas");
        cantidadEntradas1.setText(Integer.toString(cantidadEntradas));
        cantidadEntradas2.setText(Integer.toString(cantidadEntradas));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));
        txtPuntaje2mc.setText(Double.toString(puntajemc2));


    }

    //Hacemos la funcionalidad del botón de sumar entrada del MC1
    public void sumarEntradaMC1(View view) {
        entradasmc1++;
        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    //Hacemos la funcionalidad del botón de sumar entrada del MC2
    public void sumarEntradaMC2(View view) {
        entradasmc2++;
        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    //Hacemos la funcionalidad del botón de restar entrada del MC1
    public void restarEntradaMC1(View view) {
        entradasmc1--;
        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    //Hacemos la funcionalidad del botón de restar entrada del MC2
    public void restarEntradaMC2(View view) {
        entradasmc2--;
        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));
        checkEntradasMC2();
    }

    //Hacemos un método para comprobar las entradas del MC1
    public void checkEntradasMC1(){
        //Declaramos los campos
        Button CuatroMC1 = (Button) findViewById(R.id.btnCuatroMC1);
        Button TresMC1 = (Button) findViewById(R.id.btnTresMc1);
        Button DosMC1 = (Button) findViewById(R.id.btnDosMc1);
        Button UnoMC1 = (Button) findViewById(R.id.btnUnoMc1);
        Button CeroMC1 = (Button) findViewById(R.id.btnCeroMc1);
        //Obtenemos el valor de la variable entradas para saber cuantas entradas tendrá la batalla
        Bundle extras = getIntent().getExtras();
        int cantidadEntradas = extras.getInt("entradas");

        /*
        Si la cantidad de entradas del MC1 es igual a la cantidad de entradas total de la batalla
        se desactivarán los botones de sumar
         */
        if (entradasmc1 == cantidadEntradas) {
            CuatroMC1.setEnabled(false);
            TresMC1.setEnabled(false);
            DosMC1.setEnabled(false);
            UnoMC1.setEnabled(false);
            CeroMC1.setEnabled(false);
        }

        else if (entradasmc1 < cantidadEntradas) {
            CuatroMC1.setEnabled(true);
            TresMC1.setEnabled(true);
            DosMC1.setEnabled(true);
            UnoMC1.setEnabled(true);
            CeroMC1.setEnabled(true);
        }

        /*
        Si el valor de entradasmc1 supera el valor de la cantidad de entradas total se reiniciará
        al valor de cantidad de entradas
         */
        else if (entradasmc1 >= cantidadEntradas) {

            entradasmc1 = cantidadEntradas;

            TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
            txtEntradasMc1.setText(Integer.toString(entradasmc1));
        }

        //Se evita que el valor de entradas de mc1 sea negativo
        if (entradasmc1 < 0) {

            entradasmc1 = 0;

            TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
            txtEntradasMc1.setText(Integer.toString(entradasmc1));
        }

        if ( puntajemc1 <  0 || puntajemc2 < 0)  {
            puntajemc1 = 0;
            puntajemc2 = 0;

            TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
            txtPuntaje1mc.setText(Double.toString(puntajemc1));

        }

        checkFinal();

    }

    //Se hace lo mismo que en checkEntradasMC1
    public void checkEntradasMC2(){
        Button CuatroMC2 = (Button) findViewById(R.id.btnCuatroMC2);
        Button TresMC2 = (Button) findViewById(R.id.btnTresMC2);
        Button DosMC2 = (Button) findViewById(R.id.btnDosMc2);
        Button UnoMC2 = (Button) findViewById(R.id.btnUnoMC2);
        Button CeroMC2 = (Button) findViewById(R.id.btnCeroMc2);
        Bundle extras = getIntent().getExtras();
        int cantidadEntradas = extras.getInt("entradas");

        if (entradasmc2 == cantidadEntradas) {
            CuatroMC2.setEnabled(false);
            TresMC2.setEnabled(false);
            DosMC2.setEnabled(false);
            UnoMC2.setEnabled(false);
            CeroMC2.setEnabled(false);
        }

        else if (entradasmc2 < cantidadEntradas) {
            CuatroMC2.setEnabled(true);
            TresMC2.setEnabled(true);
            DosMC2.setEnabled(true);
            UnoMC2.setEnabled(true);
            CeroMC2.setEnabled(true);
        }

        else if (entradasmc2 >= cantidadEntradas) {

            entradasmc2 = cantidadEntradas;

            TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
            txtEntradasMc2.setText(Integer.toString(entradasmc2));
        }

        if (entradasmc2 < 0) {

            entradasmc2 = 0;

            TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
            txtEntradasMc1.setText(Integer.toString(entradasmc1));
        }

        if ( puntajemc1 <  0 || puntajemc2 < 0)  {
            puntajemc1 = 0;
            puntajemc2 = 0;

            TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
            txtPuntaje2mc.setText(Double.toString(puntajemc2));

        }

        checkFinal();

    }

    /*
    Se le da funcionalidad a cada uno de los botones para votar. Ya sea sumando o restando el
    puntaje total
     */
    public void votoCuatroMC1(View view) {
        puntajemc1 += 4;
        entradasmc1++;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoTresMC1(View view) {
        puntajemc1 += 3;
        entradasmc1++;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoDosMC1(View view) {
        puntajemc1 += 2;
        entradasmc1++;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoUnoMC1(View view) {
        puntajemc1 += 1;
        entradasmc1++;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoCeroCincoMC1(View view) {
        puntajemc1 += 0.5;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoMenosCuatroMC1(View view) {
        puntajemc1 -= 4;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoMenosTresMC1(View view) {
        puntajemc1 -= 3;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoMenosDosMC1(View view) {
        puntajemc1 -= 2;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoMenosUnoMC1(View view) {
        puntajemc1 -= 1;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoMenosCeroCincoMC1(View view) {
        puntajemc1 -= 0.5;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoCeroMC1(View view) {
        entradasmc1++;

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        txtPuntaje1mc.setText(Double.toString(puntajemc1));

        TextView txtEntradasMc1 = (TextView) findViewById(R.id.txtEntradasMc1);
        txtEntradasMc1.setText(Integer.toString(entradasmc1));

        checkEntradasMC1();
    }

    public void votoCuatroMC2(View view) {
        puntajemc2 += 4;
        entradasmc2++;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoTresMC2(View view) {
        puntajemc2 += 3;
        entradasmc2++;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoDosMC2(View view) {
        puntajemc2 += 2;
        entradasmc2++;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoUnoMC2(View view) {
        puntajemc2 += 1;
        entradasmc2++;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoCeroCincoMC2(View view) {
        puntajemc2 += 0.5;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }


    public void votoCeroMC2(View view) {
        entradasmc2++;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoMenosCuatroMC2(View view) {
        puntajemc2 -= 4;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoMenosTresMC2(View view) {
        puntajemc2 -= 3;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoMenosDosMC2(View view) {
        puntajemc2 -= 2;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoMenosUnoMC2(View view) {
        puntajemc2 -= 1;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void votoMenosCeroCincoMC2(View view) {
        puntajemc2 -= 0.5;

        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        txtPuntaje2mc.setText(Double.toString(puntajemc2));

        TextView txtEntradasMc2 = (TextView) findViewById(R.id.txtEntradasMc2);
        txtEntradasMc2.setText(Integer.toString(entradasmc2));

        checkEntradasMC2();
    }

    public void checkFinal() {

        //Se verifica el valor de la cantidad de entradas total
        Bundle extras = getIntent().getExtras();
        int cantidadEntradas = extras.getInt("entradas");

        /*
        /Si las entradas del mc 1 y mc 2 llegan al total de cantidad de entradas eso quiere decir
        que se terminó la batalla, habilitando así el botón de ver resultados.
         */
        if (entradasmc1 == cantidadEntradas && entradasmc2 == cantidadEntradas) {
            Button btnverResultados = (Button) findViewById(R.id.btnResultados);
            btnverResultados.setVisibility(View.VISIBLE);
        }

        else {
            Button btnverResultados = (Button) findViewById(R.id.btnResultados);
            btnverResultados.setVisibility(View.INVISIBLE);
        }
    }

    //Aquí se verifica toda la información y se guarda para enviarla a la ventana de resultado.
    public void verResultados(View view) {

        Bundle extras = getIntent().getExtras();
        String snombreMC1 = extras.getString("nombreMC1");
        String snombreMC2 = extras.getString("nombreMC2");
        double diferencia = extras.getDouble("diferenciaPuntos");

        TextView txtPuntaje1mc = (TextView) findViewById(R.id.txtPuntajemc1);
        double puntajeMC1A = Double.parseDouble((txtPuntaje1mc.getText().toString()));
        TextView txtPuntaje2mc = (TextView) findViewById(R.id.txtPuntajemc2);
        double puntajeMC2A = Double.parseDouble((txtPuntaje2mc.getText().toString()));

        Intent i = new Intent(cuatroporcuatro.this, Resultado.class);

        i.putExtra("snombreMC1", snombreMC1);
        i.putExtra("snombreMC2", snombreMC2);
        i.putExtra("puntajeMC1", puntajeMC1A);
        i.putExtra("puntajeMC2", puntajeMC2A);
        i.putExtra("diferenciaPuntos", diferencia);

        startActivity(i);
    }

}