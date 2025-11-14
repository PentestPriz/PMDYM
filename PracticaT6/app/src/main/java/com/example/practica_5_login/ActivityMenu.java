package com.example.practica_5_login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityMenu extends AppCompatActivity {

    //Definición de los elementos del layout
    private Button btnDesconectar;

    private TextView tvMostrarCorreo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activitymenu), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Encuentro los elementos por su id
        btnDesconectar = findViewById(R.id.btnDesconectar);
        tvMostrarCorreo = findViewById(R.id.tvMostrarCorreo);

        //Acción que se ejecuta al pulsar el botón de desconectar
        btnDesconectar.setOnClickListener(v -> {

            //Hago al usuario volver a la pantalla de inicio mediante un intent
            Intent intent = new Intent(this, MainActivity.class);

            //Envio datos a la otra actividad (en este caso para limpiar el contenido de las cajas de texto)
            intent.putExtra("LIMPIAR", true);

            //Empezar la otra actividad
            startActivity(intent);
            finish();

        });
    }
}