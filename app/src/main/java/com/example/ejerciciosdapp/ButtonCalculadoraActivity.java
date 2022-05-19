package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonCalculadoraActivity extends AppCompatActivity {

    private EditText et_Valor_1, et_Valor_2;
    private Button btn_Limpiar, btn_Sumar_Button, btn_Restar_Button, btn_Dividir_Button, btn_Multiplicar_Button;
    private TextView tv_Resultado_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_calculadora);

        et_Valor_1=(EditText) findViewById(R.id.et_Valor_1);
        et_Valor_2=(EditText) findViewById(R.id.et_Valor_2);

        btn_Limpiar=(Button)findViewById(R.id.btn_Limpiar_Button);
        btn_Sumar_Button=(Button) findViewById(R.id.btn_Sumar_Button);
        btn_Restar_Button=(Button) findViewById(R.id.btn_Restar_Button);
        btn_Dividir_Button=(Button) findViewById(R.id.btn_Dividir_Button);
        btn_Multiplicar_Button=(Button) findViewById(R.id.btn_Multiplicar_Button);

        tv_Resultado_Button=(TextView) findViewById(R.id.tv_Resultado_Button);

        btn_Sumar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sumar();
            }
        });
        btn_Restar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restar();
            }
        });
        btn_Dividir_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dividir();
            }
        });
        btn_Multiplicar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Multiplicar();
            }
        });
        btn_Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Limpiar();
            }
        });
    }
    private void Sumar() {
        Double resultado = 0.0;

        String s_num1 = et_Valor_1.getText().toString();
        String s_num2 = et_Valor_2.getText().toString();
        if (s_num1.isEmpty() || s_num2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos numeros", Toast.LENGTH_SHORT).show();
        } else {
            Double d_num1 = Double.parseDouble(s_num1);
            Double d_num2 = Double.parseDouble(s_num2);

            resultado = d_num1 + d_num2;
        }
        tv_Resultado_Button.setText(resultado.toString());
    }
    private void Restar() {
        Double resultado = 0.0;

        String s_num1 = et_Valor_1.getText().toString();
        String s_num2 = et_Valor_2.getText().toString();
        if (s_num1.isEmpty() || s_num2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos numeros", Toast.LENGTH_SHORT).show();
        } else {
            Double d_num1 = Double.parseDouble(s_num1);
            Double d_num2 = Double.parseDouble(s_num2);

            resultado = d_num1 - d_num2;
        }
        tv_Resultado_Button.setText(resultado.toString());
    }
    private void Dividir() {
        Double resultado = 0.0;

        String s_num1 = et_Valor_1.getText().toString();
        String s_num2 = et_Valor_2.getText().toString();
        if (s_num1.isEmpty() || s_num2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos numeros", Toast.LENGTH_SHORT).show();
        } else {
            Double d_num1 = Double.parseDouble(s_num1);
            Double d_num2 = Double.parseDouble(s_num2);

            resultado = d_num1 / d_num2;
        }
        tv_Resultado_Button.setText(resultado.toString());
    }
    private void Multiplicar() {
        Double resultado = 0.0;

        String s_num1 = et_Valor_1.getText().toString();
        String s_num2 = et_Valor_2.getText().toString();
        if (s_num1.isEmpty() || s_num2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos numeros", Toast.LENGTH_SHORT).show();
        } else {
            Double d_num1 = Double.parseDouble(s_num1);
            Double d_num2 = Double.parseDouble(s_num2);

            resultado = d_num1 * d_num2;
        }
        tv_Resultado_Button.setText(resultado.toString());
    }
    private void Limpiar(){
        et_Valor_1.setText("");
        et_Valor_2.setText("");
        tv_Resultado_Button.setText("RESULTADO");
    }
}