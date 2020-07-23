package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gestionhospitales.adapter.AdapterDoc;
import com.example.gestionhospitales.pojo.Doctores;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StaffMedico extends AppCompatActivity {

    List<Doctores> listDoc;

    RecyclerView rvDoctor;

    AdapterDoc adapterDoc;

    LinearLayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_medico);

        rvDoctor = findViewById(R.id.rvDoctor);
        lm = new LinearLayoutManager(this);
        rvDoctor.setLayoutManager(lm);

        //searchView = findViewById(R.id.searchDoctor);
        listDoc =  new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapterDoc = new AdapterDoc(StaffMedico.this,listDoc);
        rvDoctor.setAdapter(adapterDoc);

        database.getReference().child("Doctores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listDoc.clear();
                for(DataSnapshot snap : snapshot.getChildren()){
                    Doctores doctor = snap.getValue(Doctores.class);
                    listDoc.add(doctor);
                }
                adapterDoc.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}