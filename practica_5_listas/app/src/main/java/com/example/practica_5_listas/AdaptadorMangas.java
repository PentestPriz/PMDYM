package com.example.practica_5_listas;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public abstract class AdaptadorMangas extends RecyclerView.Adapter<AdaptadorMangas.MangasViewHolder> {

    //Atributos de la clase
    private Mangas[] listaMangas;

    //Constructor de la clase con la lista de mangas
    public AdaptadorMangas(Mangas[] listaMangas) {
        this.listaMangas = listaMangas;
    }//Cierre AdaptadorMangas

    //Creación ViewHolder
    public static class MangasViewHolder extends RecyclerView.ViewHolder {

        //Atributos de la clase
        public ImageView imagenView;
        public TextView tituloView;
        private Context context;

        public MangasViewHolder(View view, Context context) {
            super(view);
            this.context = context;

            tituloView = view.findViewById(R.id.tituloView);
            imagenView = view.findViewById(R.id.imagenView);
        }//Cierre MangasViewHolder

        //Cierre BindMangas
        public void BindMangas(Mangas manga) {
            tituloView.setText(manga.titulo);

            imagenView.setImageResource(
                    context.getResources()
                            .getIdentifier(manga.imagen,
                                    "drawable",
                                    context.getPackageName()));
        }//Cierre BindMangas

    }//Cierre mangasViewHolder

}//Cierre AdaptadorMangas
