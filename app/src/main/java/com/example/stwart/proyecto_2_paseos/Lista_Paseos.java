package com.example.stwart.proyecto_2_paseos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.goodiebag.carouselpicker.CarouselPicker;


public class Lista_Paseos extends AppCompatActivity {

    ListView lv_datos;
    CarouselPicker carouselWalks,carouselBeachTrips,carouselMountainTrips,carouselRecreationalEvents,carouselMotorcycleTours,carouselCarTours,
            carouselSocialEvents,carouselConcerts,carouselCharityEvents;
    ArrayList<String> listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__paseos);
        lv_datos = (ListView) findViewById(R.id.lv_datos);
        carouselWalks = findViewById((R.id.carouselWalks));
        carouselBeachTrips =findViewById((R.id.carouselBeachTrips));
        carouselMountainTrips = findViewById((R.id.carouselMountainTrips));
        carouselRecreationalEvents = findViewById((R.id.carouselRecreationalEvents));
        carouselMotorcycleTours = findViewById((R.id.carouselMotorcycleTours));
        carouselCarTours = findViewById((R.id.carouselCarTours));
        carouselSocialEvents = findViewById((R.id.carouselSocialEvents));
        carouselConcerts = findViewById((R.id.carouselConcerts));
        carouselCharityEvents = findViewById((R.id.carouselCharityEvents));
        cargarPaseos();
    }

    private void cargarPaseos(){
        listado = listaPersonas();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listado);
        lv_datos.setAdapter(adapter);
    }
    private void tripSeparation(){

    }

    private ArrayList<String> listaPersonas(){
        ArrayList<String> datos = new ArrayList<String>();
        BaseHelper helper = new BaseHelper(this, "PaseosDB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select NOMBRE, FECHA, HORA, UBICACION, TIPO, DESCRIPCION from Paseos";
        Cursor c = db.rawQuery(sql,null);
        try {
            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(0) + " " + c.getString(1) + " " +
                            c.getString(2) + " " + c.getString(3) + " " +
                            c.getString(4) + " " + c.getString(5);
                    datos.add(linea);
                } while (c.moveToNext());
            }
            db.close();
        }catch (Exception e){
            Toast.makeText(this,"Error: " + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return datos;
    }
}
