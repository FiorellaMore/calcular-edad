package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

public class ProductoIntentActivity extends AppCompatActivity {
    private Spinner sp_Categoria, sp_Familia, sp_Producto;
    private RadioButton rb_Caja, rb_Bolsa, rb_Botella;
    private CheckBox cb_Mal_Estado, cb_Vencido, cb_Sin_Stock;
    private Button btn_Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_intent);

        sp_Categoria =(Spinner) findViewById(R.id.sp_Categoria);
        sp_Familia =(Spinner) findViewById(R.id.sp_Familia);
        sp_Producto =(Spinner) findViewById(R.id.sp_Producto);

        rb_Caja =(RadioButton) findViewById(R.id.rb_Caja);
        rb_Bolsa =(RadioButton) findViewById(R.id.rb_Bolsa);
        rb_Botella =(RadioButton) findViewById(R.id.rb_Botella);

        cb_Mal_Estado =(CheckBox) findViewById(R.id.cb_Mal_Estado);
        cb_Vencido =(CheckBox) findViewById(R.id.cb_Vencido);
        cb_Sin_Stock =(CheckBox) findViewById(R.id.cb_Sin_Stock);

        btn_Enviar=(Button) findViewById(R.id.btn_Enviar);

        String Categorias []={"Bebidas","Alimentos","Artefactos"};
        ArrayAdapter<String> categorias_adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Categorias);
        sp_Categoria.setAdapter(categorias_adapter );

        btn_Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar_Datos();
            }
        });

        sp_Categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String categoria= adapterView.getItemAtPosition(i).toString();
                getFamilias(categoria);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp_Familia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String familia= adapterView.getItemAtPosition(i).toString();
                getProductos(familia);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /*
        cb_Mal_Estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_Mal_Estado.isChecked()){
                    cb_Sin_Stock.setChecked(false);
                    cb_Vencido.setChecked(false);
                }
            }
        });
        cb_Sin_Stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_Sin_Stock.isChecked()){
                    cb_Mal_Estado.setChecked(false);
                    cb_Vencido.setChecked(false);
                }
            }
        });
        cb_Vencido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_Vencido.isChecked()){
                    cb_Sin_Stock.setChecked(false);
                    cb_Mal_Estado.setChecked(false);
                }
            }
        });*/
    }
    private void getFamilias(String cat){


        String Familia []= new String[3];
        if (cat=="Bebidas"){
            Familia[0]="Cerveza";
            Familia[1]="Gaseosa";
            Familia[2]="Agua";
        }else if (cat=="Alimentos"){
            Familia[0]="Postres";
            Familia[1]="Galletas";
            Familia[2]="Panes";
        }else if (cat=="Artefactos"){
            Familia[0]="Televisores";
            Familia[1]="Lavadoras";
            Familia[2]="Refrigedoras";
        }
        ArrayAdapter<String> familias_adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Familia);
        sp_Familia.setAdapter(familias_adapter);
    }
    private void getProductos(String fam){


        String Productos []= new String[3];
        if (fam=="Cerveza"){
            Productos[0]="Cerveza Pilsen";
            Productos[1]="Cerveza Cristal";
            Productos[2]="Cerveza Cuzqueña";
        }else if (fam=="Gaseosa"){
            Productos[0]="Coca Cola";
            Productos[1]="Inka cola";
            Productos[2]="Pepsi";
        }else if (fam=="Agua"){
            Productos[0]="San Carlos";
            Productos[1]="San Mateo";
            Productos[2]="San Marcos";
        }else if (fam=="Postres"){
            Productos[0]="Arroz con leche";
            Productos[1]="Flan";
            Productos[2]="Gelatina";
        }else if (fam=="Galletas"){
            Productos[0]="Galleta Rellenita";
            Productos[1]="Galleta Dore";
            Productos[2]="Galleta Soda";
        }else if (fam=="Panes") {
            Productos[0] = "Italiano";
            Productos[1] = "Frances";
            Productos[2] = "Chabata";
        }else if (fam=="Televisores"){
            Productos[0]="TV. Samsung";
            Productos[1]="TV. LG";
            Productos[2]="TV. Sony";
        }else if (fam=="Lavadoras"){
            Productos[0]="Lav. Samsung";
            Productos[1]="Lav. LG";
            Productos[2]="Lav. Sony";
        }else if (fam=="Refrigeradoras") {
            Productos[0] = "Ref. Samsung";
            Productos[1] = "Ref. LG";
            Productos[2] = "Ref. Sony";
        }

        ArrayAdapter<String> productos_adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Productos);
        sp_Producto.setAdapter(productos_adapter);
    }

    private String Datos_Presentacion(){
        String datos_Presentacion="";

        if (rb_Bolsa.isChecked()){
            datos_Presentacion="Presentancion: Bolsa";
        }else if (rb_Botella.isChecked()){
            datos_Presentacion="Presentancion: Botella";
        }else if (rb_Caja.isChecked()){
            datos_Presentacion="Presentancion: Caja";
        }
        return  datos_Presentacion;
    }
    private  String Datos_Estado(){
        String datos_Estado="";

        if (cb_Mal_Estado.isChecked()){
            datos_Estado=datos_Estado+" Producto en mal estado\n";
        }
        if (cb_Vencido.isChecked()){
            datos_Estado=datos_Estado+" Producto vencido\n";
        }
        if (cb_Sin_Stock.isChecked()){
            datos_Estado=datos_Estado+" Producto sin stock\n";
        }
        return datos_Estado;
    }
    private void enviar_Datos(){
        Intent enviar= new Intent(this, RecepcionActivity.class);

        enviar.putExtra("categoria", sp_Categoria.getSelectedItem().toString());
        enviar.putExtra("familia", sp_Familia.getSelectedItem().toString());
        enviar.putExtra("productos", sp_Producto.getSelectedItem().toString());
        enviar.putExtra("presentacion", Datos_Presentacion());
        enviar.putExtra("estado",Datos_Estado());
        startActivity(enviar);
    }


}