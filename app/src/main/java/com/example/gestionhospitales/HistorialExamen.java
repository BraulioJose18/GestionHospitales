package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gestionhospitales.adapter.AdapterHistorialCitas;
import com.example.gestionhospitales.adapter.AdapterHistorialExamen;
import com.example.gestionhospitales.pojo.CitasHist;
import com.example.gestionhospitales.pojo.Examenes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistorialExamen extends AppCompatActivity {


    List<Examenes> listHistExam;
    RecyclerView rvHistExam;
    AdapterHistorialExamen adapterHistExam;
    LinearLayoutManager lm;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_examen);

        mAuth = FirebaseAuth.getInstance();

        rvHistExam = findViewById(R.id.rvHistorialExamenes);
        lm = new LinearLayoutManager(this);
        rvHistExam.setLayoutManager(lm);

        listHistExam =  new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapterHistExam = new AdapterHistorialExamen(HistorialExamen.this,listHistExam);
        rvHistExam.setAdapter(adapterHistExam);
        String id = mAuth.getCurrentUser().getUid();

        database.getReference().child("Examenes").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listHistExam.clear();
                for(DataSnapshot snap : snapshot.getChildren()){
                    Examenes examHist= snap.getValue(Examenes.class);
                    listHistExam.add(examHist);
                }
                adapterHistExam.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}