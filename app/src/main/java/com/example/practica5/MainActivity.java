package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button cfecha, chora;
    EditText cEfecha, cEhora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cfecha = (Button) findViewById(R.id.gFecha);
        chora = (Button) findViewById(R.id.gHora);
        cEfecha = (EditText) findViewById(R.id.gEfecha);
        cEhora = (EditText) findViewById(R.id.gEHora);
        cfecha.setOnClickListener(this);
        chora.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int dia, mes, anio;
        int hora, minuto;

        if(v == cfecha){
            final Calendar c= Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datepicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    cEfecha.setText(day + " / " + ( month+1)+ " / " + year);
                }
            },anio,mes,dia);
            datepicker.show();
        }

        if (v == chora){
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);

            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hday, int mint) {
                    cEhora.setText(hday+":"+mint);
                }
            },hora, minuto, false);
            tpd.show();
        }
    }
}