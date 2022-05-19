package com.example.ejerciciosdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class dateTimeActivity extends AppCompatActivity {
    private TextView tv_Fecha_1, tv_Fecha_2, tv_Diferencia_Fechas,tv_Hora_1, tv_Hora_2, tv_Diferencia_Horas;
    private int dia, mes, annio, hora, min;
    private Button btn_Diferencia_Fechas,btn_Diferencia_Horas;
    private Spinner sp_unidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        tv_Fecha_1=(TextView) findViewById(R.id.tv_Fecha_1);
        tv_Fecha_2=(TextView) findViewById(R.id.tv_Fecha_2);
        tv_Diferencia_Fechas=(TextView)findViewById(R.id.tv_Diferencia_Fechas);
        btn_Diferencia_Fechas=(Button)findViewById(R.id.btn_Diferencia_Fechas);
        tv_Hora_1=(TextView) findViewById(R.id.tv_Hora_1);
        tv_Hora_2=(TextView) findViewById(R.id.tv_Hora_2);
        tv_Diferencia_Horas=(TextView)findViewById(R.id.tv_Diferencia_Horas);
        btn_Diferencia_Horas=(Button)findViewById(R.id.btn_Diferencia_Horas);
        sp_unidad=(Spinner)findViewById(R.id.sp_unidad);
        tv_Fecha_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalendarI();
            }
        });
        tv_Fecha_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalendarII();
            }
        });
        btn_Diferencia_Fechas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha1=simpleDateFormat.parse(tv_Fecha_1.getText().toString());
                    Date fecha2=simpleDateFormat.parse(tv_Fecha_2.getText().toString());
                    tv_Diferencia_Fechas.setText(calcularDias(fecha1,fecha2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        final Calendar calendar=Calendar.getInstance();
        dia=calendar.get(Calendar.DAY_OF_MONTH);
        mes=calendar.get(Calendar.MONTH);
        annio=calendar.get(Calendar.YEAR);
        hora=calendar.get(Calendar.HOUR_OF_DAY);
        min=calendar.get(Calendar.MINUTE);
        tv_Fecha_1.setText(dateFormat(dia,mes,annio));
        tv_Fecha_2.setText(dateFormat(dia,mes,annio));
        tv_Hora_1.setText(timeFormat(hora,min));
        tv_Hora_2.setText(timeFormat(hora,min));

        String unidad []={"Minutos","Segundos"};
        ArrayAdapter<String> unidaAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,unidad);
        sp_unidad.setAdapter(unidaAdapter);

        tv_Hora_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hora1();
            }
        });
        tv_Hora_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hora2();
            }
        });
        btn_Diferencia_Horas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_Diferencia_Horas.setText(calcularMinutos(tv_Hora_1.getText().toString(),tv_Hora_2.getText().toString(),sp_unidad.getSelectedItem().toString()));
            }
        });
    }
    private void CalendarI(){
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                int mes=i1+1;
                tv_Fecha_1.setText(dateFormat(i2,i1,i));
            }
        },annio, mes,dia);
        datePickerDialog.show();
    }
    private void CalendarII(){
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                int mes=i1+1;
                tv_Fecha_2.setText(dateFormat(i2,i1,i));
            }
        },annio, mes,dia);
        datePickerDialog.show();
    }
    private void Hora1(){
        TimePickerDialog timePickerDialog =new TimePickerDialog(this, AlertDialog.THEME_HOLO_DARK, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                tv_Hora_1.setText(timeFormat(i,i1));
            }
        },hora,min,true);
        timePickerDialog.show();
    }
    private void Hora2(){
        TimePickerDialog timePickerDialog =new TimePickerDialog(this,AlertDialog.THEME_HOLO_DARK, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                tv_Hora_2.setText(timeFormat(i,i1));
            }
        },hora,min,true);
        timePickerDialog.show();
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
    private String timeFormat(int h, int m){
        String s_hora, s_minuto, hora="";

        if (h<10){
            s_hora="0"+h;
        }else{
            s_hora=String.valueOf(h);
        }
        if (m<10){
            s_minuto="0"+m;
        }else{
            s_minuto=String.valueOf(m);
        }
        hora=s_hora+":"+s_minuto;
        return hora;
    }
    private String calcularDias(Date fecha1, Date fecha2){
        int dias = (int)((fecha2.getTime()-fecha1.getTime())/86400000);
        String resultado =dias+ " dia(s)";


        return resultado;
    }
    private String calcularMinutos(String hora1, String hora2, String unidad){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime h1 = LocalTime.parse(hora1,dateTimeFormatter);
        LocalTime h2 = LocalTime.parse(hora2,dateTimeFormatter);
        int min1, min2;

        if (unidad=="Minutos") {
            min1 = h1.getHour() * 60 + h1.getMinute();
            min2 = h2.getHour() * 60 + h2.getMinute();
        }else{
            min1 = h1.getHour() * 3600 + h1.getMinute()*60;
            min2 = h2.getHour() * 3600 + h2.getMinute()*60;
        }

        int i_resultado =min2-min1;

        String resultado=String.valueOf(i_resultado);

        return resultado;
    }
}