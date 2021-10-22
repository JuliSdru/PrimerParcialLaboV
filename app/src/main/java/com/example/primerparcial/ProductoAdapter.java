package com.example.primerparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends  RecyclerView.Adapter<ProductoViewHolder>{

    private List<Producto> productos;
    private  MainActivity mainActivity;

    public ProductoAdapter(List<Producto> productos, MainActivity mainActivity) {
        this.productos = productos;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_view, parent, false);
        ProductoViewHolder productViewHolder = new ProductoViewHolder(item,mainActivity);
        item.setOnClickListener(productViewHolder);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.setIndice(position);
        holder.nombre.setText(this.productos.get(position).getNameProduct());
        holder.precio.setText(this.productos.get(position).getPrice().toString());
        holder.cantidad.setText(this.productos.get(position).getCount().toString());
    }

    @Override
    public int getItemCount() {
        return  this.productos.size();
    }
}
