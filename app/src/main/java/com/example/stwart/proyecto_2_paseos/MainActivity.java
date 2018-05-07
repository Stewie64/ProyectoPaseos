package com.example.stwart.proyecto_2_paseos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre,et_fecha,et_hora,et_ubicacion,et_tipo,et_desc;
    Button bt_guardar,bt_mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data variables
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_fecha = (EditText) findViewById(R.id.et_fecha);
        et_hora = (EditText) findViewById(R.id.et_hora);
        et_ubicacion = (EditText) findViewById(R.id.et_ubicacion);
        et_tipo = (EditText) findViewById(R.id.et_tipo);
        et_desc = (EditText) findViewById(R.id.et_desc);

        //Buttons
        bt_guardar = (Button) findViewById(R.id.bt_guardar);
        bt_mostrar = (Button) findViewById(R.id.bt_mostrar);

        //Button Functions
        bt_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTrip(et_nombre.getText().toString(), et_fecha.getText().toString(),
                        et_hora.getText().toString(), et_ubicacion.getText().toString(),
                        et_tipo.getText().toString(), et_desc.getText().toString());
            }
        });
        bt_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Lista_Paseos.class));
            }
        });
    }


    //Saves a new trip in the database
    //Receives a name
    private void saveTrip(String name, String date, String hour, String location, String type,
                              String desc){
        BaseHelper helper = new BaseHelper(this, "PaseosDB",null,1);
        SQLiteDatabase  db = helper.getWritableDatabase();
        try{
            ContentValues c = new ContentValues();
            c.put("NOMBRE", name);
            c.put("FECHA", date);
            c.put("HORA", hour);
            c.put("UBICACION", location);
            c.put("TIPO", type);
            c.put("DESCRIPCION", desc);
            db.insert("Paseos",null,c);
            db.close();
            Toast.makeText(this,"Registro Insertado",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"Error: " + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
