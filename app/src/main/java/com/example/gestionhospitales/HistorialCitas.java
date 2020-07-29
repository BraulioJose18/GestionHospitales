package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gestionhospitales.adapter.AdapterDoc;
import com.example.gestionhospitales.adapter.AdapterHistorialCitas;
import com.example.gestionhospitales.pojo.CitasHist;
import com.example.gestionhospitales.pojo.Doctores;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistorialCitas extends AppCompatActivity {

    List<CitasHist> listHistorialCita;
    RecyclerView rvHistorialCita;
    AdapterHistorialCitas adapterHistorialCitas;
    LinearLayoutManager lm;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_citas);

        mAuth = FirebaseAuth.getInstance();

        rvHistorialCita = findViewById(R.id.rvHistorialCita);
        lm = new LinearLayoutManager(this);
        rvHistorialCita.setLayoutManager(lm);

        listHistorialCita =  new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapterHistorialCitas = new AdapterHistorialCitas(HistorialCitas.this,listHistorialCita);
        rvHistorialCita.setAdapter(adapterHistorialCitas);
        String id = mAuth.getCurrentUser().getUid();

        database.getReference().child("Citas").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listHistorialCita.clear();
                for(DataSnapshot snap : snapshot.getChildren()){
                    CitasHist citaHist= snap.getValue(CitasHist.class);
                    listHistorialCita.add(citaHist);
                }
                adapterHistorialCitas.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}