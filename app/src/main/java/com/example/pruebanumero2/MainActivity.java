package com.example.pruebanumero2;

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

    public void cambiarCirculo(View view)
    {
        Intent cambiarCirc = new Intent(this, FiguraCirculo.class);
        startActivity(cambiarCirc);
    }

    public void cambiarCuadrado(View view)
    {
        Intent cambiarCuad = new Intent(this, FiguraCuadrado.class);
        startActivity(cambiarCuad);
    }

    public void cambiarTriangulo(View view)
    {
        Intent cambiarTrian = new Intent(this, FiguraTriangulo.class);
        startActivity(cambiarTrian);
    }
}