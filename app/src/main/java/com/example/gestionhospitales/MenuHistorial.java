package com.example.gestionhospitales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuHistorial extends AppCompatActivity {

    private CardView historialCitas;
    private CardView historialExam;
    private CardView historialRecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_historial);

        historialCitas = (CardView) findViewById(R.id.historialCitas);
        historialExam = (CardView) findViewById(R.id.historialExamenes);
        historialRecetas = (CardView) findViewById(R.id.historialRecetas);

        historialCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHistorial.this, HistorialCitas.class));
            }
        });
        historialExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHistorial.this, HistorialExamen.class));
            }
        });
        historialRecetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHistorial.this, HistorialRecetas.class));
            }
        });
    }
}