package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView tv_Operacion, tv_Resultador_Calculadora;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_Suma, btn_Restar, btn_Dividir, btn_Multiplicar, btn_CE, btn_Igual;
    private String operacion="",operacion2="",operador="";
    private Double num1,num2, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        setTitle("Calculadora Bàsica");

        tv_Operacion=(TextView) findViewById(R.id.tv_Operacion);
        tv_Resultador_Calculadora=(TextView)findViewById(R.id.tv_Resultador_Calculadora);

        btn_0=(Button) findViewById(R.id.btn_0);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9=(Button) findViewById(R.id.btn_9);

        btn_Suma=(Button) findViewById(R.id.btn_Suma);
        btn_Restar=(Button) findViewById(R.id.btn_Resta);
        btn_Dividir=(Button) findViewById(R.id.btn_Dividir);
        btn_Multiplicar=(Button) findViewById(R.id.btn_Multiplicar);
        btn_Igual=(Button) findViewById(R.id.btn_Igual);
        btn_CE=(Button) findViewById(R.id.btn_CE);

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"9";
                operacion2=operacion2+"9";
                tv_Operacion.setText(operacion);
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"8";
                operacion2=operacion2+"8";
                tv_Operacion.setText(operacion);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"7";
                operacion2=operacion2+"7";
                tv_Operacion.setText(operacion);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"6";
                operacion2=operacion2+"6";
                tv_Operacion.setText(operacion);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"5";
                operacion2=operacion2+"5";
                tv_Operacion.setText(operacion);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"4";
                operacion2=operacion2+"4";
                tv_Operacion.setText(operacion);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"3";
                operacion2=operacion2+"3";
                tv_Operacion.setText(operacion);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"2";
                operacion2=operacion2+"2";
                tv_Operacion.setText(operacion);
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"1";
                operacion2=operacion2+"1";
                tv_Operacion.setText(operacion);
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"0";
                operacion2=operacion2+"0";
                tv_Operacion.setText(operacion);
            }
        });
        btn_Suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"+";
                tv_Operacion.setText(operacion);
                operador="+";
                num1=Double.parseDouble(operacion2);
                operacion2="";
            }
        });
        btn_Restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"-";
                tv_Operacion.setText(operacion);
                operador="-";
                num1=Double.parseDouble(operacion2);
                operacion2="";
            }
        });
        btn_Multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"*";
                tv_Operacion.setText(operacion);
                operador="*";
                num1=Double.parseDouble(operacion2);
                operacion2="";
            }
        });
        btn_Dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=operacion+"/";
                tv_Operacion.setText(operacion);
                operador="/";
                num1=Double.parseDouble(operacion2);
                operacion2="";
            }
        });

        btn_CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_Operacion.setText("0.0");
                tv_Resultador_Calculadora.setText("0.0");
                operacion="";
                operacion2="";
            }
        });
        btn_Igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2=Double.parseDouble(operacion2);
                if (operador == "+") {
                    resultado=num1+num2;
                }else if (operador=="-"){
                    resultado=num1-num2;
                }else if (operador=="*"){
                    resultado=num1*num2;
                }else if (operador=="/"){
                    resultado=num1/num2;
                }
                operacion2=resultado.toString();
                tv_Resultador_Calculadora.setText(resultado.toString());
            }
        });
    }
}