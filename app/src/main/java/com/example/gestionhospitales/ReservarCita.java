package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gestionhospitales.adapter.AdapterEspeCita;
import com.example.gestionhospitales.adapter.AdapterEspecialidad;
import com.example.gestionhospitales.pojo.Especialidad;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReservarCita extends AppCompatActivity {

    List<Especialidad> especialidadList;

    RecyclerView rvEspeCita;

    AdapterEspeCita adapterEspCita;

    LinearLayoutManager lmEsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_cita);

        rvEspeCita = findViewById(R.id.rvEspecialidadCita);
        lmEsp = new LinearLayoutManager(this);
        rvEspeCita.setLayoutManager(lmEsp);

        especialidadList =  new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapterEspCita = new AdapterEspeCita(ReservarCita.this,especialidadList);
        rvEspeCita.setAdapter(adapterEspCita);

        database.getReference().child("Especialidades").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                especialidadList.clear();
                for(DataSnapshot snap : snapshot.getChildren()){
                    Especialidad especialidades = snap.getValue(Especialidad.class);
                    especialidadList.add(especialidades);
                }
                adapterEspCita.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}