package com.example.practica_5_listas;

public class AdaptadorMangas extends RecyclerView.Adapter<AdaptadorMangas.MangasViewHolder> {

    //Atributos de la clase
    private Mangas[] listaMangas;

    //Constructor de la clase con la lista de mangas
    public AdaptadorMangas(Mangas[] listaMangas) {
        this.listaMangas = listaMangas;
    }//Cierre AdaptadorMangas
}//Cierre AdaptadorMangas
