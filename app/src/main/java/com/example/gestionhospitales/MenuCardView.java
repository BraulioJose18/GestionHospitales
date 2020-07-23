package com.example.gestionhospitales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCardView extends AppCompatActivity {

    private CardView historial;
    private CardView calendario;
    private CardView staffmedico;
    private CardView reservas;
    private CardView perfil;
    private CardView acercade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_card_view);
        historial = (CardView) findViewById(R.id.historial);
        calendario = (CardView) findViewById(R.id.calendario);
        staffmedico = (CardView) findViewById(R.id.staff);
        reservas = (CardView) findViewById(R.id.reservas);
        perfil = (CardView) findViewById(R.id.perfil);
        acercade = (CardView) findViewById(R.id.acerca);

        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuCardView.this, MenuHistorial.class));
            }
        });
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuCardView.this, Calendario.class));
            }
        });
        staffmedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuCardView.this, EspecialidadListado.class));
            }
        });
        reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuCardView.this, Reservas.class));
            }
        });
        acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuCardView.this, About.class));
            }
        });
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuCardView.this, PerfilUsuario.class));
            }
        });
    }
}