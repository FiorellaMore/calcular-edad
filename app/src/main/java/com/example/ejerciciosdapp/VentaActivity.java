package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VentaActivity extends AppCompatActivity {

    private EditText et_Cliente, et_Dni_Venta,et_Producto_1,et_Cantidad_1,et_Precio_1,et_Producto_2,et_Cantidad_2,et_Precio_2, et_Producto_3,et_Cantidad_3,et_Precio_3;
    private TextView tv_Subtotal_1,tv_Subtotal_2,tv_Subtotal_3,tv_Base_Imponible,tv_IGV,tv_Venta_Total;
    private Button btn_Calcular_Venta, btn_Limpiar_Venta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);

        setTitle("Venta de Productos");

        et_Cliente=(EditText)findViewById(R.id.et_Cliente);
        et_Dni_Venta=(EditText) findViewById(R.id.et_Dni_Venta);

        et_Producto_1=(EditText)findViewById(R.id.et_Producto_1);
        et_Producto_2=(EditText)findViewById(R.id.et_Producto_2);
        et_Producto_3=(EditText)findViewById(R.id.et_Producto_3);

        et_Cantidad_1=(EditText) findViewById(R.id.et_Cantidad_1);
        et_Cantidad_2=(EditText) findViewById(R.id.et_Cantidad_2);
        et_Cantidad_3=(EditText) findViewById(R.id.et_Cantidad_3);

        et_Precio_1=(EditText) findViewById(R.id.et_Precio_1);
        et_Precio_2=(EditText) findViewById(R.id.et_Precio_2);
        et_Precio_3=(EditText) findViewById(R.id.et_Precio_3);

        tv_Subtotal_1=(TextView) findViewById(R.id.tv_Subtotal_1);
        tv_Subtotal_2=(TextView) findViewById(R.id.tv_Subtotal_2);
        tv_Subtotal_3=(TextView) findViewById(R.id.tv_Subtotal_3);

        tv_Base_Imponible=(TextView) findViewById(R.id.tv_Base_Imponible);
        tv_IGV=(TextView) findViewById(R.id.tv_IGV);
        tv_Venta_Total=(TextView) findViewById(R.id.tv_Venta_Total);

        btn_Calcular_Venta=(Button) findViewById(R.id.btn_Calcular_Venta);
        btn_Limpiar_Venta=(Button) findViewById(R.id.btn_Limpiar_Venta);

        btn_Calcular_Venta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CalcularVenta();
            }
        });

        btn_Limpiar_Venta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Limpiar();
            }
        });
    }
    private void CalcularVenta(){

        String  s_Cantidad_1,s_Cantidad_2,s_Cantidad_3, s_Precio_1, s_Precio_2, s_Precio_3;
        Double d_Cantidad_1,d_Cantidad_2,d_Cantidad_3, d_Precio_1, d_Precio_2, d_Precio_3,d_Base_Imponible,d_IGV, d_Venta_Total, d_SubTotal_1, d_SubTotal_2, d_SubTotal_3;

        s_Cantidad_1=et_Cantidad_1.getText().toString();
        s_Cantidad_2=et_Cantidad_2.getText().toString();
        s_Cantidad_3=et_Cantidad_3.getText().toString();

        s_Precio_1=et_Precio_1.getText().toString();
        s_Precio_2=et_Precio_2.getText().toString();
        s_Precio_3=et_Precio_3.getText().toString();

        if (s_Cantidad_1.isEmpty() && s_Precio_1.isEmpty()) {
            Toast.makeText(this, "Ingrese cantidad y precio del producto 1", Toast.LENGTH_SHORT).show();
        }else if (s_Cantidad_2.isEmpty() && s_Precio_2.isEmpty()){
            Toast.makeText(this, "Ingrese cantidad y precio del producto 2", Toast.LENGTH_SHORT).show();
        }else if (s_Cantidad_3.isEmpty() && s_Precio_3.isEmpty()){
            Toast.makeText(this, "Ingrese cantidad y precio del producto 3", Toast.LENGTH_SHORT).show();
        }

        d_Cantidad_1=Double.parseDouble(s_Cantidad_1);
        d_Cantidad_2=Double.parseDouble(s_Cantidad_2);
        d_Cantidad_3=Double.parseDouble(s_Cantidad_3);

        d_Precio_1=Double.parseDouble(s_Precio_1);
        d_Precio_2=Double.parseDouble(s_Precio_2);
        d_Precio_3=Double.parseDouble(s_Precio_3);


        d_SubTotal_1=d_Cantidad_1 * d_Precio_1;
        d_SubTotal_2=d_Cantidad_2 * d_Precio_2;
        d_SubTotal_3=d_Cantidad_3 * d_Precio_3;

        tv_Subtotal_1.setText(d_SubTotal_1.toString());
        tv_Subtotal_2.setText(d_SubTotal_2.toString());
        tv_Subtotal_3.setText(d_SubTotal_3.toString());

        d_Base_Imponible=d_SubTotal_1 + d_SubTotal_2 + d_SubTotal_3;
        d_IGV =d_Base_Imponible * 0.18;
        d_Venta_Total= d_Base_Imponible +d_IGV;

        tv_Base_Imponible.setText("Base Imponible: "+d_Base_Imponible);
        tv_IGV.setText("IGV: "+d_IGV);
        tv_Venta_Total.setText("La venta total es: "+ d_Venta_Total);


    }

    private void Limpiar(){

        et_Cliente.setText("");
        et_Dni_Venta.setText("");

        et_Producto_1.setText("");
        et_Producto_2.setText("");
        et_Producto_3.setText("");


        et_Cantidad_1.setText("");
        et_Cantidad_2.setText("");
        et_Cantidad_3.setText("");

        et_Precio_1.setText("");
        et_Precio_2.setText("");
        et_Precio_3.setText("");

        tv_Subtotal_1.setText("SubTotal");
        tv_Subtotal_2.setText("SubTotal");
        tv_Subtotal_3.setText("SubTotal");

        tv_Base_Imponible.setText("Base Imponible: ");
        tv_IGV.setText("IGV: ");
        tv_Venta_Total.setText("Venta Total: ");

    }
}