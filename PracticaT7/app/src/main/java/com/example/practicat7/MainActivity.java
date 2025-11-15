package com.example.practicat7;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

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

        //Declaración de los objetos a utilizar en el reproductor
        MediaPlayer mp = MediaPlayer.create(this, R.raw.suicide_tuesday);
        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnPause = findViewById(R.id.btnPause);
        SeekBar sbProgreso = findViewById(R.id.sbProgreso);
        TextView tvTiempoActual = findViewById(R.id.tvTiempoActual);
        TextView tvTiempoTotal = findViewById(R.id.tvTiempoTotal);
        TextView tvTitulo = findViewById(R.id.tvTitulo);

        //Declaración de los objetos a utilizar en el soundpool (en realidad, solo botones)
        Button btnSonido1 = findViewById(R.id.btnSonido1);
        Button btnSonido2 = findViewById(R.id.btnSonido2);
        Button btnSonido3 = findViewById(R.id.btnSonido3);
        Button btnSonido4 = findViewById(R.id.btnSonido4);


        //Ponemos el título de la caja de texto
        tvTitulo.setText(getResources().getResourceEntryName(R.raw.suicide_tuesday));

        //Hacemos que los botones de play y pause sean útiles para su cometido
        btnPlay.setOnClickListener(v -> mp.start());
        btnPause.setOnClickListener(v -> mp.pause());

        //Hacemos que las etiquetas de texto tengan los tiempos (el tiempo que pasa y el total)
        mp.setOnPreparedListener(mp1 -> {
            sbProgreso.setMax(mp.getDuration());
            int minutosTotales = mp.getDuration() / 1000 / 60;
            int segundosTotales = mp.getDuration() / 1000 % 60;

            String tiempoTotal = String.format("%02d:%02d", minutosTotales, segundosTotales);
            tvTiempoTotal.setText(tiempoTotal);

            tvTiempoActual.setText("0:00");
        });//Cierre setOnPreparedListener

        //Actualizamos el progreso de la canción cada segundo
        Handler handler = new Handler();

        Runnable actualizar = new Runnable() {
            @Override
            public void run() {
                sbProgreso.setProgress(mp.getCurrentPosition());

                int mins = mp.getCurrentPosition() / 1000 / 60;
                int segs = mp.getCurrentPosition() / 1000 % 60;

                String tiempo = String.format("%02d:%02d", mins, segs);
                tvTiempoActual.setText(tiempo);

                //Actualización cada segundo
                handler.postDelayed(this, 1000);
            }//Cierre run
        };//Cierre Interfaz Runnable

        handler.post(actualizar);

        //Permitimos al usuario mover la barra de progreso
        sbProgreso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //Código para el cambio de segundo de la canción
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                }//Cierre if

            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });//Cierre setOnSeekBarChangeListener

        //Reproductor de sonidos

        //Declaración del soundpool
        SoundPool sp = new SoundPool.Builder().setMaxStreams(10).build();

        //Cargo los sonidos a reproducir en memoria
        int sonido1 = sp.load(this, R.raw.bomb_has_been_planted, 1);
        int sonido2 = sp.load(this, R.raw.cave, 1);
        int sonido3 = sp.load(this, R.raw.classic_hurt, 1);
        int sonido4 = sp.load(this, R.raw.round, 1);

        //Definimos el accionamiento de los botones
        btnSonido1.setOnClickListener(v -> sp.play(sonido1, 1, 1, 1, 0, 1));
        btnSonido2.setOnClickListener(v -> sp.play(sonido2, 1, 1, 1, 0, 1));
        btnSonido3.setOnClickListener(v -> sp.play(sonido3, 1, 1, 1, 0, 1));
        btnSonido4.setOnClickListener(v -> sp.play(sonido4, 1, 1, 1, 0, 1));


    }//Cerre onCreate
}//Cierre MainActivity