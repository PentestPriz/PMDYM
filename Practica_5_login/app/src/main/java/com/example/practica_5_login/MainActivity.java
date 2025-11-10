package com.example.practica_5_login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText tCorreo;

    private EditText tContraseña;

    private Button bContinuar;

    private Switch sRecordar;

    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Encuentro los elementos por su id
        tCorreo = findViewById(R.id.etCorreo);
        tContraseña = findViewById(R.id.etContraseña);
        bContinuar = findViewById(R.id.bContinuar);
        sRecordar = findViewById(R.id.sRecordar);
        tvMensaje = findViewById(R.id.tvMensaje);

        //Código a ejecutar al clicar el botón continuar
        bContinuar.setOnClickListener(v -> {

            //Obtiene el contenido de los campos de texto
            String correo = tCorreo.getText().toString();
            String contraseña = tContraseña.getText().toString();

            //Si los campos coinciden con los valores designados da un mensaje de bienvenida
            if (correo.equals("correo@correo.com") && contraseña.equals("psw")) {
                tvMensaje.setText("Contraseña y correo correctos, bienvenido.");
            }//Cierre if
        });
    }//Cierre onCreate
}//Cierre clase