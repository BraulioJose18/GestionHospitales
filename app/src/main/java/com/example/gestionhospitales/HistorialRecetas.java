package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gestionhospitales.adapter.AdapterHistorialExamen;
import com.example.gestionhospitales.adapter.AdapterHistorialRecetas;
import com.example.gestionhospitales.pojo.Examenes;
import com.example.gestionhospitales.pojo.Recetas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistorialRecetas extends AppCompatActivity {

    List<Recetas> listHistRec;
    RecyclerView rvHistRec;
    AdapterHistorialRecetas adapterHistRec;
    LinearLayoutManager lm;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_recetas);

        mAuth = FirebaseAuth.getInstance();

        rvHistRec = findViewById(R.id.rvHistorialRecetas);
        lm = new LinearLayoutManager(this);
        rvHistRec.setLayoutManager(lm);

        listHistRec =  new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapterHistRec = new AdapterHistorialRecetas(HistorialRecetas.this,listHistRec);
        rvHistRec.setAdapter(adapterHistRec);
        String id = mAuth.getCurrentUser().getUid();

        database.getReference().child("Recetas").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listHistRec.clear();
                for(DataSnapshot snap : snapshot.getChildren()){
                    Recetas recHist= snap.getValue(Recetas.class);
                    listHistRec.add(recHist);
                }
                adapterHistRec.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}