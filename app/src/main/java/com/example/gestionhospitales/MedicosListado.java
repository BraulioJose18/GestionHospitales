package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.gestionhospitales.adapter.AdapterMed;
import com.example.gestionhospitales.pojo.Doctores;
import com.example.gestionhospitales.pojo.Medicos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicosListado extends AppCompatActivity {

    List<Medicos> listMed;

    RecyclerView rvMedicos;

    AdapterMed adapterMedicos;

    LinearLayoutManager lmMedicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_listado);

        rvMedicos = findViewById(R.id.rvMedicos);
        lmMedicos = new LinearLayoutManager(this);
        rvMedicos.setLayoutManager(lmMedicos);

        Bundle extraEsp = getIntent().getExtras();
        String extra = "";
        if(extraEsp != null){
            extra = extraEsp.getString("nameEspe");
        }

        //searchView = findViewById(R.id.searchDoctor);
        listMed =  new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapterMedicos = new AdapterMed(MedicosListado.this,listMed);
        rvMedicos.setAdapter(adapterMedicos);
        database.getReference().child("EspecialidadMedico/"+extra).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listMed.clear();
                for(DataSnapshot snap : snapshot.getChildren()){
                    String val = snap.getKey();
                    Log.d("Valor de la key: ",val);
                    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                    database1.getReference().child("Medicos").orderByKey().equalTo(val).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot snap : snapshot.getChildren()) {
                                Medicos medico = snap.getValue(Medicos.class);
                                listMed.add(medico);
                            }
                            adapterMedicos.notifyDataSetChanged();
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}