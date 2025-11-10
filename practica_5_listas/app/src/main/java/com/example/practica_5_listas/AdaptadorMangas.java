package com.example.practica_5_listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorMangas extends RecyclerView.Adapter<AdaptadorMangas.MangasViewHolder> {

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

    //Modificación del metodo onCreateViewHolder
    @NonNull
    @Override
    public MangasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_mangas, parent, false);

        return new MangasViewHolder(view, parent.getContext());

    }//Cierre onCreateViewHolder

    //Modificación de onBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull MangasViewHolder holder, int position) {
        holder.BindMangas(listaMangas[position]);
    }//Cierre onBindViewHolder

    //Modificación del metodo getItemCount
    @Override
    public int getItemCount() {
        return listaMangas.length;
    }//Cierre getItemCount

}//Cierre AdaptadorMangasS
