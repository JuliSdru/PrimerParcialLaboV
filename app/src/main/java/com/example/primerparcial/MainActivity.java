package com.example.primerparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static List<Producto> products = new ArrayList<>();
    private List<Producto> listaProducto;
    private ProductoAdapter productoAdapter;

    private Producto producto;
    private int posicion;

    private Integer auxPos=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listaProducto = new ArrayList<Producto>();

        Handler handler = new Handler(this);
        EjecutarHttp miHilo = new EjecutarHttp(handler);
        miHilo.start();

       /* products.add(new Producto("Producto 1", 10 , 12.50));
        products.add(new Producto("Producto 2", 20 , 15.0));
        products.add(new Producto("Producto 3", 30 , 16.50));
        products.add(new Producto("Producto 4", 30 , 16.50));
        products.add(new Producto("Producto 5", 30 , 16.50));
        products.add(new Producto("Producto 6", 30 , 16.50));
        products.add(new Producto("Producto 7", 30 , 16.50));
        products.add(new Producto("Producto 8", 30 , 16.50));
        products.add(new Producto("Producto 9", 30 , 16.50));
        products.add(new Producto("Producto 10", 30 , 16.50));
        products.add(new Producto("Producto 11", 30 , 16.50));
        products.add(new Producto("Producto 12", 30 , 16.50));


        this.productoAdapter= new ProductoAdapter(products,this);
        RecyclerView rb = findViewById(R.id.reciclerView);
        rb.setAdapter(this.productoAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rb.setLayoutManager(linearLayoutManager);

        //ActionBar ab = getSupportActionBar();
        //ab.setTitle(R.string.app_name);
*/

    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {

        List<Producto> lista = (List<Producto>)  msg.obj;

        this.listaProducto = lista;


        RecyclerView recyclerView = findViewById(R.id.reciclerView);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);


        ProductoAdapter productoAdapter = new ProductoAdapter(listaProducto, this);
        this.productoAdapter = productoAdapter;
        recyclerView.setAdapter(this.productoAdapter);
        return false;
    }


    public void startEditActivity( Integer pos ){
        Log.d("click","click item" + pos );
         this.auxPos = pos;
         Intent i = new Intent(this, Edit_activity.class);
         i.putExtra("Posicion",pos);
         startActivity(i);
    }



/*
   public void actualizaAdapter( Integer id){
        this.productoAdapter.notifyItemChanged(id);
    }

    @Override
    protected void onResume() {
        this.actualizaAdapter(this.auxPos);
        super.onResume();
    }*/
/*
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
*/
    /*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if( item.getItemId()== R.id.add){
            Log.d("asd","click add");

        }
        return super.onOptionsItemSelected(item);
    }


   @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }*/


}