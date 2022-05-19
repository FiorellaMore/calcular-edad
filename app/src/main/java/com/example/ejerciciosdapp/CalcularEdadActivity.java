package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class CalcularEdadActivity extends AppCompatActivity {
    private TextView tv_fecha_Nacimiento, tv_Mostrar_Edad;
    private int dia, mes, annio;
    private Button btn_Calcular_Edad;
    private String fechaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_edad);

        tv_fecha_Nacimiento=(TextView) findViewById(R.id.tv_fecha_Nacimiento);
        tv_Mostrar_Edad=(TextView) findViewById(R.id.tv_Mostrar_Edad);
        btn_Calcular_Edad=(Button)findViewById(R.id.btn_Calcular_Edad);

        tv_fecha_Nacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FechaNacimiento();
            }
        });
        btn_Calcular_Edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaNac=simpleDateFormat.parse(tv_fecha_Nacimiento.getText().toString());
                    Date fechaAct=simpleDateFormat.parse(fechaActual);
                    tv_Mostrar_Edad.setText(calcularEdad(fechaNac,fechaAct));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        final Calendar calendar=Calendar.getInstance();
        dia=calendar.get(Calendar.DAY_OF_MONTH);
        mes=calendar.get(Calendar.MONTH);
        annio=calendar.get(Calendar.YEAR);
        tv_fecha_Nacimiento.setText(dateFormat(dia,mes,annio));
        fechaActual =dateFormat(dia, mes, annio);

    }

    private void FechaNacimiento(){
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                int mes=i1+1;
                tv_fecha_Nacimiento.setText(dateFormat(i2,i1,i));
            }
        },annio, mes,dia);
        datePickerDialog.show();
    }
    private String dateFormat(int d, int m, int y){
        String s_mes, dia, fecha="";
        int mes;

        if (d<10){
            dia="0"+d;
        }else{
            dia=String.valueOf(d);
        }

        mes=m+1;
        if (mes<10){
            s_mes="0"+mes;
        }else {
            s_mes=String.valueOf(m);
        }
        fecha=dia+"/"+s_mes+"/"+y;
        return fecha;
    }
    private String calcularEdad(Date fechaNac, Date fechaActual){

        int annios = (int)((fechaActual.getTime()-fechaNac.getTime())/3.154e+10 );
        String resultado =annios+ " Año(s)";


        return resultado;
    }
}