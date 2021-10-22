package com.example.primerparcial;


import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EjecutarHttp extends Thread {
    public Handler handler;

    public EjecutarHttp(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run(){

        ConexionHttp con = new ConexionHttp();
        String json = con.obtenerRespuesta("http://localhost:3000/productos");

        Message mensaje = new Message();
        try {
            mensaje.obj = generarListaString(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.handler.sendMessage(mensaje);
    }

    private List<Producto> generarListaString(String json) throws JSONException {
        List<Producto> productos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);


        for(int i=0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

            Producto prod = new Producto();
            prod.setNameProduct(object.getString("name"));
            prod.setPrice(object.getDouble("price"));
            prod.setCount(object.getInt("count"));
            productos.add(prod);
            Log.d("data",object.getString("name") );
        }
        return productos;
    }


}