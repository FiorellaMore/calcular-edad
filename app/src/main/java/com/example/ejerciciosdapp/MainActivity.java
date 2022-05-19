package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_apellido, et_dni;
    private TextView tv_datos;
    private Button bt_concatenar, bt_limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Casting
        et_nombre=(EditText)findViewById(R.id.et_nombre);
        et_apellido=(EditText)findViewById(R.id.et_apellidos);
        et_dni=(EditText)findViewById(R.id.et_dni);

        tv_datos=(TextView)findViewById(R.id.tv_datos);

        bt_concatenar=(Button)findViewById(R.id.bt_concatenar);
        bt_limpiar=(Button)findViewById(R.id.bt_limpiar);
        bt_concatenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Concatenar();
            }
        });
        bt_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Limpiar();
            }
        });
    }
    private void Concatenar(){
        String s_nombre, s_apellidos, s_dni, s_dato;

        s_nombre=et_nombre.getText().toString();
        s_apellidos=et_apellido.getText().toString();
        s_dni=et_dni.getText().toString();
        s_dato=s_nombre+" "+s_apellidos+" con DNI: "+s_dni;

        if (s_nombre.isEmpty()){
            Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
        }else if(s_apellidos.isEmpty()){
            Toast.makeText(this, "Ingrese sus apellidos", Toast.LENGTH_SHORT).show();
        }else if(s_dni.isEmpty()){
            Toast.makeText(this, "Ingrese su DNI", Toast.LENGTH_SHORT).show();
        }else{
            tv_datos.setText(s_dato);
        }
    }
    private void Limpiar(){
        et_nombre.setText("");
        et_apellido.setText("");
        et_dni.setText("");
        tv_datos.setText("");
    }
}