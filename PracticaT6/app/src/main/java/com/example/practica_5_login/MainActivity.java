package com.example.practica_5_login;

import android.content.Intent;
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
        sRecordar = findViewById(R.id.sRecordar);

        //Definición de los intent
        Intent intent = getIntent();
        Intent intentCambiar = new Intent(this, ActivityMenu.class);

        //Booleano que limpa las cajas de texto
        //Lo obtengo de la otra actividad (ActivityMain)
        boolean limpiar = intent.getBooleanExtra("LIMPIAR", false);

        //Si limpiar es verdadero, modifico el texto en ambas cajas por texto nulo
        if (limpiar) {
            tCorreo.setText("");
            tContraseña.setText("");
        }//Cierre if

        //Hago que el texto de la pestaña de bienvenida sea el del correo

        //Código a ejecutar al clicar el botón continuar
        bContinuar.setOnClickListener(v -> {

            //Obtiene el contenido de los campos de texto
            String correo = tCorreo.getText().toString();
            String contraseña = tContraseña.getText().toString();

            //Si los campos coinciden con los valores designados da un mensaje de bienvenida
            if (correo.equals("correo@correo.com") && contraseña.equals("123")) {

                //Empezar actividad de cambio
                intentCambiar.putExtra("CORREO", correo);
                startActivity(intentCambiar);

                //Cambio a color verde en caso de ser los datos correctos
                tvMensaje.setTextColor(getResources().getColor(R.color.green));
                //Da un mensaje u otro en función de si el switch está marcado
                if(sRecordar.isChecked()) {
                    tvMensaje.setText("Contraseña y correo correctos, bienvenido.\nSe han guardado tus datos de inicio de sesión.");
                } else {
                    tvMensaje.setText("Contraseña y correo correctos, bienvenido.");

                }//Cierre if-else

            } else {
                //Cambia el color del texto a rojo y da un mensaje de error
                tvMensaje.setTextColor(getResources().getColor(R.color.red));
                tvMensaje.setText("Contraseña y/o correo incorrectos, prueba de nuevo.");
            }//Cierre if - else
        }); //Cierre bContinuar
    }//Cierre onCreate
}//Cierre clase