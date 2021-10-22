package com.example.primerparcial;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionHttp {

    public String obtenerRespuesta(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            if(200 == urlConnection.getResponseCode()) {

                InputStream is = urlConnection.getInputStream();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int lenght = 0; //para leer lo que
                while((lenght = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, lenght);
                }

                is.close();

                return baos.toString();
            } else {
                throw new RuntimeException("Error" + urlConnection.getResponseCode());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}