package com.example.primerparcial;

import android.widget.Button;

public class ProductoControler {

    ProductoView view;

    public ProductoControler( ProductoView view ) {
        this.view = view;
    }

    public void setValoresIniciales(){
        this.view.CompletarValores();
    }

    public void getValores(){
        this.view.ObtenerValores();
    }

    public void setListenerEdit(Edit_activity edit_activity){
        OnClickEdit listener = new OnClickEdit(this,edit_activity);
        Button btn_guardar = edit_activity.findViewById(R.id.buttonEdit);
        btn_guardar.setOnClickListener(listener);
    }
}
