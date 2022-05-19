package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecepcionActivity extends AppCompatActivity {
    private TextView tv_Categoria, tv_Familia, tv_Producto, tv_Presentacion, tv_Estado;
    private Button btn_Regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcion);
        tv_Categoria=(TextView) findViewById(R.id.tv_Categoria);
        tv_Familia=(TextView) findViewById(R.id.tv_Familia);
        tv_Producto=(TextView) findViewById(R.id.tv_Producto);
        tv_Presentacion=(TextView) findViewById(R.id.tv_Presentacion);
        tv_Estado=(TextView) findViewById(R.id.tv_Estado);

        btn_Regresar=(Button)findViewById(R.id.btn_Regresar);

        tv_Categoria.setText("Categoria: "+getIntent().getStringExtra("categoria"));
        tv_Familia.setText("Familia: "+getIntent().getStringExtra("familia"));
        tv_Producto.setText("Producto: "+getIntent().getStringExtra("productos"));
        tv_Presentacion.setText(getIntent().getStringExtra("presentacion"));
        tv_Estado.setText(getIntent().getStringExtra("estado"));
        btn_Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });
    }

    private void regresar(){
        Intent regresar= new Intent(this, ProductoIntentActivity.class);

        startActivity(regresar);
    }

}