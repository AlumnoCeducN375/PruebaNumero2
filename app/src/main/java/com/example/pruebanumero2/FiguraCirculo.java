package com.example.pruebanumero2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FiguraCirculo extends AppCompatActivity {


    private EditText rad1;
    private int radCuadrado;
    private TextView resu;
    private Double PI;
    private int numeroAlCuadrado;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figura_circulo);

        rad1=(EditText)findViewById(R.id.txtRadioCirculo);
        resu=(TextView)findViewById(R.id.txtResultadoCirculo);
        PI=3.14;
        radCuadrado=0;
        numeroAlCuadrado=2;


    }





    public void CalcularArea(View view) {
        double radCuadrado = Math.pow(Double.parseDouble(rad1.getText().toString()), Double.parseDouble(String.valueOf(numeroAlCuadrado)));
        double calcularArea = PI * radCuadrado;
        resu.setText("el area de la circunferencia es " + calcularArea + "cm2");
    }

    public void botonGuardarDatos(View view){






        Intent cambiarAGuardar= new Intent(this, CirculoDatos.class);
        cambiarAGuardar.putExtra("radioApasar",rad1.getText().toString());
        cambiarAGuardar.putExtra("resultadoApasar",resu.getText().toString());
        startActivity(cambiarAGuardar);

    }




}