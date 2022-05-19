package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    private EditText et_num1, et_num2;
    private RadioButton rb_Suma, rb_Resta, rb_Dividir, rb_Multiplicar;
    private TextView tv_Resultado_rb;
    private Button btn_Calcular_rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        et_num1=(EditText) findViewById(R.id.et_num1);
        et_num2=(EditText) findViewById(R.id.et_num2);

        rb_Suma=(RadioButton) findViewById(R.id.rb_Sumar);
        rb_Resta=(RadioButton) findViewById(R.id.rb_Restar);
        rb_Dividir=(RadioButton) findViewById(R.id.rb_Dividir);
        rb_Multiplicar=(RadioButton) findViewById(R.id.rb_Multiplicar);

        tv_Resultado_rb=(TextView) findViewById(R.id.tv_Resultado_rb);

        btn_Calcular_rb=(Button) findViewById(R.id.btn_Calcular_rb);
        btn_Calcular_rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcular();
            }
        });
    }
    private void Calcular(){
        Double resultado=0.0;

        String s_num1=et_num1.getText().toString();
        String s_num2=et_num2.getText().toString();
        if (s_num1.isEmpty() || s_num2.isEmpty()){
            Toast.makeText(this, "Ingrese ambos numeros", Toast.LENGTH_SHORT).show();
        }else{
            Double d_num1=Double.parseDouble(s_num1);
            Double d_num2=Double.parseDouble(s_num2);

            if (rb_Suma.isChecked()){
                resultado=d_num1+d_num2;
            }else if (rb_Resta.isChecked()){
                resultado=d_num1-d_num2;
            }else if (rb_Dividir.isChecked()){
                resultado=d_num1/d_num2;
            }else if (rb_Multiplicar.isChecked()){
                resultado=d_num1*d_num2;
            }
        }
        tv_Resultado_rb.setText(resultado.toString());
    }
}