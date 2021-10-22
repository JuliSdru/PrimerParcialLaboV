package com.example.primerparcial;

import android.view.View;

public class OnClickEdit  implements View.OnClickListener {

    ProductoControler productoControler;
    Edit_activity edit_activity;

    public OnClickEdit(ProductoControler productoControler, Edit_activity edit_activity) {

        this.productoControler = productoControler;
        this.edit_activity = edit_activity;
    }

    @Override
    public void onClick(View v) {
        this.productoControler.getValores();
        this.edit_activity.finish();
    }
}
