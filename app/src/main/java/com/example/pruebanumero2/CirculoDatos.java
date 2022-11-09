package com.example.pruebanumero2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class CirculoDatos extends AppCompatActivity {
    String rad1;
    String resul;
    EditText nombreProyecto , tipoFigura;
    EditText radiofinal;
    EditText resultadoFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_datos);
        Intent guante = getIntent();
        rad1 = guante.getStringExtra("radioApasar");
        resul = guante.getStringExtra("resultadoApasar");
        nombreProyecto=(EditText) findViewById(R.id.txtNombreProyecto);
        tipoFigura =(EditText) findViewById(R.id.txtTipoFigura);
        radiofinal = (EditText) findViewById(R.id.txtRadioCirculoFinal);
        resultadoFinal=(EditText) findViewById(R.id.txtCirculoResultadoArea);
        resultadoFinal.setText(resul);
        radiofinal.setText(rad1);

    }

    public void guardarProyecto(View view){
        radiofinal.setText(rad1);
        resultadoFinal.setText(resul);
        String nombreProject = nombreProyecto.getText().toString();
        String figuraType= tipoFigura.getText().toString();
        ConexionBD basedeDatos= new ConexionBD(this, "GuardarDatos",null,1);
        SQLiteDatabase editableDB = basedeDatos.getWritableDatabase();

        if(!nombreProject.isEmpty()){
            Cursor guardar = editableDB.rawQuery("select nombreproyecto, tipofigura, radio, area from proyectos where nombreproyecto LIKE '%" + nombreProject + "%'",null);
        }
        else {
            Toast.makeText(this, "Complete el campo de nombre de projecto", Toast.LENGTH_SHORT).show();
        }











        String projectName = nombreProyecto.getText().toString();
        String figureType = tipoFigura.getText().toString();
        String radio= rad1.getBytes(StandardCharsets.UTF_8).toString();
        String res = resul.getBytes(StandardCharsets.UTF_8).toString();








        ContentValues paqueteDeProyecto = new ContentValues();
        paqueteDeProyecto.put("nombreProyecto",projectName);
        paqueteDeProyecto.put("tipoFigura",figureType);
        paqueteDeProyecto.put("rad1",radio);
        paqueteDeProyecto.put("resultado",res);

        editableDB.insert("proyectos",null,paqueteDeProyecto);
        editableDB.close();
        Toast.makeText(this, "Tabla Creada Correctamente", Toast.LENGTH_LONG).show();

    }


}