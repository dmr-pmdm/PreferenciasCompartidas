package com.example.preferenciascompartidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnGuardar,btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = findViewById(R.id.guardar);
        btnRecuperar = findViewById(R.id.recuperar);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        final SharedPreferences.Editor editor = prefs.edit();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("email", "dani@email.com");
                editor.putString("nombre", "Dani");
                editor.apply();

            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo=prefs.getString("email", "email_defectivo@email.com");
                String nombre=prefs.getString("nombre","cualquiera");
                Log.i("Preferencias","Correo: "+correo);


            }
        });
    }
}
