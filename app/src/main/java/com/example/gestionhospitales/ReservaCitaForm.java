package com.example.gestionhospitales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.gestionhospitales.pojo.CitasHist;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ReservaCitaForm extends AppCompatActivity implements View.OnClickListener {

    EditText editEspeResCitForm;
    EditText editMedResCitForm;

    EditText editFechaCitForm;
    EditText editHoraCitForm;

    Button botonFecha;
    Button botonHora;
    Button verificar;

    private int dia,mes,year, hora, minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_cita_form);
        editEspeResCitForm =  findViewById(R.id.editEspeResCitForm);
        editMedResCitForm =  findViewById(R.id.editMedResCitForm);

        editFechaCitForm =  findViewById(R.id.editFechaCitForm);
        editHoraCitForm =  findViewById(R.id.editHoraCitForm);

        botonFecha = findViewById(R.id.buttonFecha);
        botonHora = findViewById(R.id.buttonHora);

        botonFecha.setOnClickListener(this);
        botonHora.setOnClickListener(this);

        Bundle nameDoctor = getIntent().getExtras();
        String eNameDoctor = "";
        if(nameDoctor != null){
            eNameDoctor= nameDoctor.getString("nameDoctor");
        }
        Bundle espeDoctor = getIntent().getExtras();
        String eEspeDoctor = "";
        if(espeDoctor != null){
            eEspeDoctor= espeDoctor.getString("espeDoctor");
        }
        editEspeResCitForm.setText(eEspeDoctor);
        editMedResCitForm.setText(eNameDoctor);
        //Deshabilitar
        editMedResCitForm.setEnabled(false);
        editEspeResCitForm.setEnabled(false);

        verificar = findViewById(R.id.VerificarReserva);
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEmergencyDialog();
            }
        });
    }

    private void showEmergencyDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ReservaCitaForm.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(ReservaCitaForm.this).inflate(
                R.layout.ventana_emergente,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.confirm_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.text_confirm));
        ((Button) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.cancel));
        ((Button) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.confirm));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_info);
        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diag = "Esperando Cita";
                FirebaseAuth auth =FirebaseAuth.getInstance();
                String user = auth.getCurrentUser().getUid();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("Citas").child(user);
                CitasHist citas = new CitasHist(diag,editEspeResCitForm.getText().toString(),editFechaCitForm.getText().toString(),
                        editHoraCitForm.getText().toString(),editMedResCitForm.getText().toString());
                myRef.push().setValue(citas);
                alertDialog.dismiss();
                Toast.makeText(ReservaCitaForm.this,"Cita Reservada con éxito", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ReservaCitaForm.this, MenuCardView.class));
            }
        });
        view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(ReservaCitaForm.this,"Escoja su horario", Toast.LENGTH_SHORT).show();
            }
        });


        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    @Override
    public void onClick(View view) {
        if(view == botonFecha){
            final Calendar c= Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            year = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    editFechaCitForm.setText(day+"/"+(month+1)+"/"+year);

                }
            },year,mes,dia);
            datePickerDialog.show();
        }
        if(view == botonHora){
            final Calendar c= Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    if(minute==0){
                        editHoraCitForm.setText(hour+":"+minute+"0");
                    }else {
                        editHoraCitForm.setText(hour + ":" + minute);
                    }
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }

    }
}