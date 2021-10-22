package com.example.primerparcial;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView nombre;
    public TextView cantidad;
    public TextView precio;
    public Integer indice;
    private  MainActivity activity;

    public ProductoViewHolder(@NonNull View itemView, MainActivity activity) {
        super(itemView);
        this.activity = activity;
        this.nombre=itemView.findViewById(R.id.nameProduct);
        this.cantidad=itemView.findViewById(R.id.cantidad);
        this.precio=itemView.findViewById(R.id.precio);


    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }


    @Override
    public void onClick(View v) {
        this.activity.startEditActivity(this.indice);

    }
}
