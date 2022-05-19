package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxSpinnerActivity extends AppCompatActivity {

    private EditText et_Num_1, et_Num_2;
    private CheckBox cb_Sumar, cb_Restar, cb_Dividir, cb_Multiplicar;
    private TextView tv_Resultado_CB, tv_Resultado_Spinner;
    private Button btn_Calcular_CB;
    private Spinner sp_Operacion;

    private String s_num1, s_num2, s_resultado;
    private Double d_num1, d_num2, d_resultado, d_resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_spinner);

        et_Num_1=(EditText) findViewById(R.id.et_Num_1);
        et_Num_2=(EditText) findViewById(R.id.et_Num_2);

        cb_Sumar=(CheckBox) findViewById(R.id.cb_Sumar);
        cb_Restar=(CheckBox) findViewById(R.id.cb_Restar);
        cb_Dividir=(CheckBox) findViewById(R.id.cb_Dividir);
        cb_Multiplicar=(CheckBox) findViewById(R.id.cb_Multiplicar);

        tv_Resultado_CB=(TextView) findViewById(R.id.tv_Resultado_CB);
        tv_Resultado_Spinner=(TextView)findViewById(R.id.tv_Resultado_Spinner);

        btn_Calcular_CB=(Button) findViewById(R.id.btn_Calcular_CB);

        sp_Operacion=(Spinner)findViewById(R.id.sp_Operacion_Spinner);

        btn_Calcular_CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s_num1=et_Num_1.getText().toString();
                s_num2=et_Num_2.getText().toString();

                if(s_num1.isEmpty()||s_num2.isEmpty()){
                    Toast.makeText(CheckBoxSpinnerActivity.this, "Ingrese ambos numeros", Toast.LENGTH_SHORT).show();
                }else{
                    d_num1=Double.parseDouble(s_num1);
                    d_num2=Double.parseDouble(s_num2);

                    operacionesCheckBox();
                    operacionesSpinner();
                }
            }
        });
        String operaciones []={"Sumar","Restar","Dividir","Multiplicar"};
        ArrayAdapter <String> sp_adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,operaciones);
        sp_Operacion.setAdapter(sp_adapter);
    }
    private void operacionesCheckBox(){
        s_resultado="";
        d_resultado=0.0;

        if (cb_Sumar.isChecked()){
            d_resultado=d_num1+d_num2;
            s_resultado=s_resultado+"La suma es: "+d_resultado+"\n";
        }
        if (cb_Restar.isChecked()){
            d_resultado=d_num1-d_num2;
            s_resultado=s_resultado+"La resta es: "+d_resultado+"\n";
        }
        if (cb_Dividir.isChecked()){
            if (d_num2==0){
                Toast.makeText(this, "No se puede dividir con un 0", Toast.LENGTH_SHORT).show();
            }else{
                d_resultado=d_num1/d_num2;
                s_resultado=s_resultado+"La division es: "+d_resultado+"\n";
            }
        }
        if (cb_Multiplicar.isChecked()){
            d_resultado=d_num1*d_num2;
            s_resultado=s_resultado+"La multiplicacion es: "+d_resultado+"\n";
        }

        tv_Resultado_CB.setText(s_resultado);
    }
    private void operacionesSpinner(){
        d_resultado2=0.0;
        String operacion=sp_Operacion.getSelectedItem().toString();
        if (operacion=="Sumar"){
            d_resultado2=d_num1+d_num2;
        }else if (operacion=="Restar"){
            d_resultado2=d_num1-d_num2;
        }else if (operacion=="Dividir"){
            if (d_num2==0){
                Toast.makeText(this, "No se puede dividir con un 0", Toast.LENGTH_SHORT).show();
            }else{
            d_resultado2=d_num1/d_num2;}
        }else if (operacion=="Multiplicar"){
            d_resultado2=d_num1*d_num2;
        }
        tv_Resultado_Spinner.setText(d_resultado2.toString());


    }
}